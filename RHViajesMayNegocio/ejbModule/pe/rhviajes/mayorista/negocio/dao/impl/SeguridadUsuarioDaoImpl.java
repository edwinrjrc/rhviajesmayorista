/**
 * 
 */
package pe.rhviajes.mayorista.negocio.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import pe.rhviajes.mayorista.negocio.ejb.entity.Usuario;
import pe.rhviajes.mayorista.negocio.ejb.session.SeguridadUsuarioDao;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;
import pe.rhviajes.mayorista.negocio.util.UtilJpa;

/**
 * @author Edwin
 *	
 */
@Stateless
@LocalBean
public class SeguridadUsuarioDaoImpl extends UtilJpa<Usuario> implements SeguridadUsuarioDao {
	
	public SeguridadUsuarioDaoImpl() {
		super(Usuario.class);
	}

	/* (non-Javadoc)
	 * @see pe.rhviajes.mayorista.negocio.dao.SeguridadDao#listarUsuario(pe.rhviajes.mayorista.bean.Usuario)
	 */
	@Override
	public List<pe.rhviajes.mayorista.bean.Usuario> listarUsuario(pe.rhviajes.mayorista.bean.Usuario usuario) throws SQLException, RHViajesException {
		String consulta = "select u from Usuario u";
    	List<Usuario> listaUsuarios = listarRegistros(consulta);
    	List<pe.rhviajes.mayorista.bean.Usuario> listaResultado = null;
    	if (listaUsuarios !=  null){
    		pe.rhviajes.mayorista.bean.Usuario usuarioBean = null;
    		listaResultado = new ArrayList<pe.rhviajes.mayorista.bean.Usuario>();
    		for (Usuario usuario2 : listaUsuarios) {
    			usuarioBean = new pe.rhviajes.mayorista.bean.Usuario();
    			usuarioBean.setId(usuario2.getId());
    			usuarioBean.setNombres(usuario2.getNombres());
    			usuarioBean.setApellidoPaterno(usuario2.getApepaterno());
    			usuarioBean.setApellidoMaterno(usuario2.getApematerno());
    			usuarioBean.setLogin(usuario2.getLogin());
    			listaResultado.add(usuarioBean);
    		}
    	}
    	
		return listaResultado;
	}

	/* (non-Javadoc)
	 * @see pe.rhviajes.mayorista.negocio.dao.SeguridadDao#registrarUsuario(pe.rhviajes.mayorista.bean.Usuario)
	 */
	@Override
	public Usuario registrarUsuario(Usuario usuario) throws Exception{
		return guardarEntity(usuario);
	}

	/* (non-Javadoc)
	 * @see pe.rhviajes.mayorista.negocio.dao.SeguridadDao#actualizarUsuario(pe.rhviajes.mayorista.bean.Usuario)
	 */
	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario consultarUsuario(String login) throws SQLException,
			Exception {
		String consulta = "select u from Usuario u where u.login=:p_login";
		return buscarRegistro(consulta, "p_login", login);
	}

}
