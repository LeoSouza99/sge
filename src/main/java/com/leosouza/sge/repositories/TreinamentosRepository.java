package com.leosouza.sge.repositories;

import com.leosouza.sge.domain.Treinamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinamentosRepository extends JpaRepository<Treinamentos, Long> {
}
