package com.Controller;

import java.io.IOException;

import com.Dao.NoteDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletenote")
public class DeleteNote extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("uname");
		String noteid=req.getParameter("noteid");
		
		NoteDao nDao = new NoteDao();
		nDao.deleteNote(name, noteid);
		
		resp.sendRedirect("home.jsp");
	}
}
