package br.com.jeff.restescola.professor;

public record DadosListagemProfessor(String nome, String email, String telefone) {

    public DadosListagemProfessor(Professor professor) {
        this(professor.getNome(), professor.getEmail(), professor.getTelefone());
    }
}
