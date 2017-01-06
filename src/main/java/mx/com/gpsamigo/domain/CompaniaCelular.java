package mx.com.gpsamigo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "compania", schema = "public")

public class CompaniaCelular {
	
	private String compania_id;
	private String descripcion;
	   
	@Id
	@Column(name = "compania_id", unique = true, nullable = false)	
	public String getCompaniaId() {
		return compania_id;
	}
	public void setCompaniaId(String codigo) {
		this.compania_id = codigo;
	}
	
	@Column(name = "descripcion", length=128)
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "CompaniaCelular [" + (compania_id != null ? "compania_id=" + compania_id + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion : "") + "]";
	}

}
