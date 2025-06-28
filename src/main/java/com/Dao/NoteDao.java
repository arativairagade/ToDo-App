package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.ConnectionFactory.ConnectionFactory;
import com.Model.Note;

public class NoteDao {
	public void insertNote(String notetext,  String uname) {
		try {
			LocalDateTime dt=LocalDateTime.now();
			DateTimeFormatter dft=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
					
			String adddate= dft.format(dt).toString();
								
			String sql ="insert into "+uname+"notes(notetext, adddate, moddate) values(?,?,?)";
			Connection con = ConnectionFactory.getCon();
					
			PreparedStatement ps= con.prepareStatement(sql);
					
			ps.setString(1, notetext);
			ps.setString(2, adddate);
			ps.setString(3, "NA");
					
			ps.executeUpdate();
						
		}catch (Exception e) {
			System.out.println(e);
		}				
	}
	
	public void updateNote(String noteid, String notetext, String uname) {
	    try {
	        LocalDateTime dt = LocalDateTime.now();
	        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	        String moddate = dft.format(dt).toString();

	        String sql = "UPDATE " + uname + "notes SET notetext = ?, moddate = ? WHERE noteid = ?";
	        Connection con = ConnectionFactory.getCon();

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, notetext);
	        ps.setString(2, moddate);
	        ps.setInt(3, Integer.parseInt(noteid));

	        ps.executeUpdate();

	    } catch (Exception e) {
	        System.out.println("Error in updateNote: " + e);
	    }
	}
			
	public ArrayList<Note> readAllNotes(String uname){
		ArrayList<Note> al = new ArrayList<Note>();
		try {
			String sql = "select * from "+uname+"notes";
			 Connection con =ConnectionFactory.getCon();
			 Statement st =con.createStatement();
			 ResultSet rs =st.executeQuery(sql);
			 
			 while(rs.next()) {
				 Note n= new Note();
				 n.setNoteid(rs.getInt("noteid"));
				 n.setNotetext(rs.getString("notetext"));
				 n.setAdddate(rs.getString("adddate"));
				 n.setModdate(rs.getString("moddate"));
				 
				 al.add(n);
			 }	
		}
		catch (Exception e) {
			System.out.println(e);
		}finally {
			return al;
		}
	}	
	public void deleteNote(String uname, String noteid) {
		try {
			String sql ="delete from "+uname+"notes where noteid=?";
			
			Connection con= ConnectionFactory.getCon();
			
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setInt(1,Integer.valueOf(noteid));
			ps.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println(e);
		}		
	}
	
	public Note readNote(String uname, String noteid){
		Note n = new Note();
		
		try {
			String sql = "select * from "+uname+"notes where noteid=?";
			 Connection con =ConnectionFactory.getCon();
			 PreparedStatement ps =con.prepareStatement(sql);
			 
			 ps.setInt(1, Integer.valueOf(noteid));
			 ResultSet rs =ps.executeQuery();
			 
			 while(rs.next()) {
				 n.setNoteid(rs.getInt("noteid"));
				 n.setNotetext(rs.getString("notetext"));
				 n.setModdate(rs.getString("moddate"));
				 			 
			 }	
		}
		catch (Exception e) {
			System.out.println(e);
		}finally {
			return n;
		}
	}	
}
