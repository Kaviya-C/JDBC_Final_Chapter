package com.learn.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class INCallableJDBC {
	public static void main(String... args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/Owner";

		String username = "root";

		String password = "root123";

		Connection con = DriverManager.getConnection(url, username, password);

		String callProcedure = "{CALL getName(?)}";

		CallableStatement calling = con.prepareCall(callProcedure);

		calling.setString(1, "_a%");

		ResultSet res = calling.executeQuery();

		while (res.next()) {
			String name = res.getString("name");
			System.out.println(name);
		}

	}
}

/*
 * DELIMITER //
 *  CREATE PROCEDURE getName(IN Pattern VARCHAR(10)) 
 *  BEGIN 
 *  SELECT * FROM details where name like Pattern; 
 *  END // 
 *  DELIMITER ;
 * 
 * call getName("_a%");
 * 
 * 
 * 
 */
