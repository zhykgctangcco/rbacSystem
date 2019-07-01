package cn.kgc.tangcco.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.service.UserService;
import cn.kgc.tangcco.util.PropertiesFactory;

/**
 * Servlet implementation class ToUserListServlet
 */
@WebServlet(name="ToUserListServlet",urlPatterns = "/toUserList.action")
public class ToUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToUserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param=request.getParameter("param");
		if(param.equals("userList")) {
			queryAllUser(request,response);
		}
	}
	
	public void queryAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = (UserService) PropertiesFactory.getInstance("userService");
		request.setAttribute("userList", userService.queryAllUser());
		request.getRequestDispatcher("/WEB-INF/jsp/user/userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
