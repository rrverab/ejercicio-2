package com.gestion.items.controlador;


import com.gestion.items.dto.ItemStatus;
import com.gestion.items.entidades.Item;
import com.gestion.items.servicio.ItemsServicio;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/productos",produces = "application/json")
public class ItemsControlador {

    @Autowired
    private ItemsServicio service;

    @Autowired
    private RabbitTemplate template;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> GetList(){
        return   service.ListAll();


    }

    @GetMapping("/listaProductos")
    public ResponseEntity<List<Item>> listaProductos(){

        List<Item> result = service.ListAll();
       // return new ResponseEntity<List<Producto>>(result, HttpStatus.OK);
        return ResponseEntity.ok(new ArrayList<>(result));
    }

    // Producto por ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getProductoById(@PathVariable("id") Long id) {
        Item result = service.FinbyId(id);
        // implícitamente si no lo encuentra, lanza excepción
        return  ResponseEntity.ok(result);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Item newProducto(@RequestBody Item item){
        //item.setId(3);
        //waiting
        //created
        ItemStatus itemStatus = new ItemStatus(item, "WAITING", "item created succesfully ");
       //template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, itemStatus);

        return service.saveItem(item);

    }

    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item editItem(@RequestBody Item item){

        return service.updateItems(item, item.getId());

    }




    @DeleteMapping(value = "/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Long id){
        service.deletedItems(id);
        return new ResponseEntity(HttpStatus.OK);
    }




}
