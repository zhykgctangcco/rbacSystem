package cn.kgc.tangcco.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.service.PrivilegeService;
import cn.kgc.tangcco.service.UserService;
import cn.kgc.tangcco.util.PropertiesFactory;

/**
 * Servlet implementation class doUserLoginServlet
 */
@WebServlet(name = "DoUserLoginServlet", urlPatterns = "/doUserLogin.action")
public class DoUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoUserLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param=request.getParameter("param");
		if(param.equals("login")){
			login(request,response);
		}else if(param.equals("exit")) {
			exit(request,response);
		}
	}
	public void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("privileges");
		request.getSession().removeAttribute("loginUser");
		request.setAttribute("message", "退出系统");
	    request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public  void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = (UserService) PropertiesFactory.getInstance("userService");
		User user = userService
				.loginByEmailAndPwd(new User(request.getParameter("username"), request.getParameter("password")));
		if(user !=null) {
			// 登录成功，放到session去
			PrivilegeService privilegeService=(PrivilegeService) PropertiesFactory.getInstance("privilegeService");
			request.getSession().setAttribute("privileges",privilegeService.queryPrivilegeByUser(user.getId()));
			request.getSession().setAttribute("loginUser", user);
			// 跳转到成功页面
			//response.sendRedirect(request.getContextPath() + "/"); 
			request.getRequestDispatcher("/WEB-INF/jsp/main/main.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "邮箱或密码不正确！");
		    request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
