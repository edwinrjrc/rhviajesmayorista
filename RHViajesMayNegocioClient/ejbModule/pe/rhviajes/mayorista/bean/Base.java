package pe.rhviajes.mayorista.bean;

import java.io.Serializable;
import java.util.Date;

public abstract class Base implements Serializable{

	private static final long serialVersionUID = 8495126624075841170L;
	
	private Integer id;
	private String nombre;
	private String codigoCadena;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String ipCreacion;
	private String usuarioModificacion;
	private Date fechaModificacion;
	private String ipModificacion;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the codigoCadena
	 */
	public String getCodigoCadena() {
		return codigoCadena;
	}
	/**
	 * @param codigoCadena the codigoCadena to set
	 */
	public void setCodigoCadena(String codigoCadena) {
		this.codigoCadena = codigoCadena;
	}
	/**
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		if (fechaCreacion == null){
			fechaCreacion = new Date();
		}
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}
	/**
	 * @param ipCreacion the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}
	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		if (fechaModificacion == null){
			fechaModificacion = new Date();
			
		}
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the ipModificacion
	 */
	public String getIpModificacion() {
		return ipModificacion;
	}
	/**
	 * @param ipModificacion the ipModificacion to set
	 */
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
