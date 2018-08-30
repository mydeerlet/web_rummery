package rummery.deerlet.wk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rummery.deerlet.wk.entity.Admin;
import rummery.deerlet.wk.exception.UserExistsException;
import rummery.deerlet.wk.service.IAdminService;
import rummery.deerlet.wk.service.impl.AdminService;


public class AdminServlet extends HttpServlet {


	//调用service
	private IAdminService adminService=new AdminService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//获取操作类型
		String method=request.getParameter("method");
		
		if("register".equals(method)){
			register(request,response);
		}
	}


	/**
	 * 注册处理方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		//1.获取请求参数
		String  userName = request.getParameter("userName");
		String  pwd = request.getParameter("pwd");
		
		//封装
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		
		//2.调用Service处理注册的业务逻辑
		try {
		
			adminService.register(admin);
	
			// 注册成功，跳转到首页
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		} catch (UserExistsException e) {
			//用户名存在，用户注册失败，跳转到注册页面
			request.setAttribute("message", "用户名存在");
			
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}catch (Exception e) {
			//其他错误 ,跳转到错误页面
			response.sendRedirect(request.getContextPath()+"/error/error.jsp");
		}
	}

}
