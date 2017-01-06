package mx.com.gpsamigo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pais_compania", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = {"pais_id","compania_id"} ) })
public class PaisCompania {
    private int id;
    private Pais pais;
    private CompaniaCelular companiaCelular;
    private String apn;
    private String usuario;
    private String password;

    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pais_comp_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "apn", length = 128)
	public String getApn() {
		return apn;
	}
	
	
	public void setApn(String apn) {
		this.apn = apn;
	}
	
	
	@Column(name = "usuario", length = 30)
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column (name = "password", length = 30)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pais_id")
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "compania_id")
	public CompaniaCelular getCompaniaCelular() {
		return companiaCelular;
	}
	
	public void setCompaniaCelular(CompaniaCelular companiaCelular) {
		this.companiaCelular = companiaCelular;
	}
	@Override
	public String toString() {
		return "PaisCompania [id=" + id + ", pais=" + pais + ", companiaCelular=" + companiaCelular + ", apn=" + apn
				+ ", usuario=" + usuario + ", password=" + password + "]";
	}
}
