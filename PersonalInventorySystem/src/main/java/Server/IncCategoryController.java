 package Server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Bean.ExpensesCategoryBean;
import com.project.Bean.IncomeCategoryBean;
import com.project.DAO.ExpensesCategoryDAO;
import com.project.DAO.IncomeCategoryDAO;

/**
 * Servlet implementation class IncCategoryController
 */
@WebServlet("/IncCategoryController")
public class IncCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		int inccatid=Integer.parseInt(request.getParameter("inccatid"));
		
		String inccatname=request.getParameter("inccatname");
		
		String inccatdetails=request.getParameter("inccatdetails");
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		
		
		IncomeCategoryDAO icd = new IncomeCategoryDAO();
		IncomeCategoryBean icb = new IncomeCategoryBean();
		
		
		icb.setInc_catid(inccatid);
		icb.setInc_catname(inccatname);
		icb.setInc_catdetails(inccatdetails);
	    icb.setUserid(userid);
		
	 int r=	icd.updateIncomeCategory(icb);
		if(r>0) {
			response.sendRedirect("IncomeCategory");
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
