package pe.rhviajes.mayorista.negocio.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="seguridad.usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR", sequenceName="SEGURIDAD.SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=100)
	private String apematerno;

	@Column(nullable=false, length=100)
	private String apepaterno;

	@Column(nullable=false)
	private Timestamp fecmodificacion;

	@Column(nullable=false)
	private Timestamp fecregistro;

	@Column(nullable=false)
	private Integer idempresa;

	@Column(nullable=false)
	private Integer idestadoregistro;

	@Column(nullable=false, length=50)
	private String ipmodificacion;

	@Column(nullable=false, length=50)
	private String ipregistro;

	@Column(nullable=false, length=15)
	private String login;

	@Column(nullable=false, length=150)
	private String nombres;

	@Column(nullable=false, length=100)
	private String password;

	@Column(nullable=false, length=50)
	private String usumodificacion;

	@Column(nullable=false, length=50)
	private String usuregistro;

	//bi-directional many-to-one association to Usuariorol
	@OneToMany(mappedBy="usuario")
	private List<Usuariorol> usuariorols;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApematerno() {
		return this.apematerno;
	}

	public void setApematerno(String apematerno) {
		this.apematerno = apematerno;
	}

	public String getApepaterno() {
		return this.apepaterno;
	}

	public void setApepaterno(String apepaterno) {
		this.apepaterno = apepaterno;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		usuariorol.setUsuario(this);

		return usuariorol;
	}

	public Usuariorol removeUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().remove(usuariorol);
		usuariorol.setUsuario(null);

		return usuariorol;
	}

}