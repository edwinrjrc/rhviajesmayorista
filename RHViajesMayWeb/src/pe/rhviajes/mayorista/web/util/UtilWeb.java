/**
 * 
 */
package pe.rhviajes.mayorista.web.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import pe.rhviajes.mayorista.bean.Usuario;

/**
 * @author Edwin
 *
 */
public class UtilWeb {
	
	public static String obtenerIp(ServletRequest request){
		return request.getRemoteAddr();
	}
	
	public static String obtenerUsuario(HttpSession session){
		Usuario usuario = (Usuario)session.getAttribute("");
		return usuario.getLogin();
	}

}
