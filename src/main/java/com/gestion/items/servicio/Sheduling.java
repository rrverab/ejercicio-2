package com.gestion.items.servicio;


import com.gestion.items.entidades.Item;
import com.gestion.items.repositorio.ItemsRepositorio;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service

public class Sheduling {
    private ItemsRepositorio repositorio;


    public Sheduling(ItemsRepositorio repositorio) {
        this.repositorio = repositorio;

    }

    @Scheduled(fixedDelay = 10000)
    public void procesarItem() {
        if (!repositorio.existsByEstado("Waiting")) {

            System.out.println(LocalDateTime.now() + ": No hay ningun Item en estado(Waiting) " );
            return;

        }
        Random numAleatorio = new Random();
        boolean aleat2 = numAleatorio.nextBoolean();

        if (aleat2) {

            Item item = repositorio.findFirstByEstado("Waiting");
            System.out.println(LocalDateTime.now() + ": procesando item " + item);
            item.setEstado("Created");
            repositorio.save(item);

        }else {
            System.out.println(LocalDateTime.now() + ": No se procesa nada " );
        }



    }





}
