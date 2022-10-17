package com.gestion.items.servicio;


import com.gestion.items.dto.ItemDto;
import com.gestion.items.entidades.Item;
import com.gestion.items.excepciones.NotFoundException;
import com.gestion.items.repositorio.ItemsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsServicio {

    @Autowired
    ItemsRepositorio itemsRepositorio;

    public List<Item> ListAll(){

        return itemsRepositorio.findAll();
    }

    public Item FinbyId(Long id){
        Optional<Item> item = itemsRepositorio.findById(id);
        if (item.isEmpty()) {
            throw new NotFoundException("Item con id " + id + " no encontrado");
        }
        return item.get();

    }

    public Item updateItems(ItemDto itemDto, Long id){

        Optional<Item> item1 = itemsRepositorio.findById(id);
        if (item1.isEmpty()) {
            throw new NotFoundException("Item con id " + id + " no encontrado");
        }

        itemDto.setEstado(2);
        Item item = item1.get();
        item.setCapacidad(itemDto.getCapacidad());
        item.setNombre(itemDto.getNombre());
        item.setEnvase(itemDto.getEnvase());
        item.setTipo(itemDto.getTipo());
        item.setNevera(itemDto.getNevera());
        item.setEstado(itemDto.getEstado());

        return itemsRepositorio.save(item);




    }

    public Item saveItem(Item item){

        LocalDateTime dateTime = LocalDateTime.now();
        item.setEstado(1);
        item.setFecha2(dateTime);

        return itemsRepositorio.save(item);

    }

    public void deletedItems(Long id){
        itemsRepositorio.deleteById(id);
    }



}
