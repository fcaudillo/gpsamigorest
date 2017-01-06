package mx.com.gpsamigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DeviceTracker", schema = "public")
@IdClass(DeviceTrackerPK.class)
public class DeviceTracker {
	
	@Id
	@Column(name="imei")
	private String imei;
	
	@Id
	@Column(name="usuario_id")
    private int usuarioId;
	
	@ManyToOne
	@JoinColumn(name = "pais_id", insertable = false, updatable = false)
	Pais pais;

	@Column(name = "telPrincipal", length = 30)
	private String telefonoPrincipal;
	
	@Column(name = "telGPS", length = 30)
	private String telefonoGPS;
	
	@ManyToOne
	@JoinColumn(name = "compania_id", insertable = false, updatable = false)
	private CompaniaCelular compania;
	
	
    
	@Column(name="gmt")
    private int gmt;



	public String getImei() {
		return imei;
	}



	public void setImei(String imei) {
		this.imei = imei;
	}



	public int getUsuarioId() {
		return usuarioId;
	}



	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}



	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais = pais;
	}



	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}



	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}



	public String getTelefonoGPS() {
		return telefonoGPS;
	}



	public void setTelefonoGPS(String telefonoGPS) {
		this.telefonoGPS = telefonoGPS;
	}



	public CompaniaCelular getCompania() {
		return compania;
	}



	public void setCompania(CompaniaCelular compania) {
		this.compania = compania;
	}



	public int getGmt() {
		return gmt;
	}



	public void setGmt(int gmt) {
		this.gmt = gmt;
	}
	
	
    

}
