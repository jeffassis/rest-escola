package br.com.jeff.restescola.controller;

import br.com.jeff.restescola.professor.DadosCadastroProfessor;
import br.com.jeff.restescola.professor.DadosListagemProfessor;
import br.com.jeff.restescola.professor.Professor;
import br.com.jeff.restescola.professor.ProfessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DadosListagemProfessor> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemProfessor::new);
    }
}
