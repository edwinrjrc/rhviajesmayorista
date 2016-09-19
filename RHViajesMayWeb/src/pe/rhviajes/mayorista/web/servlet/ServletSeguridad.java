package pe.rhviajes.mayorista.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import pe.rhviajes.mayorista.bean.Rol;
import pe.rhviajes.mayorista.bean.Usuario;
import pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRemote;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


/**
 * Servlet implementation class ServletSeguridad
 */
@WebServlet("/ServletSeguridad")
public class ServletSeguridad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(lookup="java:jboss/exported/RHViajesMayNegocioEAR/RHViajesMayNegocio/Seguridad!pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRemote")
	private SeguridadRemote seguridadRemote;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio(request, response);
	}

	private void servicio(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Llamada al servlet");
		try {
			PrintWriter respuesta = response.getWriter();
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
					.create();
			
			if (StringUtils.equals("listarCatalogos", request.getParameter("accion"))){
				List<Usuario> lista = this.seguridadRemote.listarUsuarios();
				List<Rol> listaRoles = this.seguridadRemote.listarRoles();
				Map<String, Object> objetos= new HashMap<String, Object>();
				objetos.put("usuarios", lista);
				objetos.put("roles", listaRoles);
				respuesta.println(gson.toJson(objetos));
			}
			else if (StringUtils.equals("ingresarUsuario", request.getParameter("accion"))){
				String formulario = request.getParameter("formulario");
				System.out.println("formulario ::"+formulario);
				Type type = new TypeToken<Map<String, Object>>(){}.getType();
				Map<String, Object> mapeo = gson.fromJson(formulario, type);
				
				Usuario usuario = new Usuario();
				usuario.setLogin(mapeo.get("login").toString());
				usuario.setPassword(mapeo.get("password").toString());
				usuario.setNombres(mapeo.get("nombres").toString());
				usuario.setApellidoPaterno(mapeo.get("apellidoPaterno").toString());
				usuario.setApellidoMaterno(mapeo.get("apellidoMaterno").toString());
				usuario.setUsuarioCreacion("usuario");
				usuario.setUsuarioModificacion("usuario");
				Map<String, Object> mapeoRol = (Map)mapeo.get("rol");
				Rol rol = new Rol();
				rol.setId(Double.valueOf(mapeoRol.get("id").toString()).intValue());
				//rol.setNombre(mapeoRol.get("nombre").toString());
				usuario.getRoles().add(rol);
				
				seguridadRemote.registrarUsuario(usuario);
			}
			
		} catch (RHViajesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
