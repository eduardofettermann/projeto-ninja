package com.github.projetoninja.service;

import com.github.projetoninja.model.Missao;
import com.github.projetoninja.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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

    public Missao alterarMissao(Long id, Missao missaoAlterada) {
        if (missaoRepository.existsById(id)) {
            missaoAlterada.setIdDaMissao(id);
            return missaoRepository.save(missaoAlterada);
        }
        return null;
    }

    public List<Missao> retornarMissoes(){
        return missaoRepository.findAll();
    }

    public ResponseEntity<List<Missao>> retornarMissoesPorFiltro(String parametro) {
        ResponseEntity<List<Missao>> respostaDaRequisicao;
        Sort.Order filtro;
        if (parametro.equalsIgnoreCase("classificacao") || parametro.equalsIgnoreCase("concluida")) {
            filtro = new Sort.Order(Sort.Direction.ASC, parametro);
            List<Missao> missoes = missaoRepository.findAll(Sort.by(filtro));
            respostaDaRequisicao = ResponseEntity.ok(missoes);
        } else respostaDaRequisicao = ResponseEntity.notFound().build();
        return respostaDaRequisicao;
    }
}