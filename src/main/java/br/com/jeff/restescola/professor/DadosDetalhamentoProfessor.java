package br.com.jeff.restescola.professor;


import br.com.jeff.restescola.endereco.Endereco;

public record DadosDetalhamentoProfessor(
        Long id,
        String nome,
        String rg,
        String cpf,
        String email,
        String telefone,
        String sangue,
        Endereco endereco) {

    public DadosDetalhamentoProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getRg(), professor.getCpf(), professor.getEmail(), professor.getTelefone(), professor.getSangue(), professor.getEndereco());
    }
}
