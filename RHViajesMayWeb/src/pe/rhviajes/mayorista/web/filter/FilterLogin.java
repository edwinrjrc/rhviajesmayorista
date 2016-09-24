package pe.rhviajes.mayorista.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRemote;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter(filterName="FilterLogin", urlPatterns={"/j_security_check"})
public class FilterLogin implements Filter {
	
	@EJB(lookup="java:jboss/exported/RHViajesMayNegocioEAR/RHViajesMayNegocio/Seguridad!pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRemote")
	private SeguridadRemote seguridadRemote;

    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Lanzando filtro");
		
		Enumeration<String> nombres = request.getParameterNames();
		while (nombres.hasMoreElements()){
			System.out.println("Parameter ::"+nombres.nextElement());
		}
		System.out.println("Fin de parametros");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
