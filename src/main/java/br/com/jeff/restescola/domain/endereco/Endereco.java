package br.com.jeff.restescola.domain.endereco;

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

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
    }
}
