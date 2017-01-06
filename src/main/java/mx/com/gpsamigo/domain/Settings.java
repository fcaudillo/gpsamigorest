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
@Table(name = "settings", schema = "public")

public class Settings implements Serializable {
   private int id;

   private String clave;
   private String valor;
   private String descripcion;

   public Settings(String clave, String valor, String descripcion) {
		super();
		this.clave = clave;
		this.valor = valor;
		this.descripcion = descripcion;
    }

   
	public Settings() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@Column(name = "clave", length = 30)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "valor", length = 100)
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Column(name = "descripcion", length = 120)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
   
}
