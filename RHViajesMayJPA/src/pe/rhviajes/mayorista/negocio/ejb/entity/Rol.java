package pe.rhviajes.mayorista.negocio.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="seguridad.rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_ID_GENERATOR", sequenceName="SEGURIDAD.SEQ_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	private Timestamp fecmodificacion;

	@Column(nullable=false)
	private Timestamp fecregistro;

	private Integer idempresa;

	@Column(nullable=false)
	private Integer idestadoregistro;

	private Integer idrol;

	private Integer idusuario;

	@Column(length=50)
	private String ipmodificacion;

	@Column(length=50)
	private String ipregistro;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(length=50)
	private String usumodificacion;

	@Column(nullable=false, length=50)
	private String usuregistro;

	//bi-directional many-to-one association to Usuariorol
	@OneToMany(mappedBy="rol", cascade={CascadeType.ALL})
	private List<Usuariorol> usuariorols;

	public Rol() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<Usuariorol> getUsuariorols() {
		return this.usuariorols;
	}

	public void setUsuariorols(List<Usuariorol> usuariorols) {
		this.usuariorols = usuariorols;
	}

	public Usuariorol addUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().add(usuariorol);
		usuariorol.setRol(this);

		return usuariorol;
	}

	public Usuariorol removeUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().remove(usuariorol);
		usuariorol.setRol(null);

		return usuariorol;
	}

}