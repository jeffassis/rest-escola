package br.com.jeff.restescola.domain.disciplina;

public record DadosDetalhamentoDisciplina(Long id, String nome) {

    public DadosDetalhamentoDisciplina(Disciplina disciplina){
        this(disciplina.getId(), disciplina.getNome());
    }
}
