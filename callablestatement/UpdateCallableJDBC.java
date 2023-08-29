package com.learn.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class UpdateCallableJDBC {
	public static void main(String... args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/Owner";

		String username = "root";

		String password = "root123";

		Connection con = DriverManager.getConnection(url, username, password);

		String callProcedure = "{CALL updateRevenue(?,?,?)}";

		CallableStatement calling = con.prepareCall(callProcedure);

		// Set input parameters

		calling.setString(1, "Kavi");
		calling.setInt(2, 50000);
		calling.registerOutParameter(3, Types.DECIMAL);

		calling.execute();

		int updated = calling.getInt(3);

		System.out.println("Updated Revenue is : " + updated);

		/*
		 * DELIMITER //
		 *  CREATE PROCEDURE updateRevenue 
		 * (IN updateName VARCHAR(25),
		 *  IN RevenueIncreased DECIMAL(10,2),
		 *  OUT revenueUpdate DECIMAL(10,2) )
		 *  BEGIN
		 * UPDATE Details set revenue= revenue+RevenueIncreased 
		 * WHERE name=updateName;
		 * 
		 * SELECT revenue INTO revenueUpdate FROM Details 
		 * WHERE name= updateName; END //
		 * 
		 * DELIMITER ;
		 * 
		 * CALL updateRevenue("Geetha",4000,@result);
		 *  SELECT @result;
		 
		 */
	}

}
