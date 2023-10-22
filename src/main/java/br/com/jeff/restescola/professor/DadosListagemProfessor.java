package br.com.jeff.restescola.professor;

public record DadosListagemProfessor(Long id, String nome, String email, String telefone) {

    public DadosListagemProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getTelefone());
    }
}
