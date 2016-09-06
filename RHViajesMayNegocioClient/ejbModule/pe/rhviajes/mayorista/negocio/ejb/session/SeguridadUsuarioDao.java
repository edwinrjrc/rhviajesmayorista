/**
 * 
 */
package pe.rhviajes.mayorista.negocio.ejb.session;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import pe.rhviajes.mayorista.negocio.ejb.entity.Usuario;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

/**
 * @author Edwin
 *
 */
@Local
public interface SeguridadUsuarioDao {

	public List<pe.rhviajes.mayorista.bean.Usuario> listarUsuario(pe.rhviajes.mayorista.bean.Usuario usuario) throws SQLException, RHViajesException;
	
	public void registrarUsuario(Usuario usuario);
	
	public void actualizarUsuario(Usuario usuario);
	
}
