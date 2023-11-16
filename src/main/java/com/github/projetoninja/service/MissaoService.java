package com.github.projetoninja.service;

import com.github.projetoninja.model.Missao;
import com.github.projetoninja.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    @Autowired
    private MissaoRepository missaoRepository;

    public Missao cadastrarMissao(Missao missao) {
        return missaoRepository.save(missao);
    }

    public Optional<Missao> retornarMissaoPeloId(Long id) {
        return missaoRepository.findById(id);
    }

    public List<Missao> retornarTodasMissoes() {
        return missaoRepository.findAll();
    }

    public Missao alterarMissao(Long id, Missao missaoAlterada) {
        if (missaoRepository.existsById(id)) {
            missaoAlterada.setIdDaMissao(id);
            return missaoRepository.save(missaoAlterada);
        }
        return null;
    }
    public List<Missao> retornarTodasMissoesPorDificuldade(String parametro) {
        List<Missao> missoes = missaoRepository.findAll();
        Sort.Order filtro;
        switch (parametro){
            case ("classificacao"), ("concluida") -> {
                filtro = new Sort.Order(Sort.Direction.ASC, parametro);
                missoes = missaoRepository.findAll(Sort.by(filtro));
            }
         }
        return missoes;
    }

    public List<Missao> retornarTodasMissoesPorStatus() {
        Sort.Order ordenadorPorStatus = new Sort.Order(Sort.Direction.ASC, "concluida");
        return missaoRepository.findAll(Sort.by(ordenadorPorStatus));
    }
}