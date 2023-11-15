package com.github.projetoninja.controller;

import com.github.projetoninja.model.Missao;
import com.github.projetoninja.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissaoController {
    @Autowired
    private MissaoService missaoService;

    @PostMapping("/cadastrar")
    public Missao cadastrarMissao(@RequestBody Missao missao) {
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping("/id={id}")
    public Optional<Missao> retornarMissaoPorId(@PathVariable Long id){
        return missaoService.retornarMissaoPeloId(id);
    }

    @GetMapping
    public List<Missao> retornarMissoes(){
        return missaoService.retornarTodasMissoes();
    }

    @PutMapping("/alterar")
    public Missao alterarMissao(@RequestParam(value = "id") Long id ,@RequestBody Missao missaoAlterada){
        return missaoService.alterarMissao(id,missaoAlterada);
    }
}