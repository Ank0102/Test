 package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Bean.UsersBean;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class AddUserServer
 */
@WebServlet("/AddUserServer")
public class AddUserServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String name =request.getParameter("name");
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String email=request.getParameter("email");
		String address = request.getParameter("address");
		
		UsersDAO ud= new UsersDAO();
		UsersBean ub = ud.findByUserName(username);
		
		if(username.equals(ub.getUsername()))
		{
			out.println("<h1 style='color: red;'>Ops User Name Alredy Taken.</h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
			rd.include(request, response);
			//out.println("<h2 style='color: blue;'>Please <a href='login.html'>click</a> here for register..</h2>");

		}

		
		
		
		
		//UsersBean ub = new UsersBean();
		ub.setName(name);
		ub.setUsername(username);
		ub.setPassword(password);
		ub.setAddress(address);
		ub.setMobile(mobile);
		ub.setEmail(email);
		
	
		int x=ud.addUser(ub);
		if(x>0)
		{
			out.println("<h1 style='color: #c9f321;'>Registration Successful ,Please Login...</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			//response.sendRedirect("login.html");
		//out.println("<h2 style='color: blue;'>Please <a href='login.html'>click</a> here for login..</h2>");

		}
		else
		{
			out.println("Data failed");

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
