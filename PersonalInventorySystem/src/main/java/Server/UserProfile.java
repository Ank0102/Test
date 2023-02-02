 package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Bean.UsersBean;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session =request.getSession();
		String username=(String)session.getAttribute("user");
		int userid=(Integer)session.getAttribute("eid");

		UsersDAO ud = new UsersDAO();
		UsersBean ub=ud.findByUserid(userid);
		out.print("<html>");
		out.print("<head>");

		out.print("<title>User Profile</title>");
		out.print("<link rel='stylesheet' href='index.css'>");
		out.print("</head>");

		out.print("<body>");
		out.print("<nav>");
		out.print("<div id='nav'>");
		out.print("<div class='brand'>");
		out.print("<h1 id='b1'>Personal</h1>");
		out.print("<h1 id='b2'>Inventory<span id='b3'>System</span></h1>");
		out.print("</div>");
		out.print(" <div id='menu'>");
		out.print(" <a href='AfterLogin'>Home</a>");
		out.print(" <a href='UserProfile'>Profile</a>");
		out.print("   <a href='UserUpdate'>Update Profile</a>");
		out.print("      <a href='login.html'>Logout</a>");

		out.print("   </div>");
		out.print(" </div>");
		out.print(" <hr size='5' color='dark-gary'>");
		out.print("  </nav>");

		out.print(" <div class='container'>");
		out.print("<div id='master'>");
		out.print("<h3>Hello, "+username+"</h3>");
		out.print("   <div>");
		out.print("<hr size='5' color='dark-gary'>");
		out.print("    <ul>");
		out.print("  <li><a href='ExpensesCategory'>Expenses Category</a></li>");	
		out.print("  <li><a href='IncomeCategory'>Income Category</a></li>");
		out.print("  <li><a href='AddExpenses'>Expenses</a></li>");
		out.print(" <li><a href='Income'>Income</a></li>");
		out.print(" <li><a href='CashBook'>Cash Book</a></li>");
		out.print("<li><a href='BankBook'>Bank Book</a></li>");
		out.print("<li><a href='DayBook'>Day Book</a></li>");
		out.print(" <li><a href='BalanceSheet'>Balance Sheet</a></li>");
		out.print("  </ul>");
		out.print(" </div>");
		out.print("  </div>");
		
	    out.print(" <div id='about'>");
	    out.print("  <h2 id='b2'>User profile</h2>");
	    
	    
	    out.print("  <table>");
	    out.print(" <tr>");
	    out.print("    <td>User Name:</td>");
		out.print("   <td>" + ub.getUsername() + "</td>");
		out.print("  </tr>");
		out.print("  <tr>");
		out.print("      <td>Password:</td>");
		out.print("     <td>" + ub.getPassword() + "</td> ");  
		out.print("   </tr>");
		out.print("  <tr>");
		out.print("      <td>Name:</td>");
		out.print("     <td>" + ub.getName() + "</td>");
		out.print(" </tr>");
		out.print("   <tr>");
		out.print("  <td>Address:</td>");
		out.print(" <td>" + ub.getAddress() + "</td>");
		out.print("  </tr>");
		out.print("  <tr>");
		out.print("      <td>Mobile:</td>");
		out.print("     <td>" + ub.getMobile() + "</td>");
		out.print(" </tr>");
		out.print(" <tr>");
		out.print("   <td>Email ID:</td>");
		out.print("   <td>" + ub.getEmail() + "</td>");
		out.print(" </tr>");
		out.print("</table>");
		out.print(" </div>");
		out.print(" </div>");
		out.print("  <footer>");
		out.print("    <p>Developed By Ankit Soni</p>");
		out.print("  </footer>");
		out.print("</body>");
		out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
