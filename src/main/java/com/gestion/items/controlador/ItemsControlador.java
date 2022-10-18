package com.gestion.items.controlador;


import com.gestion.items.dto.ItemDto;
import com.gestion.items.dto.ItemStatus;
import com.gestion.items.entidades.Item;
import com.gestion.items.servicio.ItemsServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping(value = "/productos",produces = "application/json")
public class ItemsControlador {

    @Autowired
    private ItemsServicio service;

 //   @Autowired
 //   private RabbitTemplate template;

    @GetMapping( "/items")
    public String ShowListItems(Model model){

        List<Item> listItems = service.ListAll();
        model.addAttribute("listItems",listItems);
        return "items";




    }

    @GetMapping( "/cliente")
    public String ShowListItems2(Model model){

        List<Item> listItems = service.ListAll();
        model.addAttribute("listItems",listItems);
        return "cliente";




    }

    @GetMapping("/listaProductos")
    public ResponseEntity<List<Item>> listaProductos(){

       // List<Item> result = service.ListAll();
       // return new ResponseEntity<List<Producto>>(result, HttpStatus.OK);
        return ResponseEntity.ok(service.ListAll());
    }

    // Producto por ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getProductoById(@PathVariable("id") Long id) {
        Item result = service.FinbyId(id);
        // implícitamente si no lo encuentra, lanza excepción
        return  ResponseEntity.ok(result);
    }



    @GetMapping("/items/new")
    public String showNewForm2(Model model){
        model.addAttribute("item",new Item());
        return "crear_item";


    }

    @PostMapping("/item/save")
    public String saveItem(@ModelAttribute ("item") Item item){
        service.saveItem(item);
        return "redirect:/items";

    }

    @GetMapping("/item/editar/{id}")
    public String editar(@PathVariable long id  ,Model model){
        model.addAttribute("item",service.FinbyId(id));
        return "editar_item";

    }

    @GetMapping("/item/eli/{id}")
    public String eliminar(@PathVariable long id){
        service.deletedItems(id);
        return "redirect:/items";

    }

    @PostMapping("/item/{id}")
    public String actualizaritem(@PathVariable long id  ,@ModelAttribute("item") Item item,Model model){
        model.addAttribute("item",service.FinbyId(id));
        Item item1 = service.FinbyId(id);
        item1.setId(id);
        item1.setNombre(item.getNombre());
        item1.setTipo(item.getTipo());
        item1.setEnvase(item.getEnvase());
        item1.setCapacidad(item.getCapacidad());
        item1.setNevera(item.getNevera());
        service.saveItem2(item1);

        return "redirect:/items";

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

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item editItem(@PathVariable("id") Long id, @RequestBody ItemDto item){

        return service.updateItems(item, id);

    }




    @DeleteMapping(value = "/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Long id){
        service.deletedItems(id);
        return new ResponseEntity(HttpStatus.OK);
    }




}
