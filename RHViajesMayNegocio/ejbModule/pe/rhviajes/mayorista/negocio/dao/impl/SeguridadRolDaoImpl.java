package pe.rhviajes.mayorista.negocio.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import pe.rhviajes.mayorista.bean.Rol;
import pe.rhviajes.mayorista.negocio.ejb.session.SeguridadRolDao;
import pe.rhviajes.mayorista.negocio.util.UtilJpa;

/**
 * Session Bean implementation class SeguridadRolDaoImpl
 */
@Stateless
public class SeguridadRolDaoImpl extends UtilJpa<pe.rhviajes.mayorista.negocio.ejb.entity.Rol> implements SeguridadRolDao {

    /**
     * Default constructor. 
     */
    public SeguridadRolDaoImpl() {
    	super(pe.rhviajes.mayorista.negocio.ejb.entity.Rol.class);
    }

	@Override
	public List<Rol> listarRoles() {
		String consulta = "select r from Rol r";
    	List listaRoles = listarRegistros(consulta);
    	List<Rol> roles = null;
    	if (listaRoles != null){
    		roles = new ArrayList<Rol>();
    		Rol rolBean = null;
    		for (int i=0; i<listaRoles.size(); i++) {
    			pe.rhviajes.mayorista.negocio.ejb.entity.Rol rol = (pe.rhviajes.mayorista.negocio.ejb.entity.Rol)listaRoles.get(i);
    			rolBean = new Rol();
    			rolBean.setId(rol.getId());
    			rolBean.setNombre(rol.getNombre());
    			roles.add(rolBean);
			}
    	}
    	
		return roles;
	}

}
