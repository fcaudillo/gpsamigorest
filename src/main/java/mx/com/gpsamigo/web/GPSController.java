package mx.com.gpsamigo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.gpsamigo.domain.PaisCompania;
import mx.com.gpsamigo.domain.Settings;
import mx.com.gpsamigo.domain.Usuario;
import mx.com.gpsamigo.exceptions.ErrCodes;
import mx.com.gpsamigo.exceptions.GeneralException;
import mx.com.gpsamigo.exceptions.WrapperGeneralException;
import mx.com.gpsamigo.facade.GPSFacade;
import mx.com.gpsamigo.repository.PaisCompaniaRepository;
import mx.com.gpsamigo.repository.SettingsRepository;
import mx.com.gpsamigo.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/v1/api")
public class GPSController {

	@Autowired
	private GPSFacade gpsFacade;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PaisCompaniaRepository paisCompaniaRepository;
	
	@Autowired
	private SettingsRepository settingsRepository;

	@RequestMapping(value = "/usuario/add" , method = RequestMethod.PUT)
	@ResponseBody
	public Usuario agregarUsuario(@RequestBody Usuario usuario) throws GeneralException {
		System.out.println(usuario.toString());
		
        usuario = gpsFacade.agregarUsuario(usuario);
		
		return usuario;
	}
	
	@RequestMapping(value = "/usuario/updateInsertUsuario" , method = RequestMethod.PUT)
	@ResponseBody
	public Usuario updateInsertUsuario(@RequestBody Usuario usuario) throws GeneralException {
		System.out.println(usuario.toString());
		
        usuario = gpsFacade.actualizaUsuario(usuario);
		
		return usuario;
	}
	
	@RequestMapping(value = "/usuario/{user}" , method = RequestMethod.GET)
	@ResponseBody
	public Usuario obtenerUsuario(@PathVariable String user) throws GeneralException {
		Usuario usu = usuarioRepository.findByUsuario(user);
		if (usu == null)
			throw new GeneralException(ErrCodes.NOT_FOUND, "Not found");
		return usu;
	}

	@RequestMapping(value = "/companiaCelular/{pais}/{compania}" , method = RequestMethod.GET)
	@ResponseBody
	public PaisCompania obtenerPaisCompaniaCelular (@PathVariable("pais") String codigoPais,@PathVariable("compania") String codigoCompania) throws GeneralException {
		return gpsFacade.obtenerPaisCompaniaCelular(codigoPais, codigoCompania);
	}
	
	@RequestMapping(value = "/settings" , method = RequestMethod.GET)
	@ResponseBody
	public List<Settings> obtenerSettings  () throws GeneralException {
		return settingsRepository.findAll();
	}
	
	
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<WrapperGeneralException> exceptionHandler(GeneralException ex){
		return new ResponseEntity<WrapperGeneralException>(new WrapperGeneralException(ex.getCode(), ex.getMessage() ),HttpStatus.BAD_REQUEST);
	}
	
	
}
