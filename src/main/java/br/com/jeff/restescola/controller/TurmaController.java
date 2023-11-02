package br.com.jeff.restescola.controller;

import br.com.jeff.restescola.domain.turma.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("turmas")
public class TurmaController {
    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTurma>> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosDetalhamentoTurma::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTurma dados, UriComponentsBuilder uriBuilder) {
        var turma = new Turma(dados);
        repository.save(turma);
        var uri = uriBuilder.path("/turmas/{id}").buildAndExpand(turma.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTurma(turma));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTurma dados) {
        var turma = repository.getReferenceById(dados.id());
        turma.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTurma(turma));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
