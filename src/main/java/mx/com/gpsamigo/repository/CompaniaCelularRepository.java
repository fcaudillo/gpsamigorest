package mx.com.gpsamigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gpsamigo.domain.CompaniaCelular;

public interface CompaniaCelularRepository extends JpaRepository<CompaniaCelular, Integer> {
	
	public CompaniaCelular findByCompaniaId (String codigoCompania);
  
}
