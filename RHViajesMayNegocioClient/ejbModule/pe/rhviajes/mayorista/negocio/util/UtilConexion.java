/**
 * 
 */
package pe.rhviajes.mayorista.negocio.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

/**
 * @author Edwin
 *
 */
public class UtilConexion {
	
	private static String JNDI = "java:/jboss/jdbc/rhviajesmayDS";

	public static Connection obtenerConexion() throws RHViajesException{
		try {
			Context ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(JNDI);
			
			return ds.getConnection();
		} catch (NamingException e) {
			throw new RHViajesException(e);
		} catch (SQLException e) {
			throw new RHViajesException(e);
		}
	}
}
