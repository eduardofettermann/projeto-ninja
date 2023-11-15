package com.github.projetoninja.service;

import com.github.projetoninja.model.Ninja;
import com.github.projetoninja.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public Optional<Ninja> retornarNinjaPorId(Long id) {
        return ninjaRepository.findById(id);
    }

    public List<Ninja> retornarTodosNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja alterarNinjaPeloId(Long id, Ninja ninjaAlterado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAlterado.setIdDoNinja(id);
            return ninjaRepository.save(ninjaAlterado);
        }
        return null;
    }
}