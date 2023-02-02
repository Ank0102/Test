 package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Bean.BankBookBean;
import com.project.Bean.CashBookBean;
import com.project.Bean.ExpensesBean;
import com.project.Bean.IncomeBean;
import com.project.DAO.BankBookDAO;
import com.project.DAO.CashBookDAO;
import com.project.DAO.ExpensesDAO;
import com.project.DAO.IncomeDAO;

/**
 * Servlet implementation class AddIncome
 */
@WebServlet("/AddIncome")
public class AddIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIncome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
	
		int userid=(Integer)session.getAttribute("eid");
		int inc_catid=(Integer)session.getAttribute("inc_catid");
		
		String income= request.getParameter("income");
		String category = request.getParameter("category");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String date =request.getParameter("date");
		String receiveby=request.getParameter("receiveby");
		String remark=request.getParameter("remark");
		
		
		
		IncomeDAO id = new IncomeDAO();	
		IncomeBean ib = new IncomeBean();
		
		
		ib.setInc_ac(income);
		ib.setInc_category(category);
		ib.setUserid(userid);
		ib.setInc_catid(inc_catid);
		ib.setAmount(amount);
		ib.setTransaction_date(date);
		ib.setReceivby(receiveby);
		ib.setRemark(remark);
		
		
		 int e=id.addIncome(ib);
		 
		 if(e>0) {
			 session.setAttribute("e", e);

			response.sendRedirect("Income");
			 
		 }
		 
		 
		 
		 String type="cash";

			if(type.equalsIgnoreCase(receiveby)) {
			CashBookDAO cd = new CashBookDAO();
			CashBookBean cb = new CashBookBean();
			cb.setAccount(income);
			cb.setTransaction_date(date);
			cb.setAmount(amount);
			cb.setUserid(userid);
			cb.setOperation("Receive");
			cd.addCashbook(cb);
			
				 
			 }
			
			
			 String typee="bank";

				if(typee.equalsIgnoreCase(receiveby)) {
				BankBookDAO bd = new BankBookDAO();
				BankBookBean bb = new BankBookBean();
				bb.setAccount(income);
				bb.setTransaction_date(date);
				bb.setAmount(amount);
				bb.setUserid(userid);
				bb.setOperation("Receive");
				bd.addBankbook(bb);
				
					 
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
