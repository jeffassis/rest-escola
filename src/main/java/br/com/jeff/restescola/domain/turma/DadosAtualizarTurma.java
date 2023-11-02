package br.com.jeff.restescola.domain.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTurma(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        String serie,
        String turno,
        @NotNull
        String ano) {
}
