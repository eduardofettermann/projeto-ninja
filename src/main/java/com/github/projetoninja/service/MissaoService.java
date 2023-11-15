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
// Essa parte está comentada pois irei verificar se funciona após criar os Controllers
//    public List<Missao> retornarTodasMissoesPorDificuldade() {
//        Sort.Order ordenadorPorClassificacao = new Sort.Order(Sort.Direction.ASC, "classificacao");
//        return missaoRepository.findAll(Sort.by(ordenadorPorClassificacao));
//    }
//
//    public List<Missao> retornarTodasMissoesPorStatus() {
//        Sort.Order ordenadorPorStatus = new Sort.Order(Sort.Direction.ASC, "concluida");
//        return missaoRepository.findAll(Sort.by(ordenadorPorStatus));
//    }
}