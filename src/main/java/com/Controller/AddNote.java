package com.Controller;

import java.io.IOException;

import com.Dao.NoteDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addnote")
public class AddNote extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String notetext=req.getParameter("notetext");
		String uname=req.getParameter("uname");
		
		NoteDao nd=new NoteDao();
		nd.insertNote(notetext, uname);
		resp.sendRedirect("home.jsp");
			
	}
}
