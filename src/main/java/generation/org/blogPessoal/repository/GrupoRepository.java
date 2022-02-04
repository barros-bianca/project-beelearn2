package generation.org.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import generation.org.blogPessoal.model.Grupo;


public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	public List<Grupo> findAllByDescricaoContainingIgnoreCase( String descricao);
}
