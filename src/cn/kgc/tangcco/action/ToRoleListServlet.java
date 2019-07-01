package cn.kgc.tangcco.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.service.PrivilegeService;
import cn.kgc.tangcco.service.RoleService;
import cn.kgc.tangcco.util.PropertiesFactory;

/**
 * Servlet implementation class ToRoleListServlet
 */
@WebServlet(name="ToRoleListServlet",urlPatterns = "/toRoleList.action")
public class ToRoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToRoleListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param=request.getParameter("param");
		if(param.equals("rolelist")) {
			getRoleList(request,response);
		}else if(param.equals("toUpdatePrivilege")) {
			toUpdatePrivilege(request,response);
		}else if(param.equals("doUpdatePrivilege")) {
			doUpdatePrivilege(request,response);
		}
	}
	 
	 public void doUpdatePrivilege(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	int roleId=	Integer.parseInt(request.getParameter("roleId"));
	    	PrivilegeService privilegeService=(PrivilegeService) PropertiesFactory.getInstance("privilegeService");
	        String[] arr=request.getParameter("str").split(",");
	        int result=privilegeService.UpdateRolePrivilege(roleId, arr);
	        response.sendRedirect("toRoleList.action?param=rolelist");
	    }
    public void toUpdatePrivilege(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int roleId=	Integer.parseInt(request.getParameter("id"));
    	PrivilegeService privilegeService=(PrivilegeService) PropertiesFactory.getInstance("privilegeService");
        request.setAttribute("rolePrivileges", privilegeService.queryPrivilegeByRole(roleId));
        request.setAttribute("privilegs", privilegeService.queryAllPrivilege());
        request.setAttribute("roleId", roleId);
        request.getRequestDispatcher("/WEB-INF/jsp/role/updateRolePrivilege.jsp").forward(request, response);
    }
	public void getRoleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService=(RoleService) PropertiesFactory.getInstance("roleService");
		 request.setAttribute("roleList", roleService.queryRoleList());
		 request.getRequestDispatcher("/WEB-INF/jsp/role/roleList.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
