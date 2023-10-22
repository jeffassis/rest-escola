package br.com.jeff.restescola.domain.professor;

import br.com.jeff.restescola.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfessor(
        @NotNull
        Long id,
        String nome,
        String rg,
        String cpf,
        String email,
        String telefone,
        String sangue,
        @Valid
        DadosEndereco endereco) {
}
