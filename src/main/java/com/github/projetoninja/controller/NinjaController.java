package com.github.projetoninja.controller;

import com.github.projetoninja.model.Ninja;
import com.github.projetoninja.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetoninja")
public class NinjaController {
    @Autowired
    private NinjaService ninjaService;

    @PostMapping("/ninjas/cadastrar")
    public Ninja cadastrarNinja(@RequestBody Ninja ninja) {
        return ninjaService.cadastrarNinja(ninja);
    }

    @GetMapping("/ninjas/id={id}")
    public ResponseEntity<Optional<Ninja>> retornarNinjaPorId(@PathVariable Long id) {
        return ninjaService.retornarNinjaPorId(id);
    }

    @GetMapping("/ninjas")
    public List<Ninja> retornarNinjas() {
        return ninjaService.retornarTodosNinjas();
    }

    @PutMapping("/ninjas/alterar={id}")
    public ResponseEntity<Ninja> alterarNinja(@PathVariable(value = "id") Long id,
                                              @RequestBody Ninja ninjaAtualizado) {
        ninjaService.alterarNinjaPeloId(id, ninjaAtualizado);
        return ninjaAtualizado != null & ninjaService.retornarNinjaPorId(id) != null ?
                ResponseEntity.ok(ninjaAtualizado) :
                ResponseEntity.notFound().build();
    }
}