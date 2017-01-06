package mx.com.gpsamigo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "correo"),
		@UniqueConstraint(columnNames = "usuario" ) })

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7084073142946194637L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "usuario_id", unique = true, nullable = false)	private int id;
	@Column(name = "correo", length = 128)
	private String correo;
	@Column(name = "Usuario", length = 128)
	private String usuario;
	@Column(name = "password", length = 128)
	private String password;
	@Column(name = "nombre", length = 128)
	private String nombre;
	
	@OneToMany (mappedBy = "usuarioId", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private List<DeviceTracker> deviceTrackers;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public List<DeviceTracker> getDeviceTrackers() {
		return deviceTrackers;
	}
	public void setDeviceTrackers(List<DeviceTracker> deviceTrackers) {
		this.deviceTrackers = deviceTrackers;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", " + (correo != null ? "correo=" + correo + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (deviceTrackers != null ? "deviceTrackers=" + deviceTrackers : "") + "]";
	}

	
	

}
