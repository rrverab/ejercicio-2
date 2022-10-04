package com.gestion.items.servicio;


import com.gestion.items.entidades.Item;
import com.gestion.items.repositorio.ItemsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServicio {

    @Autowired
    ItemsRepositorio itemsRepositorio;

    public List<Item> ListAll(){

        return itemsRepositorio.findAll();
    }

    public Item FinbyId(Long id){
        return itemsRepositorio.findById(id).get();

    }

    public Item updateItems(Item item, Long id){

        Item item1 =  itemsRepositorio.findById(id).get();

       if (item1 != null){
           return itemsRepositorio.save(item1);
       }


        return item1;

    }

    public Item saveItem(Item item){

        return itemsRepositorio.save(item);

    }

    public void deletedItems(Long id){
        itemsRepositorio.deleteById(id);
    }



}
