package com.github.projetoninja.controller;

import com.github.projetoninja.model.Missao;
import com.github.projetoninja.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetoninja")
public class MissaoController {
    @Autowired
    private MissaoService missaoService;

    @PostMapping("/missoes/cadastrar")
    public Missao cadastrarMissao(@RequestBody Missao missao) {
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping("/missoes/{id}")
    public Optional<Missao> retornarMissaoPorId(@PathVariable Long id) {
        return missaoService.retornarMissaoPeloId(id);
    }

    @PutMapping("/missoes/alterar")
    public Missao alterarMissao(@RequestParam(value = "id") Long id, @RequestBody Missao missaoAlterada) {
        return missaoService.alterarMissao(id, missaoAlterada);
    }

    @GetMapping("/missoes")
    public List<Missao> retornarMissoes() {
        return missaoService.retornarMissoes();
    }

    @GetMapping("/missoes/filtrar")
    public ResponseEntity<List<Missao>> retornarMissaoPorFiltro(@RequestParam(value = "parametro") String parametro) {
        return missaoService.retornarMissoesPorFiltro(parametro);
    }
}