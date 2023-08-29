package com.learn.callablestatement;

public class Introduction
{
	/*
	 * To create a stored procedure
	 * 
	 * for mysql
	 * 
	 * DELIMITER
	 * //
	 * CREATE PROCEDURE ProcedureName
	 * (IN Empages datatype)
	 * BEGIN
	 * SELECT * FROM Employee WHERE age>Empages;
	 * END
	 * //
	 * DELIMITER ;
	 * 
	 * TO call the procedure:
	 * 
	 * CALL procedureName(18);
	 * 
	 * 
	 * IF u add two number in stored procedure u use
	 * below syntax
	 * 
	 * DELIMITER 
	 * //
	 * CREATE PROCEDURE summing(IN num1 INT,num2 INT,OUT res INT)
	 * BEGIN
	 * SET res=num1+num2;
	 * END
	 * //
	  DELIMITER ;
	 
	 * CALL summing(10,56,@result);
	 * SELECT @result;
	 * 
	 */

}
