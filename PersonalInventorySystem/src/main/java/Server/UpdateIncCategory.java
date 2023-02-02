 package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Bean.ExpensesCategoryBean;
import com.project.Bean.IncomeCategoryBean;
import com.project.DAO.ExpensesCategoryDAO;
import com.project.DAO.IncomeCategoryDAO;

/**
 * Servlet implementation class UpdateIncCategory
 */
@WebServlet("/UpdateIncCategory")
public class UpdateIncCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIncCategory() {
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
		
		
		
		int inccatid=Integer.parseInt(request.getParameter("id"));
		
		IncomeCategoryDAO icd = new IncomeCategoryDAO();
		IncomeCategoryBean icb = icd.findByIncCatId(inccatid);

		
		out.print("<html>");
		out.print("<head>");

		out.print("<title>Update Income Category</title>");
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
	    out.print("  <h2 id='b2'>Update Income Category</h2>");
	    
	    out.println("<form action='IncCategoryController'>");
	    out.print("  <table>");
	    out.print(" <tr>");
	    out.print("    <td>Income Category ID:</td>");
	    out.print("<td><input type='text' name='inccatid' value="+icb.getInc_catid() + "></td>");
	    out.print("  </tr>");
		
	    out.print(" <tr>");
	    out.print("    <td> Income Category Name:</td>");
		out.print("   <td><input type='text' name='inccatname' value="+icb.getInc_catname() + "></td>");
		out.print("  </tr>");
		out.print("  <tr>");
		out.print("      <td>Income Category Details:</td>");
		out.print("     <td><input type='text' name='inccatdetails' value="+icb.getInc_catdetails() + "></td> ");  
		out.print("   </tr>");
		out.print("  <tr>");
		out.print("      <td>Userid:</td>");
		out.print("     <td><input type='text' name='userid' value="+icb.getUserid() + "></td>");
		out.print(" </tr>");
		
		
		out.print(" <tr>");
		out.print("   <td></td>");
		out.print("   <td><input type='submit' name='submit' value='Update'></td>");
		out.print(" </tr>");
		
		
		
		out.print("</table>");
		
		out.println("</form>");
		out.print(" </div>");
		out.print(" </div>");
		out.print("  <footer>");
		out.print("    <p>Developed By Shankar Patidar</p>");
		out.print("  </footer>");
		out.print("</body>");
		out.print("</html>");
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
