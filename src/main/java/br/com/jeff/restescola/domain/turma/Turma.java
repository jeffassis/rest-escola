package br.com.jeff.restescola.domain.turma;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "turmas")
@Entity(name = "Turma")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false, unique = true)
    private String nome;
    private String serie;
    private String turno;
    @Column(nullable = false, length = 4)
    private String ano;

    public Turma(DadosCadastroTurma dados) {
        this.nome = dados.nome();
        this.serie = dados.serie();
        this.turno = dados.turno();
        this.ano = dados.ano();
    }

    public void atualizarInformacoes(DadosAtualizarTurma dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.serie() != null) {
            this.serie = dados.serie();
        }
        if (dados.turno() != null) {
            this.turno = dados.turno();
        }
        if (dados.ano() != null) {
            this.ano = dados.ano();
        }
    }
}
