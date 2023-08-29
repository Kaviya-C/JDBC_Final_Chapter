package com.learn.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class InOutCallableStatementJDBC {
	public static void main(String... args) throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Owner","root","root123");
		
		String callprocedure= "{CALL getRevenueByName(?,?)}";
		
		CallableStatement call=con.prepareCall(callprocedure);
		
		call.setString(1, "Ram");
		
		call.registerOutParameter(2, Types.INTEGER);
		
		call.execute();
		
		int revenues=call.getInt(2);
		
		System.out.println(revenues);
		
		
		
	}

}
