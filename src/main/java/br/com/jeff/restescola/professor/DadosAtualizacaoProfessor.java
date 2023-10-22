package br.com.jeff.restescola.professor;

import br.com.jeff.restescola.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
