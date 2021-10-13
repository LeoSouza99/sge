package com.leosouza.sge.model.repositories;

import com.leosouza.sge.domain.Missoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository<Missoes, Long> {
}
