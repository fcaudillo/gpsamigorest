package mx.com.gpsamigo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pais", schema = "public")

public class Pais implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6409293013276622106L;
	 private String pais_id;
	 private String descripcion;
	 int gmt;

	@Id
	@Column(name = "pais_id", length = 10)
	public String getPaisId() {
		return pais_id;
	}
	public void setPaisId(String codigo) {
		this.pais_id = codigo;
	}
	@Column(name = "descripcion", length = 128)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String pais) {
		this.descripcion = pais;
	}
	
	@Column(name = "gmt")
	public int getGmt() {
		return gmt;
	}
	public void setGmt(int gmt) {
		this.gmt = gmt;
	}
	@Override
	public String toString() {
		return "Pais [" + (pais_id != null ? "pais_id=" + pais_id + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", " : "") + "gmt=" + gmt + "]";
	}

     
}
