package com.gestion.items.servicio;


import com.gestion.items.entidades.Items;
import com.gestion.items.repositorio.ItemsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServicio {

    @Autowired
    ItemsRepositorio itemsRepositorio;

    public List<Items> ListAll(){

        return itemsRepositorio.findAll();
    }

    public Items FinbyId(Long id){
        return itemsRepositorio.findById(id).get();

    }

    public Items updateItems(Items item,Long id){

        Items item1 =  itemsRepositorio.findById(id).get();

       if (item1 != null){
           return itemsRepositorio.save(item1);
       }


        return item1;

    }

    public Items saveItem(Items item){

        return itemsRepositorio.save(item);

    }

    public void deletedItems(Long id){
        itemsRepositorio.deleteById(id);
    }



}
