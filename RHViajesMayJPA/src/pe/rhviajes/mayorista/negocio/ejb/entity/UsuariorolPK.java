package pe.rhviajes.mayorista.negocio.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuariorol database table.
 * 
 */
@Embeddable
public class UsuariorolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idusuario;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idrol;

	public UsuariorolPK() {
	}
	public Integer getIdusuario() {
		return this.idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Integer getIdrol() {
		return this.idrol;
	}
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariorolPK)) {
			return false;
		}
		UsuariorolPK castOther = (UsuariorolPK)other;
		return 
			this.idusuario.equals(castOther.idusuario)
			&& this.idrol.equals(castOther.idrol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusuario.hashCode();
		hash = hash * prime + this.idrol.hashCode();
		
		return hash;
	}
}