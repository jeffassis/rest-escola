package br.com.jeff.restescola.domain.turma;

public record DadosDetalhamentoTurma(Long id, String nome, String serie, String turno, String ano) {

    public DadosDetalhamentoTurma(Turma turma) {
        this(turma.getId(), turma.getNome(), turma.getSerie(), turma.getTurno(), turma.getAno());
    }
}
