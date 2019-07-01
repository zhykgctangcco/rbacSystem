package cn.kgc.tangcco.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ToMainServlet
 */
@WebServlet(name="ToMainServlet",urlPatterns="/toMain.action")
public class ToMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		if("top".equals(param)) {
			request.getRequestDispatcher("/WEB-INF/jsp/main/top.jsp").forward(request, response);
		}else if("left".equals(param)) {
			request.getRequestDispatcher("/WEB-INF/jsp/main/left.jsp").forward(request, response);
		}else if("right".equals(param)) {
			request.getRequestDispatcher("/WEB-INF/jsp/main/right.jsp").forward(request, response);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
