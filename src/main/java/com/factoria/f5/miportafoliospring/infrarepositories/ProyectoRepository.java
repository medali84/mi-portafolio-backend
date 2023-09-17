package com.factoria.f5.miportafoliospring.infrarepositories;

import com.factoria.f5.miportafoliospring.domain.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
}
