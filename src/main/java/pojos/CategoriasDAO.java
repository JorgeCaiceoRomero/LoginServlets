package pojos;

import java.util.List;

import org.hibernate.Session;

public class CategoriasDAO {
	public static List<Categorias> getAllCategorias(Session s) {
		String hQuery = "from Categorias";
		List<Categorias> clientList = s.createQuery(hQuery, Categorias.class)
				   	   			           .list();
		return clientList;
	}
	
	public static Categorias getCategoria(Session s, int Id) {
	  String hQuery = " from Categorias r " +
	                  " where r.Id = :Id";
	  Categorias r = s.createQuery(hQuery, Categorias.class)
	                   .setParameter("Id", Id)
	                   .setMaxResults(1)
	                   .uniqueResult();
	  return r;
	}
	
	public static void insertCategoria(Session s, Categorias r) {	
		s.save(r);
	}
}
