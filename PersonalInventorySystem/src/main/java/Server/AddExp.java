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
import com.project.DAO.BankBookDAO;
import com.project.DAO.CashBookDAO;
import com.project.DAO.ExpensesDAO;

/**
 * Servlet implementation class AddExp
 */
@WebServlet("/AddExp")
public class AddExp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExp() {
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
		int exp_catid=(Integer)session.getAttribute("exp_catid");
		
		String expenses= request.getParameter("expenses");
		String category = request.getParameter("category");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String payby=request.getParameter("payby");
		String date =request.getParameter("date");
		String remark=request.getParameter("remark");
		String paym="pay";

		
		
		ExpensesDAO ed = new ExpensesDAO();
		
		ExpensesBean eb=new ExpensesBean();
		 eb.setExp_ac(expenses);
		 eb.setExp_category(category);
		 eb.setUserid(userid);
		 eb.setExp_catid(exp_catid);
		 eb.setAmount(amount);
		 eb.setTransaction_date(date);
		 eb.setPayby(payby);
		 eb.setRemark(remark);
		 
		 int r=ed.addExpenses(eb);
		 
		 if(r>0) {
			 session.setAttribute("r", r);
			response.sendRedirect("AddExpenses");
			 
		 }
	
		 String type="cash";

			if(type.equalsIgnoreCase(payby)) {
			CashBookDAO cd = new CashBookDAO();
			CashBookBean cb = new CashBookBean();
			cb.setAccount(expenses);
			cb.setTransaction_date(date);
			cb.setAmount(amount);
			cb.setUserid(userid);
			cb.setOperation("pay");
			cd.addCashbook(cb);
			
				 
			 }
			
			
			
			String typee="Bank";

			if(typee.equalsIgnoreCase(payby)) {
			BankBookDAO bd = new BankBookDAO();
			BankBookBean bb = new BankBookBean();
			bb.setAccount(expenses);
			bb.setTransaction_date(date);
			bb.setAmount(amount);
			bb.setUserid(userid);
			bb.setOperation("pay");
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
