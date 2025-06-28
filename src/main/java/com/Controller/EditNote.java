package com.Controller;

import java.io.IOException;

import com.Dao.NoteDao;
import com.Model.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editnote")
public class EditNote extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noteid = req.getParameter("noteid");
		String uname = req.getParameter("uname");
		String notetext = req.getParameter("notetext");

		NoteDao dao = new NoteDao();

		if (noteid == null || noteid.isEmpty()) {
		    dao.insertNote(notetext, uname);
		} else {
		    dao.updateNote(noteid, notetext, uname);
		}
		
		resp.sendRedirect("home.jsp");
	}
}