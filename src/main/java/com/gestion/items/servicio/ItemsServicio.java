package com.gestion.items.servicio;


import com.gestion.items.dto.ItemDto;
import com.gestion.items.entidades.Item;
import com.gestion.items.excepciones.NotFoundException;
import com.gestion.items.repositorio.ItemsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Item updateItems(ItemDto itemDto, Long id){

        Optional<Item> item1 = itemsRepositorio.findById(id);
        if (item1.isEmpty()) {
            throw new NotFoundException("Item con id " + id + " no encontrado");
        }

        itemDto.setEstado("Created");
        Item item = item1.get();
        item.setId(id);
        item.setCapacidad(itemDto.getCapacidad());
        item.setNombre(itemDto.getNombre());
        item.setEnvase(itemDto.getEnvase());
        item.setTipo(itemDto.getTipo());
        item.setNevera(itemDto.getNevera());
        item.setEstado(itemDto.getEstado());

        Item resultado = itemsRepositorio.save(item);
        itemsRepositorio.flush();
        return resultado;



    }

    public Item saveItem(Item item){

        LocalDateTime dateTime = LocalDateTime.now();
        item.setFecha2(dateTime);
        item.setEstado("Waiting");


        return itemsRepositorio.save(item);

    }

    public Item saveItem2(Item item){



        return itemsRepositorio.save(item);

    }



    public void deletedItems(Long id){
        itemsRepositorio.deleteById(id);
    }



}
