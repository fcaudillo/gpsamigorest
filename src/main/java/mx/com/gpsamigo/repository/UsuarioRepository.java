package mx.com.gpsamigo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gpsamigo.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {	
	public 	Usuario findByUsuario (String usuario);
	public  Usuario findByCorreo (String correo);
	public  Usuario findByUsuarioOrCorreo (String usuario, String correo);
}
