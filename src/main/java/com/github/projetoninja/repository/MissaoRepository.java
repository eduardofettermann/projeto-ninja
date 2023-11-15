package com.github.projetoninja.repository;

import com.github.projetoninja.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}