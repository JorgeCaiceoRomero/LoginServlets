package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Usuarios;
import pojos.UsuariosDAO;
import util.HibernateUtil;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static SessionFactory sessionFactory;
	Session session;
	PrintWriter out;
	private static Logger logger = LogManager.getLogger(AltaRol.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		
		logger.info("Se ha cargado la página");
		
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Transaction tx=session.beginTransaction();
		out = response.getWriter();
		String idRol = request.getParameter("idrol");
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String telefono = request.getParameter("telefono");
		String dni = request.getParameter("dni");
		Usuarios u = new Usuarios(idRol, email, clave, nombre, apellido1, apellido2, direccion, localidad, provincia, telefono, dni);
		UsuariosDAO.insertUsuario(session, u);
		tx.commit();
		
		logger.info("Se ha insertado el usuario "+nombre);
		
		//Se muestra la pagina
        out.println("<html>");
        out.println("<head></head>");         
        out.println("<body>");
        out.println("Se ha registrado el usuario "+nombre);
        out.println("<br>");
        
        out.println("</body>");
        out.println("</html>");
	}

}
