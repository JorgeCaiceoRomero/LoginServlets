package pojos;

import java.util.List;

import org.hibernate.Session;

public class UsuariosDAO {
	public static List<Usuarios> getAllUsuarios(Session s) {
		String hQuery = "from Usuarios";
		List<Usuarios> usuariosList = s.createQuery(hQuery, Usuarios.class)
				   	   			           .list();
		return usuariosList;
	}
	
	public static Usuarios getUsuarios(Session s, int Id) {
	  String hQuery = " from Usuarios u " +
	                  " where u.Id = :Id";
	  Usuarios u = s.createQuery(hQuery, Usuarios.class)
	                   .setParameter("Id", Id)
	                   .setMaxResults(1)
	                   .uniqueResult();
	  return u;
	}
	
	public static Usuarios getUsuarios(Session s, String nombre) {
		  String hQuery = " from Usuarios u " +
		                  " where u.nombre = :nombre";
		  Usuarios u = s.createQuery(hQuery, Usuarios.class)
		                   .setParameter("nombre", nombre)
		                   .setMaxResults(1)
		                   .uniqueResult();
		  return u;
		}
}
