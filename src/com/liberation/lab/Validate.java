package com.liberation.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(String email, String pass) {
		boolean st = false;
		try {

			// loading drivers for mysql

			// creating connection with the database
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from account where username=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
