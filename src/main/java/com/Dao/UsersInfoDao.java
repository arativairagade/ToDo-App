package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ConnectionFactory.ConnectionFactory;

public class UsersInfoDao {
	
	String result="";
	
	public String addUser(String name, String pass, String email) {
		
		try {
			String sql="insert into usersinfo values(?,?,?)";
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, email);
			
			
			int row =ps.executeUpdate();
			if(row==1) result="added";
			else result = "failed";
			
			//table creation
			String sql1 ="create table "+name+"notes(noteid int(10) not null auto_increment primary key, notetext varchar(255), adddate varchar(50), moddate varchar(50))";
			Statement st=con.createStatement();
			st.execute(sql1);
			
			
		}catch (Exception e) {
			 result = "failed";
			System.out.println(e);
		}finally {
			return result;
		}	
	}
	
	public String checkUser(String name, String pass) {
		try {
			
			String sql="select * from usersinfo where username=? and password=?";
			
			Connection con=ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) result="exists";
			else result="failed";
			
		}catch (Exception e) {
			result="failed";
			System.out.println(e);
			
		}finally {
			return result;
		}
	}	
}