package com.gestion.items.repositorio;

import com.gestion.items.entidades.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepositorio extends JpaRepository<Items,Long> {



}
