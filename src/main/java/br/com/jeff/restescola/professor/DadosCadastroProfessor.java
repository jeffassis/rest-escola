package br.com.jeff.restescola.professor;

import br.com.jeff.restescola.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(
        @NotBlank
        String nome,
        @Pattern(regexp = "\\d{9}")
        String rg,
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @Email
        String email,
        String telefone,
        String sangue,
        @Valid
        DadosEndereco endereco) {
}
