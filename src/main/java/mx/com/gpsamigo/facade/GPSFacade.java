package mx.com.gpsamigo.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.gpsamigo.domain.CompaniaCelular;
import mx.com.gpsamigo.domain.Pais;
import mx.com.gpsamigo.domain.PaisCompania;
import mx.com.gpsamigo.domain.Usuario;
import mx.com.gpsamigo.exceptions.ErrCodes;
import mx.com.gpsamigo.exceptions.GeneralException;
import mx.com.gpsamigo.repository.CompaniaCelularRepository;
import mx.com.gpsamigo.repository.PaisCompaniaRepository;
import mx.com.gpsamigo.repository.PaisRepository;
import mx.com.gpsamigo.repository.UsuarioRepository;

@Component
public class GPSFacade {

	@Autowired
	PaisRepository paisRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PaisCompaniaRepository paisCompaniaRepository;
	
	@Autowired
	private CompaniaCelularRepository companiaCelularRepository;
	
	
	public GPSFacade() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario agregarUsuario(Usuario usuario) throws GeneralException {
		Usuario usu = usuarioRepository.findByUsuarioOrCorreo(usuario.getUsuario(), usuario.getCorreo());
		if (usu != null) {
			if (usuario.getCorreo().equals(usu.getCorreo()))
				throw new GeneralException(ErrCodes.DUPLICATE,"El correo se encuentra repetido");
	       if (usuario.getUsuario().equals(usu.getUsuario()))
	    	   throw new GeneralException(ErrCodes.DUPLICATE,"El usuario se encuentra repetido");
		}else {
			usu = usuarioRepository.save(usuario);
		    
			
		}
		return usu;
	}
	
	public Usuario actualizaUsuario (Usuario usuario) throws GeneralException {
		Usuario usu = null;
		if (usuario.getId() > 0) {
			Usuario usuTmp = usuarioRepository.findByUsuarioOrCorreo(usuario.getUsuario(), usuario.getCorreo());
			if (usuario.getCorreo().equals(usuTmp.getCorreo()) && usuario.getId() != usuTmp.getId())
				throw new GeneralException(ErrCodes.DUPLICATE,"El correo se encuentra repetido");
	        if (usuario.getUsuario().equals(usuTmp.getUsuario()) && usuario.getId() != usuTmp.getId())
	    	   throw new GeneralException(ErrCodes.DUPLICATE,"El usuario se encuentra repetido");
			usuTmp.setCorreo(usuario.getCorreo());
			usuTmp.setNombre(usuario.getNombre());
			usuTmp.setPassword(usuario.getPassword());
			usu = usuarioRepository.save(usuTmp);
		}else {
			usu = agregarUsuario(usuario);
		}
		
		return usu;
	}
	
	public PaisCompania obtenerPaisCompaniaCelular (String codigoPais, String codigoCompania) throws GeneralException {
		Pais pais = paisRepository.findByPaisId(codigoPais);
		CompaniaCelular companiaCelular = companiaCelularRepository.findByCompaniaId(codigoCompania);
		
		
		PaisCompania lista = paisCompaniaRepository.findByPaisAndCompaniaCelular(pais, companiaCelular);
		return lista;
	}
	
		


}
