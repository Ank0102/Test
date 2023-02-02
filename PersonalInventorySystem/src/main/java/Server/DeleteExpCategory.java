 package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.ExpensesCategoryDAO;

/**
 * Servlet implementation class DeleteExpCategory
 */
@WebServlet("/DeleteExpCategory")
public class DeleteExpCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExpCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int expcatid = Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		ExpensesCategoryDAO ecd = new ExpensesCategoryDAO();
		int r = ecd.deleteExpensesCategory(expcatid);
		if (r>0)
		{
			response.sendRedirect("ExpensesCategory");
		}
		else
		{
			out.println("Data Deletion Fail");
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