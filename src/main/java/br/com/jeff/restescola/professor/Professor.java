package br.com.jeff.restescola.professor;

import br.com.jeff.restescola.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "professores")
@Entity(name = "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false, unique = true)
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private String sangue;
    @Embedded
    private Endereco endereco;

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.rg = dados.rg();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.sangue = dados.sangue();
        this.endereco = new Endereco(dados.endereco());
    }
}
