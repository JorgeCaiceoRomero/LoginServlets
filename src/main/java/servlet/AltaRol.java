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

import pojos.Roles;
import pojos.RolesDAO;
import util.HibernateUtil;

/**
 * Servlet implementation class AltaRol
 */
@WebServlet("/AltaRol")
public class AltaRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	static SessionFactory sessionFactory;
	Session session;
	PrintWriter out;
	private static Logger logger = LogManager.getLogger(AltaRol.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRol() {
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
		String nombreRol = request.getParameter("rol");
		Roles nuevoRol = new Roles(nombreRol);
		RolesDAO.insertRol(session, nuevoRol);
		tx.commit();
		
		logger.info("Se ha insertado el rol "+nombreRol);
		
		//Se muestra la pagina
        out.println("<html>");
        out.println("<head></head>");         
        out.println("<body>");
        out.println("Se ha insertado el rol");
        out.println("<br>");
        
        out.println("</body>");
        out.println("</html>");
	}

}
