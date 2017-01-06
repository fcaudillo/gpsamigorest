package mx.com.gpsamigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gpsamigo.domain.CompaniaCelular;
import mx.com.gpsamigo.domain.Pais;
import mx.com.gpsamigo.domain.PaisCompania;

public interface PaisCompaniaRepository extends JpaRepository<PaisCompania, Integer> {
   public List<PaisCompania> findByPais(Pais pais);
   public PaisCompania findByPaisAndCompaniaCelular(Pais pais, CompaniaCelular companiaCelular);

}
