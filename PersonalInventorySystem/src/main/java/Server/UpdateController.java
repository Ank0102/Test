 package Server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Bean.UsersBean;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		
		UsersDAO ud = new UsersDAO();
		UsersBean ub = new UsersBean();
		
		ub.setUserid(userid);
		
		ub.setUsername(username);
		ub.setPassword(password);
		ub.setName(name);
		ub.setAddress(address);
		ub.setMobile(mobile);
		ub.setEmail(email);
		
	int r=	ud.updateUser(ub);
		if(r>0) {
			response.sendRedirect("UserProfile");
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
