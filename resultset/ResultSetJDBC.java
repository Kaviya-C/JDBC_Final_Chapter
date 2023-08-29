package com.learn.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetJDBC {
	public static void main(String... args) throws ClassNotFoundException, SQLException {

		/*
		 * java.sql.ResultSetMetaData -- frequently used interface in JDBC API
		 * ResultSetMetaData ---> interface this interface give quick overview about
		 * no.of.columns column name column type name schema name table name
		 * 
		 * 
		 * to get the meta data information of the result set getMetaData();
		 * 
		 * 
		 * 
		 */

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/Owner";

		String name = "root";
		String password = "root123";

		Connection con = DriverManager.getConnection(url, name, password);

		Statement stmt = con.createStatement();

		String query = "SELECT * FROM Details";

		ResultSet res = stmt.executeQuery(query);

		ResultSetMetaData rmd = res.getMetaData();

		int columnCount = rmd.getColumnCount();

		for (int index = 1; index <= columnCount; index++) {
			
			String colName = rmd.getColumnName(index);

			String type = rmd.getColumnTypeName(index);

			String database = rmd.getSchemaName(0);

			String table = rmd.getTableName(index);

			System.out.println(database);
			System.out.println(database + " " + table + " " + colName + "  " + type);
		}

	}

}
