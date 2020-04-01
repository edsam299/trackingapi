package webfilter.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuController
 */
@WebServlet(urlPatterns = {"/menu/print", "/menu/sum", "/menu/home", "/menu/LoginServlet"})
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("uri "+request.getRequestURI());
		RequestDispatcher dispatcher=null;
		if(request.getRequestURI().equals("/webfilter/menu/print")) {
			dispatcher = request.getRequestDispatcher("/print.jsp");
			dispatcher.forward(request, response);
		}else if(request.getRequestURI().equals("/webfilter/menu/sume")) {
			dispatcher = request.getRequestDispatcher("/sum.jsp");
			dispatcher.forward(request, response);
			
		}else if(request.getRequestURI().equals("/webfilter/menu/home")) {
			dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			
		}else if(request.getRequestURI().equals("/webfilter/menu/LoginServlet")) {
			dispatcher = request.getRequestDispatcher("/print.jsp");
			dispatcher.forward(request, response);
			
		}else {
			System.out.println(55);
			dispatcher = request.getRequestDispatcher("/sum.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
