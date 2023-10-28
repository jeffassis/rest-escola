package br.com.jeff.restescola.domain.disciplina;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarDisciplina(
        @NotBlank
        String nome) {
}
