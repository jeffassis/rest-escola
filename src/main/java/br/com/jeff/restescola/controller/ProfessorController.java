package br.com.jeff.restescola.controller;

import br.com.jeff.restescola.professor.DadosCadastroProfessor;
import br.com.jeff.restescola.professor.Professor;
import br.com.jeff.restescola.professor.ProfessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProfessor dados) {
        repository.save(new Professor(dados));
    }
}
