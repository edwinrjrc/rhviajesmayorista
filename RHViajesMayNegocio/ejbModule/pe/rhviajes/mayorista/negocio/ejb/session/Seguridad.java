package pe.rhviajes.mayorista.negocio.ejb.session;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pe.rhviajes.mayorista.bean.Rol;
import pe.rhviajes.mayorista.bean.Usuario;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

/**
 * Session Bean implementation class Seguridad
 */
@Stateless
public class Seguridad implements SeguridadRemote, SeguridadLocal {
	
	@EJB
	SeguridadUsuarioDao seguridadUsuarioDao;
	
	@Override
	public List<Usuario> listarUsuarios() throws RHViajesException {
		try {
			return seguridadUsuarioDao.listarUsuario(null);
		} catch (SQLException e) {
			throw new RHViajesException(e);
		}
	}

	@Override
	public List<Rol> listarRoles() throws RHViajesException {
		return null;
	}

	@Override
	public boolean registrarUsuario(Usuario beanUsuario) throws RHViajesException {
		return false;
	}
}
