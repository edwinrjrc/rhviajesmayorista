package pe.rhviajes.mayorista.negocio.ejb.session;

import java.util.List;

import javax.ejb.Remote;

import pe.rhviajes.mayorista.bean.Rol;
import pe.rhviajes.mayorista.bean.Usuario;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

@Remote
public interface SeguridadRemote {

	List<Usuario> listarUsuarios() throws RHViajesException;
	
	List<Rol> listarRoles() throws RHViajesException;
	
	boolean registrarUsuario(Usuario usuario) throws RHViajesException;

}
