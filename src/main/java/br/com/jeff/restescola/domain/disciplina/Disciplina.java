package br.com.jeff.restescola.domain.disciplina;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Table(name = "disciplinas")
@Entity(name = "Disciplina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false, unique = true)
    private String nome;

    public Disciplina(DadosCadastrarDisciplina dados){
        this.nome = dados.nome();
    }

}
