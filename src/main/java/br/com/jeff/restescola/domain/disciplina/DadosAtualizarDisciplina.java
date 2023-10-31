package br.com.jeff.restescola.domain.disciplina;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDisciplina(
        @NotNull
        Long id,
        String nome) {

}
