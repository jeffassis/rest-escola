package br.com.jeff.restescola.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String cidade;
    private String bairro;
    private String uf;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.uf = dados.uf();
        this.numero = dados.numero();
    }
}
