package com.leosouza.sge.repositories;

import com.leosouza.sge.domain.Medalhas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalhasRepository extends JpaRepository<Medalhas, Long> {
}
