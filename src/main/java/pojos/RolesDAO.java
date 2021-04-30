package pojos;

import java.util.List;

import org.hibernate.Session;



public class RolesDAO {
	
	public static List<Roles> getAllRoles(Session s) {
		String hQuery = "from Roles";
		List<Roles> clientList = s.createQuery(hQuery, Roles.class)
				   	   			           .list();
		return clientList;
	}
	
	public static Roles getRol(Session s, int Id) {
	  String hQuery = " from Roles r " +
	                  " where r.Id = :Id";
	  Roles r = s.createQuery(hQuery, Roles.class)
	                   .setParameter("Id", Id)
	                   .setMaxResults(1)
	                   .uniqueResult();
	  return r;
	}
	
	public static void insertRol(Session s, Roles r) {	
		s.save(r);
	}
}
