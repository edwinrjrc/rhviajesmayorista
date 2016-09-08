package pe.rhviajes.mayorista.negocio.ejb.session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pe.rhviajes.mayorista.bean.Rol;
import pe.rhviajes.mayorista.bean.Usuario;
import pe.rhviajes.mayorista.negocio.ejb.entity.Usuariorol;
import pe.rhviajes.mayorista.negocio.ejb.entity.UsuariorolPK;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

/**
 * Session Bean implementation class Seguridad
 */
@Stateless
public class Seguridad implements SeguridadRemote, SeguridadLocal {
	
	@EJB
	SeguridadUsuarioDao seguridadUsuarioDao;
	@EJB
	SeguridadRolDao seguridadRolDao; 
	
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
		return seguridadRolDao.listarRoles();
	}

	@Override
	public boolean registrarUsuario(Usuario beanUsuario) throws RHViajesException {
		pe.rhviajes.mayorista.negocio.ejb.entity.Usuario usuario = new pe.rhviajes.mayorista.negocio.ejb.entity.Usuario();
		usuario.setNombres(beanUsuario.getNombres());
		usuario.setApepaterno(beanUsuario.getApellidoPaterno());
		usuario.setApematerno(beanUsuario.getApellidoMaterno());
		usuario.setLogin(beanUsuario.getLogin());
		usuario.setPassword(beanUsuario.getPassword());
		usuario.setIdempresa(beanUsuario.getIdEmpresa());
		List<Usuariorol> usuariorols = new ArrayList<Usuariorol>();
		Usuariorol usuarioRol = null;
		for(int i=0; i<beanUsuario.getRoles().size(); i++){
			usuarioRol = new Usuariorol();
			UsuariorolPK id = new UsuariorolPK();
			id.setIdrol(beanUsuario.getRoles().get(i).getId());
			id.setIdusuario(usuario.getId());
			usuarioRol.setId(id);
			pe.rhviajes.mayorista.negocio.ejb.entity.Rol rol = new pe.rhviajes.mayorista.negocio.ejb.entity.Rol();
			rol.setId(beanUsuario.getRoles().get(i).getId());
			rol.setNombre(beanUsuario.getRoles().get(i).getNombre());
			usuarioRol.setRol(rol);
			usuariorols.add(usuarioRol);
		}
		usuario.setUsuariorols(usuariorols);
		seguridadUsuarioDao.registrarUsuario(usuario);
		return true;
	}
}
