package com.szaniawski.artur.artur.domain.repository;

import com.szaniawski.artur.artur.domain.entities.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<BeerEntity, Long> {
}
