package com.leosouza.sge.repositories;

import com.leosouza.sge.domain.Patente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatenteRepository extends JpaRepository<Patente, Long> {
}
