package com.example.Sales.service;

import com.example.Sales.model.Items;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="item-service", url="localhost:8081")
//@FeignClient(name="item-service")
@FeignClient(name="zuul-gateway", fallback = HystrixProxyFallBack.class)
@RibbonClient(name="item-service")
public interface ItemServiceProxy {
    //getItemByName
//    @GetMapping("//items/{name}")
    @GetMapping("item-service/item-api/items/{name}")
    Items getItemByName(@PathVariable String name);

    //getAll
//    @GetMapping("/items")
    @GetMapping("item-service/item-api/items")
    List<Items> getAllItems();

}
