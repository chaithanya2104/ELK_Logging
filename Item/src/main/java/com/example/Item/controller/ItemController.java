package com.example.Item.controller;

import com.example.Item.model.Items;
import com.example.Item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.springframework.web.bind.annotation.*;
import static net.logstash.logback.marker.Markers.append;

import java.util.List;

@RestController
public class ItemController {

    @Value("${spring.application.name}")
    private String appName;

    private static final Logger  logger = LoggerFactory.getLogger("com.example.item.controller.ItemController");
    //    @Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    //addItem
    @PostMapping(value = "/items",produces = "application/json")
    public Items add(@RequestBody Items items){
        logger.info(String.format("addItems() method in %s is invoked",appName));
        logger.info(String.format("Items being added: "+ items));
//        logger.info(String.valueOf(append("Items being added ",items)));
        return itemService.add(items);
    }

    //getAll
    @GetMapping("/items")
    public List<Items> getAllItems(){

        long start = System.currentTimeMillis();
        List<Items> itemsList= itemService.getAll();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        logger.info(String.format(" getAllItems() method in %s invoked",appName));
        logger.info(String.format("Items returned: "+ itemsList +"Time Lapsed: "+ timeElapsed +"ms"));
        MDC.put("Items", String.valueOf(itemsList));

        return itemsList;

    }

    //getItemByName
    @GetMapping("/items/{name}")
    public Items getItemByName(@PathVariable String name){
        logger.info(String.format("%s getItemByName() method invoked",appName));
        logger.info(String.format("Items returned for name: ", name + itemService.getAll()));
        return itemService.getItemByName(name);
    }

    @GetMapping("/items/hystrix-fault-tolerance")
    @HystrixCommand(fallbackMethod = "faultToleranceFallbackMethod")
    public Items testFaultTolerance(){
        logger.info(String.format("testFaultTolerance() method in %s is invoked",appName));
        System.out.println("fault tolerance of Items ");
        throw  new RuntimeException(" there was an error in execution");
    }

    public Items faultToleranceFallbackMethod(){
        logger.info(String.format("faultToleranceFallbackMethod() method in %s invoked",appName));
        System.out.println("hey something went wrong in the original method so we are here in fallback...");
        Items dummyObject = new Items("dummy name", 99.99, "dummydescription");
        return dummyObject;
    }

}
