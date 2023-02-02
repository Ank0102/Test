 package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Bean.UsersBean;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class LoginServer
 */
@WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		 String iusername = request.getParameter("username");
		String ipassword = request.getParameter("password");

		UsersDAO ud = new UsersDAO();
		
		UsersBean ub = ud.findByUserName(iusername);
		
		int id=ub.getUserid();
		  HttpSession session = request.getSession(); 
		  session.setAttribute("eid", id);
		  session.setAttribute("user", iusername);
	      System.out.println(iusername + ipassword);
		

		if(iusername.equals(ub.getUsername()) && ipassword.equals(ub.getPassword())) 
		{
			
			  RequestDispatcher rd =request.getRequestDispatcher("AfterLogin");
			rd.forward(request, response);
			
		}
		
		else
		{
			out.println("<h1 style='color: red;'>Login Failed Try Again</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}
	}	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}