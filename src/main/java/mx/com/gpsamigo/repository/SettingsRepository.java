package mx.com.gpsamigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gpsamigo.domain.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Integer> {
	
}
  