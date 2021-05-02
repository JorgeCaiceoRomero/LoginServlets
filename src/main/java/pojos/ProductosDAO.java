package pojos;

import java.util.List;

import org.hibernate.Session;

public class ProductosDAO {
	public static List<Productos> getAllProductos(Session s) {
		String hQuery = "from Productos";
		List<Productos> clientList = s.createQuery(hQuery, Productos.class)
				   	   			           .list();
		return clientList;
	}
	
	public static Productos getProductos(Session s, int Id) {
	  String hQuery = " from Productos r " +
	                  " where r.Id = :Id";
	  Productos r = s.createQuery(hQuery, Productos.class)
	                   .setParameter("Id", Id)
	                   .setMaxResults(1)
	                   .uniqueResult();
	  return r;
	}
	
	public static void insertProducto(Session s, Productos r) {	
		s.save(r);
	}
}
