 package Server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Bean.ExpensesCategoryBean;
import com.project.Bean.UsersBean;
import com.project.DAO.ExpensesCategoryDAO;
import com.project.DAO.UsersDAO;

/**
 * Servlet implementation class ExpCategoryController
 */
@WebServlet("/ExpCategoryController")
public class ExpCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int expcatid=Integer.parseInt(request.getParameter("expcatid"));
		
		String expcatname=request.getParameter("expcatname");
		
		String expcatdetails=request.getParameter("expcatdetails");
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		
		
		ExpensesCategoryDAO ecd = new ExpensesCategoryDAO();
		ExpensesCategoryBean ecb = new ExpensesCategoryBean();
		
		ecb.setExp_catid(expcatid);
		ecb.setExp_catname(expcatname);
		ecb.setExp_catdetails(expcatdetails);
	    ecb.setUserid(userid);
		
	 int r=	ecd.updateExpensesCategory(ecb);
		if(r>0) {
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
