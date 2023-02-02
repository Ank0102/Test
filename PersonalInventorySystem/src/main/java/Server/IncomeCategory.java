 package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Bean.IncomeCategoryBean;
import com.project.Bean.UsersBean;
import com.project.DAO.IncomeCategoryDAO;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class IncomeCategory
 */
@WebServlet("/IncomeCategory")
public class IncomeCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategory() {
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

		out.print("<title>Income Category</title>");
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
		out.print("<a href='login.html'>Logout</a>");

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
	    out.print("  <h2 id='b2'>Income Category</h2>");
	    
	    out.println("<form action='AddIncCategory'>");
	    out.print("  <table>");
	 	
	    out.print(" <tr>");
	    out.print("    <td>Category Name</td>");
		out.print("   <td><input type='text' name='catname'></td>");
		out.print("  </tr>");
		
		
		   out.print(" <tr>");
		    out.print("    <td>Category Details</td>");
		    out.print("<td><input type='text' name='incat' ></td>");
		    out.print("  </tr>");

		out.print(" <tr>");
		out.print("<td><input type='submit' name='submit' value='Add'></td>");
		out.print("<td><input type='reset' value='Cancel'></td>");
		out.print(" </tr>");
		
	     out.print("</table>");
		out.println("</form>");

		
		out.print("<hr size='5' color='dark-gary'>");
		out.print("  <table>");
		
		out.print("  <tr>");
		out.print("      <th>Category Name</th>");
		out.print("      <th>Category Details</th>");
		out.print("      <th>Edit</th>");
		out.print("      <th>Delete</th>");
		out.print("   </tr>");
		
		IncomeCategoryDAO icd = new IncomeCategoryDAO();
		
		ArrayList <IncomeCategoryBean>al= icd.findAll();
		for(IncomeCategoryBean icb:al) {
			int inc_catid = icb.getInc_catid();
		session.setAttribute("inc_catid", inc_catid);
		
		out.print("  <tr>");
		out.print("      <td><input type='label' value="+icb.getInc_catname()+"></td>");
		//out.print("      <td><label>"+eb.getExp_catname()+"</td>");
		
		out.print("     <td><input type='label' value="+icb.getInc_catdetails()+"></td>");
		//out.print("      <td><label>"+eb.getExp_catdetails()+"</td>");

		
		out.print("      <td><a href='UpdateIncCategory?id="+icb.getInc_catid()+"'>Edit</a></td>");
		out.print("     <td><a href='DeleteIncCategory?id="+icb.getInc_catid()+"'>Delete</td>");
		out.print(" </tr>");
		}
		out.print("</table>");
		out.print(" </div>");
		out.print(" </div>");
		out.print("  <footer>");
		out.print("    <p>Developed By Ankit Soni</p>");
		out.print("  </footer>");
		out.print("</body>");
		out.print("</html>");
		
	
	}	
}
