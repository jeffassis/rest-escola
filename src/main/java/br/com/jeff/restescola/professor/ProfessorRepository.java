package br.com.jeff.restescola.professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
