package cn.kgc.tangcco.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.service.RoleService;
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
		}else if(param.equals("toUpdateRole")) {
			toUpdateRole(request,response);
		}else if(param.equals("doUpdateRole")) {
			doUpdateRole(request,response);
		}
	}
	public void doUpdateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String[] roleIds=request.getParameter("str").split(",");
		RoleService roleService=(RoleService) PropertiesFactory.getInstance("roleService");
		int result=roleService.updateUserRole(userId, roleIds);
		response.sendRedirect("toUserList.action?param=userList&message='成功'");
	}
	public void toUpdateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("id");
		RoleService roleService=(RoleService) PropertiesFactory.getInstance("roleService");
		request.setAttribute("roles", roleService.queryRoleList());
		request.setAttribute("userRoles", roleService.queryRoleByUserId(userId));
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/WEB-INF/jsp/user/updateUserRole.jsp").forward(request, response);
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
