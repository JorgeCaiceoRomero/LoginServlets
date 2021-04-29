package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


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

import pojos.Roles;
import pojos.RolesDAO;
import pojos.Usuarios;
import pojos.UsuariosDAO;
import util.HibernateUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static Logger logger = LogManager.getLogger(Login.class);
	
	static SessionFactory sessionFactory;
	Session session;
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*response.setContentType("text/html");
		out = response.getWriter();
		imprimeFormulario(out);
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuarios usuario = null;
		out = response.getWriter();
		String usu=request.getParameter("user");
		String cla=request.getParameter("pass");
		boolean pass = false;
		usuario = UsuariosDAO.getUsuarios(session, usu);
		if(usuario!=null) {
			if(usuario.getClave().equals(cla)&&!cla.equals(null)) {
			pass=true;
		}
		}
		
		response.setContentType("text/html");
		
		if(pass) {
			
			logger.info("Credenciales correctas");
	        out.println("<html>");
	        out.println("<head></head>");         
	        out.println("<body>");
	
	        out.println("Usuario:");
	        
	        out.println(usuario.getNombre());
	        out.println("<br>");
	        
	        out.println("</body>");
	        out.println("</html>");  
		
		}
		else {
			logger.info("Credenciales incorrectas");
			out.println("<html>");
	        out.println("<head></head>");         
	        out.println("<body>");
	
	        out.println("Credenciales incorrectas");
	        out.println("<br>");
	        
	        out.println("</body>");
	        out.println("</html>");
		}
	}
	
	/*private void imprimeFormulario(PrintWriter out) {
		
		PrintWriter res = out;
		
		res.println("<html>");
		res.println("<title>Servlet Login</title>");
		res.println("<body>");
		res.println("<div><label>User: </label></div>");
		res.println("<div><input type=\"text\" name=\"user\" size=\"20\"><br></div>");
		
		res.println("<div><label>Pass: </label></div>");
		res.println("<div><input type=\"password\" name=\"pass\" size=\"20\"></div>");
		
		res.println("<input type=\"submit\" name=\"submit\" value=\"Entrar\" method=\"post\">");
		res.println("</body>");
		res.println("</html>");

	}*/

}
