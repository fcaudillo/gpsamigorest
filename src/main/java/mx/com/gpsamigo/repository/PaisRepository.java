package mx.com.gpsamigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import mx.com.gpsamigo.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais,Integer> {
    public Pais findByPaisId(@Param(value = "pais_id") String pais_id);
}
