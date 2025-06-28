package com.Controller;

import java.io.IOException;

import com.Dao.UsersInfoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userlogin")
public class Login extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("uname");
		String pass= req.getParameter("upass");
		
		UsersInfoDao uDao = new UsersInfoDao();
		String res=uDao.checkUser(name, pass);
		HttpSession s=req.getSession();
		
		if(res.equals("exists")) {
			s.setAttribute("check", name);
			resp.sendRedirect("home.jsp");
		}else {
			s.setAttribute("msg", "Invalid Credential");
			resp.sendRedirect("login.jsp");
		}
	}

}
