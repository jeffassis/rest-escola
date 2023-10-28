package br.com.jeff.restescola.controller;

import br.com.jeff.restescola.domain.disciplina.DadosCadastrarDisciplina;
import br.com.jeff.restescola.domain.disciplina.DadosDetalhamentoDisciplina;
import br.com.jeff.restescola.domain.disciplina.Disciplina;
import br.com.jeff.restescola.domain.disciplina.DisciplinaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarDisciplina dados, UriComponentsBuilder uriBuilder) {
        var disciplina = new Disciplina(dados);
        repository.save(disciplina);

        var uri = uriBuilder.path("/disciplinas/{id}").buildAndExpand(disciplina.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDisciplina(disciplina));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var disciplina = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }
}
