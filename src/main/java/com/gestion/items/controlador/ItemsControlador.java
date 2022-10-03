package com.gestion.items.controlador;


import com.gestion.items.entidades.Items;
import com.gestion.items.servicio.ItemsServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/producto",produces = "application/json")
public class ItemsControlador {

    @Autowired
    private ItemsServicio service;

    @GetMapping(value = "/lists", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Items> GetList(){
        return   service.ListAll();


    }

    @GetMapping("/listaProductos")
    public ResponseEntity<List<Items>> listaProductos(){

        List<Items> result = service.ListAll();
       // return new ResponseEntity<List<Producto>>(result, HttpStatus.OK);
        return ResponseEntity.ok(new ArrayList<>(result));
    }

    // Producto por ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Items> getProductoById(@PathVariable("id") Long id) {
        Items result = service.FinbyId(id);
        // implícitamente si no lo encuentra, lanza excepción
        return  ResponseEntity.ok(result);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Items newProducto(@RequestBody Items item){

       return service.saveItem(item);

    }

    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Items editItem(@RequestBody Items item){

        return service.updateItems(item, item.getId());

    }




    @DeleteMapping(value = "/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Long id){
        service.deletedItems(id);
        return new ResponseEntity(HttpStatus.OK);
    }




}
