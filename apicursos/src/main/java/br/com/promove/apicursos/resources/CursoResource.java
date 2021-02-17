package br.com.promove.apicursos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import br.com.promove.apicursos.models.Curso;
import br.com.promove.apicursos.repository.CursoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cursos")
public class CursoResource {
	
	@Autowired
	CursoRepository cursoRepository;
	
	@ApiOperation(value="Retorna uma lista de cursos")
	@GetMapping("/cursos")
	public List<Curso> listaCurso(){
		return cursoRepository.findAll();
		
	}
	
	@ApiOperation(value="Retorna um único curso")
	@GetMapping("/curso/{id}")
	public Curso listaCursoUnico(@PathVariable(value="id") long id){
		return cursoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um curso")
	@PostMapping("/curso")
	public Curso salvarProduto(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@ApiOperation(value="Deleta um curso")
	@DeleteMapping("/curso/{id}")
	public void deletaCurso(@PathVariable(value="id") long id) {
		cursoRepository.deleteById(id);
	}
	
	@ApiOperation(value="Atualiza um curso")
	@PutMapping("/curso")
	public Curso atualizaCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	
	

}