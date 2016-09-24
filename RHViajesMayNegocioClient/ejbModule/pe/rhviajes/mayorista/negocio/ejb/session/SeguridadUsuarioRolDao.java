package pe.rhviajes.mayorista.negocio.ejb.session;

import javax.ejb.Local;

import pe.rhviajes.mayorista.negocio.ejb.entity.Usuariorol;

@Local
public interface SeguridadUsuarioRolDao {
	
	public Usuariorol registrarUsuarioRol(Usuariorol usuariorol) throws Exception;

}
