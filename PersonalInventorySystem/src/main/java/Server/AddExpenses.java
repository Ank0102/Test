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

import com.project.Bean.ExpensesCategoryBean;
import com.project.Bean.UsersBean;
import com.project.DAO.ExpensesCategoryDAO;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class AddExpenses
 */
@WebServlet("/AddExpenses")
public class AddExpenses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExpenses() {
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

		out.print("<title>Add Expenses</title>");
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
		
		
		int r=11;
		String done="none";
		String failed="none";
		
		try {
			r=(Integer)session.getAttribute("r");
		}catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
			ne.printStackTrace();
		}
		
		
		
		
		
		if(r!=11 && r>0) {
			done="inline";
			failed="none";
		}
		else if(r == 11)
		{
			done="none";
			failed="none";
		}else {
			done="none";
			failed="inline";
		}
		
		response.setContentType("text/html");
		
		
	    out.print(" <div id='about'>");
	    out.print("  <h2 id='b2'style='display:inline'>Expenses</h2>");
	    out.print("<span style='color:#2dff00;font-size:24px;display:"+done+";'>Added successfully</span>");
	    out.print("<span style='color:red;font-size:24px;display:"+failed+";'>Failed</span>");

	    session.setAttribute("r", 11);
	    
	    
	    
	    out.println("<form action='AddExp'>");
	    
	    out.print("  <table>");
	 	
	    out.print(" <tr>");
	    out.print("    <td>Expenses</td>");
		out.print("   <td><input type='text' name='expenses'></td>");
		out.print("  </tr>");
		
		
		   out.print(" <tr>");
		    out.print("    <td>Category</td>");
		    out.print("<td><select name ='category'>");
		    ExpensesCategoryDAO ed = new ExpensesCategoryDAO();
			ArrayList <ExpensesCategoryBean>al= ed.findAll();
			for(ExpensesCategoryBean eb:al) {
		    out.print("  <option>"+eb.getExp_catname()+"</option>");
			}
		    out.print("  </select>");
		    out.print("  </td>");

		    out.print("  </tr>");
			
		    
		    
		    out.print(" <tr>");
		    out.print("    <td>Amount</td>");
			out.print("   <td><input type='text' name='amount'></td>");
			out.print("  </tr>");
		    
			

			   out.print(" <tr>");
			    out.print("    <td>PayBy</td>");	    
			    out.print("<td><select name ='payby'>"); 
			    out.print("  <option>Cash</option>");
			    out.print("  <option>Bank</option>");
			    out.print("  </select>");
			    out.print("  </td>");
			    out.print("  </tr>");
			    
			    out.print(" <tr>");
			    out.print("    <td>Date</td>");
				out.print("   <td><input type='text' name='date'></td>");
				out.print("  </tr>");
				
				
				out.print(" <tr>");
			    out.print("    <td>Remark</td>");
				out.print("   <td><input type='text' name='remark'></td>");
				out.print("  </tr>");
				
				
		    
		    
		out.print(" <tr>");
		out.print("<td><input type='submit' name='submit' value='Add'></td>");
		out.print("<td><input type='reset' value='Cancel'></td>");
		out.print(" </tr>");
		
	     out.print("</table>");
		out.println("</form>");

		out.print(" </div>");
		out.print(" </div>");
		out.print("  <footer>");
		out.print("    <p>Developed By Ankit Soni</p>");
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
