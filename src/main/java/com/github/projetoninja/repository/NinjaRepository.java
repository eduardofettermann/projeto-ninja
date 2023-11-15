package com.github.projetoninja.repository;

import com.github.projetoninja.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}