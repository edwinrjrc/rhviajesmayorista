package pe.rhviajes.mayorista.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRemote;
import pe.rhviajes.mayorista.negocio.excepcion.RHViajesException;

/**
 * Servlet implementation class ServletRedirigir
 */
@WebServlet("/ServletRedirigir")
public class ServletRedirigir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(lookup = "java:jboss/exported/RHViajesMayNegocioEAR/RHViajesMayNegocio/Seguridad!pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRemote")
	private SeguridadRemote seguridadRemote;

	public ServletRedirigir() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("llamada servlet 2");
		// response.sendRedirect("paginas/inicio.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuarioLogin");
		HttpSession session = request.getSession(true);
		try {
			session.setAttribute("UsuarioSession",
					seguridadRemote.consultarUsuario(usuario));
		} catch (RHViajesException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/paginas/inicio.jsp")
				.forward(request, response);
	}

}
