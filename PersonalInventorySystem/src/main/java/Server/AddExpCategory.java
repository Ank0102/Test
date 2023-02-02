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
import com.project.DAO.ExpensesCategoryDAO;

/**
 * Servlet implementation class AddExpCategory
 */
@WebServlet("/AddExpCategory")
public class AddExpCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExpCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
		
		String Catnm=request.getParameter("catname");
		String Excat=request.getParameter("excat");
		int userid=(Integer)session.getAttribute("eid");

		
		ExpensesCategoryDAO ecd=new ExpensesCategoryDAO();
		ExpensesCategoryBean ecb=new ExpensesCategoryBean();
		
		ecb.setExp_catname(Catnm);
		ecb.setExp_catdetails(Excat);
		ecb.setUserid(userid);
		int nm=Catnm.length();
		int dt=Excat.length();
		
		if(nm>=1&&dt>=1) 
		{
		int r=ecd.addExpensesCategory(ecb);
		if(r>0) {
		
			response.sendRedirect("ExpensesCategory");
		}
		}
		else {
		response.sendRedirect("ExpensesCategory");
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
