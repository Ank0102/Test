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
 * Servlet implementation class AddIncCategory
 */
@WebServlet("/AddIncCategory")
public class AddIncCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIncCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
		
		String Catnm =request.getParameter("catname");
		String Incat=request.getParameter("incat");
		int userid=(Integer)session.getAttribute("eid");

		IncomeCategoryDAO icd = new IncomeCategoryDAO();
		IncomeCategoryBean icb = new IncomeCategoryBean();
		
		
		icb.setInc_catname(Catnm);
		icb.setInc_catdetails(Incat);
		icb.setUserid(userid);
		int nm=Catnm.length();
		int dt=Incat.length();
		
		

		if(nm>=1&&dt>=1) 
		{
		int r=icd.addIncomeCategory(icb);
		if(r>0) {
		
			response.sendRedirect("IncomeCategory");
		}
		}
		else {
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

