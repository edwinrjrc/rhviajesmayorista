package pe.rhviajes.mayorista.negocio.ejb.session;

import java.sql.SQLException;
import java.sql.Timestamp;
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
	@EJB
	SeguridadUsuarioRolDao seguridadUsuarioRolDao;
	
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
	public boolean registrarUsuario(Usuario beanUsuario) throws Exception {
		pe.rhviajes.mayorista.negocio.ejb.entity.Usuario usuario = new pe.rhviajes.mayorista.negocio.ejb.entity.Usuario();
		usuario.setNombres(beanUsuario.getNombres());
		usuario.setApepaterno(beanUsuario.getApellidoPaterno());
		usuario.setApematerno(beanUsuario.getApellidoMaterno());
		usuario.setLogin(beanUsuario.getLogin());
		usuario.setPassword(beanUsuario.getPassword());
		usuario.setIdempresa(beanUsuario.getIdEmpresa());
		usuario.setUsuregistro(beanUsuario.getUsuarioCreacion());
		usuario.setFecregistro(new Timestamp(beanUsuario.getFechaCreacion().getTime()));
		usuario.setIpregistro("0.0.0.0");
		usuario.setUsumodificacion(beanUsuario.getUsuarioCreacion());
		usuario.setFecmodificacion(new Timestamp(beanUsuario.getFechaModificacion().getTime()));
		usuario.setIpmodificacion("0.0.0.0");
		usuario.setIdempresa(1);
		usuario.setIdestadoregistro(1);
		List<Usuariorol> usuariorols = new ArrayList<Usuariorol>();
		Usuariorol usuarioRol = null;
		for(int i=0; i<beanUsuario.getRoles().size(); i++){
			usuario = seguridadUsuarioDao.registrarUsuario(usuario);
			usuarioRol = new Usuariorol();
			usuarioRol.setUsuario(usuario);
			usuarioRol.setIdempresa(beanUsuario.getIdEmpresa());
			usuarioRol.setUsuregistro(beanUsuario.getUsuarioCreacion());
			usuarioRol.setFecregistro(new Timestamp(beanUsuario.getFechaCreacion().getTime()));
			usuarioRol.setIpregistro("0.0.0.0");
			usuarioRol.setUsumodificacion(beanUsuario.getUsuarioCreacion());
			usuarioRol.setFecmodificacion(new Timestamp(beanUsuario.getFechaModificacion().getTime()));
			usuarioRol.setIpmodificacion("0.0.0.0");
			usuarioRol.setIdempresa(1);
			usuarioRol.setIdestadoregistro(1);
			UsuariorolPK id = new UsuariorolPK();
			id.setIdrol(beanUsuario.getRoles().get(i).getId());
			id.setIdusuario(usuario.getId());
			usuarioRol.setId(id);
			pe.rhviajes.mayorista.negocio.ejb.entity.Rol rol = new pe.rhviajes.mayorista.negocio.ejb.entity.Rol();
			rol.setId(beanUsuario.getRoles().get(i).getId());
			rol.setNombre(beanUsuario.getRoles().get(i).getNombre());
			usuarioRol.setRol(rol);
			usuariorols.add(usuarioRol);
			seguridadUsuarioRolDao.registrarUsuarioRol(usuarioRol);
		}
		usuario.setUsuariorols(usuariorols);
		
		return true;
	}

	@Override
	public boolean inicioSession(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Usuario consultarUsuario(String login) throws RHViajesException{
		try {
			pe.rhviajes.mayorista.negocio.ejb.entity.Usuario usuario = seguridadUsuarioDao.consultarUsuario(login);
			
			Usuario beanUsuario = new Usuario();
			beanUsuario.setLogin(login);
			beanUsuario.setNombre(usuario.getNombres());
			beanUsuario.setNombres(usuario.getNombres());
			beanUsuario.setApellidoPaterno(usuario.getApepaterno());
			beanUsuario.setApellidoMaterno(usuario.getApematerno());
			
			return beanUsuario;
		} catch (Exception e) {
			throw new RHViajesException(e);
		}
	}
}
