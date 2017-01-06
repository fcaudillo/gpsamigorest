package mx.com.gpsamigo.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.gpsamigo.AlarmaApplication;
import mx.com.gpsamigo.domain.CompaniaCelular;
import mx.com.gpsamigo.domain.DeviceTracker;
import mx.com.gpsamigo.domain.Pais;
import mx.com.gpsamigo.domain.PaisCompania;
import mx.com.gpsamigo.domain.Settings;
import mx.com.gpsamigo.domain.Usuario;

import mx.com.gpsamigo.exceptions.GeneralException;
import mx.com.gpsamigo.facade.GPSFacade;
import mx.com.gpsamigo.repository.CompaniaCelularRepository;
import mx.com.gpsamigo.repository.PaisCompaniaRepository;
import mx.com.gpsamigo.repository.PaisRepository;
import mx.com.gpsamigo.repository.SettingsRepository;
import mx.com.gpsamigo.repository.UsuarioRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AlarmaApplication.class)
public class GpsTest {
	   
    @Autowired
	private GPSFacade gpsFacade;
    
    @Autowired
    private PaisRepository paisRepository;
    
    @Autowired
    private CompaniaCelularRepository companiaRepository;
    
    @Autowired
    private PaisCompaniaRepository paisCompaniaRepository;
    
    @Autowired
    private SettingsRepository settingsRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    

	@Test
	public void test() {
		Usuario usuario = new Usuario();
		usuario.setCorreo("franciscocaudillo1@hotmail.com");
		usuario.setNombre("francisco");
		usuario.setUsuario("fdcp");
		usuario.setPassword("123456");
		
		try {
			Usuario usr = (Usuario) gpsFacade.agregarUsuario(usuario);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}
	
    @Test
    public void testSettings() {
    	
    }
	
	@Test 
	public void testInserciones() {
		
		try {
			System.out.println(" Empezando con gpsFacade");
			Pais pais = new Pais();
			pais.setPaisId("MX");
			pais.setDescripcion("Mexico");
			pais.setGmt(-8);
			paisRepository.save(pais);
			
			CompaniaCelular compania = new CompaniaCelular();
			compania.setCompaniaId("movistart");
			compania.setDescripcion("Movistart");
			companiaRepository.save(compania);
			
			PaisCompania pc = new PaisCompania();
			pc.setApn("wprs.movistart.com");
			pc.setCompaniaCelular(compania);
			pc.setPais(pais);
			pc.setUsuario("movistart");
			pc.setPassword("movistartp");
			paisCompaniaRepository.save(pc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test 
	public void testImei () {
		DeviceTracker tk = new DeviceTracker();
		Usuario usu = usuarioRepository.findByUsuario("fdcp");
		tk.setImei("99999999991111111111");
		tk.setUsuarioId(usu.getId());
		tk.setGmt(-8);
		tk.setPais(paisRepository.findByPaisId("MX"));
		tk.setCompania(companiaRepository.findByCompaniaId("movistart"));
		
		
	}
	
	
	@Test
	public void testPaisCompania() {
		Pais pais = paisRepository.findByPaisId("MX");
		CompaniaCelular companiaCelular = companiaRepository.findByCompaniaId("movistart");
		PaisCompania pc = new PaisCompania();
		pc.setApn("webgprs.movistart.com");
		pc.setCompaniaCelular(companiaCelular);
		pc.setPais(pais);
		pc.setUsuario("movistart");
		pc.setPassword("movistart");
		paisCompaniaRepository.save(pc);
	
	}

	
	@Test 
	public void testCompania() {
		
		try {
			
			PaisCompania paisCompania = gpsFacade.obtenerPaisCompaniaCelular("MX","movistart");
			System.out.println(paisCompania.toString());
		} catch (GeneralException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		@Test
		public void InsertaSettings() {
			settingsRepository.save(new Settings("servidorTCP", "158.68.215.91", "Ip del servidor para recibir coordenadas gps"));
		    settingsRepository.save(new Settings("puertoTCP", "1014", "Puerto del servidor escuchando gps"));
		    settingsRepository.save(new Settings("RASTED_AUTO_ON","10","Unidades de tiempo para reportar las coordenadas del auto encendido"));
		    settingsRepository.save(new Settings("RASTED_AUTO_OFF","20","Unidades de tiempo para reportar las coordenadas del auto apagado"));
		    settingsRepository.save(new Settings("TIEMPO_MON_AUTO_ON", "segundos", "Valores permitidos segundos y minutos"));
		    settingsRepository.save(new Settings("TIEMPO_MON_AUTO_OFF", "segundos", "Valores permitidos segundos y minutos"));
            settingsRepository.save(new Settings("ALARM_DIST_METROS", "100", "Alarma de movimiento. Cantidad en metros"));		    		   
		}    		    
			

	

}
