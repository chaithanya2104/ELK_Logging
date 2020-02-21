package com.example.Item.service;

import com.example.Item.model.Items;
import com.example.Item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

//    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    //addItem
    public Items add(Items item){
       return itemRepository.save(item);
    }

    //getAll()
    public List<Items> getAll(){
        return itemRepository.findAll();
    }

    //getItemByName(String name)
    public Items getItemByName(String name){
        Optional<Items> items = itemRepository.findByName(name);
        if(items.isPresent())
            return items.get();
        else{
            return null;
        }

    }

}
