package com.gestion.items.repositorio;

import com.gestion.items.entidades.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepositorio extends JpaRepository<Item,Long> {

            Item findFirstByEstado(String estado);
            Boolean existsByEstado(String estado);

}
