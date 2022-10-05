package com.gestion.items.servicio;


import com.gestion.items.entidades.Item;
import com.gestion.items.dto.ItemDto;
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

    public Item updateItems(ItemDto itemDto, Long id){

        Item item =  itemsRepositorio.findById(id).get();

         item.setCapacidad(itemDto.getCapacidad());
        item.setNombre(itemDto.getNombre());
        item.setEnvase(itemDto.getEnvase());
        item.setTipo(itemDto.getTipo());
        item.setNevera(itemDto.getNevera());


        return itemsRepositorio.save(item);




    }

    public Item saveItem(Item item){

        return itemsRepositorio.save(item);

    }

    public void deletedItems(Long id){
        itemsRepositorio.deleteById(id);
    }



}
