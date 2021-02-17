package br.com.promove.apicursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.promove.apicursos.models.Curso;


public interface CursoRepository extends JpaRepository <Curso, Long> {

	Curso findById(long id);

}
