package com.subasta.repository;

import com.subasta.entity.EstadoSubasta;
import com.subasta.entity.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubastaRepository extends JpaRepository<Subasta, Long> {
    List<Subasta> findByEstado(EstadoSubasta estado);
}