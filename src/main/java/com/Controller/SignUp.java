package com.Controller;

import java.io.IOException;

import com.Dao.UsersInfoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adduser")
public class SignUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("uname");
		String pass =req.getParameter("upass");
		String email= req.getParameter("uemail");
		
		UsersInfoDao uDao= new UsersInfoDao();
		String res =uDao.addUser(name, pass, email);
		HttpSession s=req.getSession();
		if(res.equals("added")) 
		{
			s.setAttribute("msg", "Account created Successfully");
			resp.sendRedirect("index.jsp");
		}else 
		{
			s.setAttribute("msg", "Account creation failed");
			resp.sendRedirect("index.jsp");
		
		}
		
		
		
	}
}
