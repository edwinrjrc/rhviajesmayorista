package pe.rhviajes.mayorista.negocio.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the usuariorol database table.
 * 
 */
@Entity
@Table(name="seguridad.usuariorol")
@NamedQuery(name="Usuariorol.findAll", query="SELECT u FROM Usuariorol u")
public class Usuariorol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariorolPK id;

	@Column(nullable=false)
	private Timestamp fecmodificacion;

	@Column(nullable=false)
	private Timestamp fecregistro;

	private Integer idempresa;

	@Column(nullable=false)
	private Integer idestadoregistro;

	@Column(nullable=false, length=50)
	private String ipmodificacion;

	@Column(nullable=false, length=50)
	private String ipregistro;

	@Column(nullable=false, length=50)
	private String usumodificacion;

	@Column(nullable=false, length=50)
	private String usuregistro;

	//bi-directional many-to-one association to Rol
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idrol", nullable=false, insertable=false, updatable=false)
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario", nullable=false, insertable=false, updatable=false)
	private Usuario usuario;

	public Usuariorol() {
	}

	public UsuariorolPK getId() {
		return this.id;
	}

	public void setId(UsuariorolPK id) {
		this.id = id;
	}

	public Timestamp getFecmodificacion() {
		return this.fecmodificacion;
	}

	public void setFecmodificacion(Timestamp fecmodificacion) {
		this.fecmodificacion = fecmodificacion;
	}

	public Timestamp getFecregistro() {
		return this.fecregistro;
	}

	public void setFecregistro(Timestamp fecregistro) {
		this.fecregistro = fecregistro;
	}

	public Integer getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public Integer getIdestadoregistro() {
		return this.idestadoregistro;
	}

	public void setIdestadoregistro(Integer idestadoregistro) {
		this.idestadoregistro = idestadoregistro;
	}

	public String getIpmodificacion() {
		return this.ipmodificacion;
	}

	public void setIpmodificacion(String ipmodificacion) {
		this.ipmodificacion = ipmodificacion;
	}

	public String getIpregistro() {
		return this.ipregistro;
	}

	public void setIpregistro(String ipregistro) {
		this.ipregistro = ipregistro;
	}

	public String getUsumodificacion() {
		return this.usumodificacion;
	}

	public void setUsumodificacion(String usumodificacion) {
		this.usumodificacion = usumodificacion;
	}

	public String getUsuregistro() {
		return this.usuregistro;
	}

	public void setUsuregistro(String usuregistro) {
		this.usuregistro = usuregistro;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}