 package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Bean.CashBookBean;
import com.project.Bean.ExpensesBean;
import com.project.Bean.IncomeBean;
import com.project.Bean.UsersBean;
import com.project.DAO.CashBookDAO;
import com.project.DAO.ExpensesDAO;
import com.project.DAO.IncomeDAO;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class BalanceSheet
 */
@WebServlet("/BalanceSheet")
public class BalanceSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceSheet() {
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

		out.print("<title>Balance Sheet</title>");
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
	    out.print("  <h2 id='b2'>Balance Sheet</h2>");
	    
	   
	    
	    
	    out.println("<form action='BalanceSheetController'>");
	    
	    out.print("  <table cellspacing='0',border='3px solid black'>");	    	
	 	
	    out.print(" <tr>");

		out.print("   <td style='text-align: right'>Date From</td>");
	    out.print("    <td>To</td>");
	    out.print("    <td></td>");

		out.print("  </tr>");
		
			ExpensesDAO ed = new ExpensesDAO();
			ArrayList<ExpensesBean> eb=ed.findAll();
		
		
		   IncomeDAO id = new IncomeDAO();

		   out.print(" <tr style='color:White'>");	

		   ArrayList<IncomeBean> ib= id.findAll();
		    out.print("<td style='text-align: right'><select name ='date1'>");
		    for (IncomeBean d1:ib) {
			    out.print("  <option>"+d1.getTransaction_date()+"</option>");

		    }
		    out.print("  </select>");
		    out.print("  </td>");
			
			
		    out.print("<td><select name ='date2'>");
		    for (IncomeBean d1:ib) {
			    out.print("  <option>"+d1.getTransaction_date()+"</option>");

		    }
		 
		    out.print("  </select>");
		    out.print("  </td>");		    
		    out.print("<td><button id='showcash'>SHOW</button></td>");
		    out.print("    <td></td>");

		    
		    out.print("  </tr>");
			
		    
		    
			out.print(" <tr style='background-color:black;text-align: center;font-weight: bold;color:White'>");
		    out.print("    <td>Incomes</td>");
			out.print("   <td></td>");
			out.print("   <td>Expenses</td>");
			out.print("   <td></td>");
			out.print("  </tr>");
		    		
	out.print(" <tr >");

			out.print("<td>");

			out.print("<table style='display: inline'>");
			out.print("<tr style='background-color:#baacac;text-align: center;font-weight: bold'>");
			out.print("<td>Income</td>");
			out.print("<td> Amount</td>");
			
			out.print("</tr>");
			
			double incsum=0.00;
			for(IncomeBean iib:ib)
			{
				out.print("<tr>");
			    out.print("    <td style='text-align: center'>"+iib.getInc_ac()+"</td>");
			    out.print("    <td style='text-align: center'>"+iib.getAmount()+"</td>");
			    incsum=incsum+(Double)iib.getAmount();
				out.print("</tr>");
			}
				out.print(" <tr style='background-color:black;text-align: center;font-weight: bold;color:White'>");
			    out.print("<td>Total</td>");

			    out.print("<td>"+incsum+"</td?");

			    out.print("</tr>");
				
			
			out.print("</table>");
			out.print("</td>");
			
			
			
			
			
			out.print("<td></td>");
			out.print("<td>");

			out.print("<table style='display: inline'>");
			out.print("<tr style='background-color:#baacac;text-align: center;font-weight: bold'>");
			out.print("<td>expenses</td>");
			out.print("<td>Amount</td>");

			out.print("</tr>");
			double expsum=0.00;
			for(ExpensesBean eeb:eb)
			{
				out.print("<tr>");
			    out.print("    <td style='text-align: center'>"+eeb.getExp_ac()+"</td>");
			    out.print("    <td style='text-align: center'>"+eeb.getAmount()+"</td>");
			    expsum=expsum+(Double)eeb.getAmount();
				out.print("</tr>");
				
			}
			
			out.print(" <tr style='background-color:black;text-align: center;font-weight: bold;color:White'>");
		    out.print("<td>Total</td>");

		    out.print("<td>"+expsum+"</td?");

		    out.print("</tr>");

			
			out.print("</table>");
		
			
			out.print("</td>");

			out.print("<td></td>");

			    out.print("</tr>");

			 
				out.print(" <tr style='background-color:black;text-align: center;font-weight: bold;color:White'>");
				out.print("    <td></td>");
			
			    out.print("    <td></td>");
		    out.print("    <td>Gross Profit</td>");
		    double gross=incsum-expsum;
		    out.print("    <td>"+gross+"</td>");

			out.print("  </tr>");
	
		
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
