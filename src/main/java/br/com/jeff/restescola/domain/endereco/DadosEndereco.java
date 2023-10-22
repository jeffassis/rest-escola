package br.com.jeff.restescola.domain.endereco;

import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        String logradouro,
        @Pattern(regexp = "\\d{8}")
        String cep,
        String cidade,
        String bairro,
        String uf,
        String numero) {
}
