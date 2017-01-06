package mx.com.gpsamigo.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class DeviceTrackerPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7563742460507725038L;

	@Column(name="imei")
	private String imei;
	
	@Column(name="usuario_id")
    private int usuarioId;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imei == null) ? 0 : imei.hashCode());
		result = prime * result + usuarioId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceTrackerPK other = (DeviceTrackerPK) obj;
		if (imei == null) {
			if (other.imei != null)
				return false;
		} else if (!imei.equals(other.imei))
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		return true;
	}
	
	
}
