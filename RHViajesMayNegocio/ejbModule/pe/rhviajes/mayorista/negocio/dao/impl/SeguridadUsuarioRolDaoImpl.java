package pe.rhviajes.mayorista.negocio.dao.impl;

import javax.ejb.Stateless;

import pe.rhviajes.mayorista.negocio.ejb.entity.Usuariorol;
import pe.rhviajes.mayorista.negocio.ejb.session.SeguridadUsuarioRolDao;
import pe.rhviajes.mayorista.negocio.util.UtilJpa;

/**
 * Session Bean implementation class SeguridadUsuarioRolDaoImpl
 */
@Stateless
public class SeguridadUsuarioRolDaoImpl extends UtilJpa<Usuariorol> implements SeguridadUsuarioRolDao {

    /**
     * Default constructor. 
     */
    public SeguridadUsuarioRolDaoImpl() {
    	super(Usuariorol.class);
    }

	@Override
	public Usuariorol registrarUsuarioRol(Usuariorol usuariorol)
			throws Exception {
		return guardarEntity(usuariorol);
	}

}
