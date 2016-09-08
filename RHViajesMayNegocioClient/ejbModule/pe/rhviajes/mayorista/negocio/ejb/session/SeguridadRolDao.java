package pe.rhviajes.mayorista.negocio.ejb.session;


import java.util.List;

import javax.ejb.Local;

import pe.rhviajes.mayorista.bean.Rol;

@Local
public interface SeguridadRolDao {

	public List<Rol> listarRoles();
}
