package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	/**
	 * This method is used to register database
	 * 
	 * @throws Throwable
	 */
	Connection con = null;

	public void registerDB() throws Throwable {

		Driver driver = new Driver();

		DriverManager.registerDriver(driver);

		con = DriverManager.getConnection(IConstantPath.DB_URL, IConstantPath.DB_UN, IConstantPath.DB_PASSWORD);

	}

	/**
	 * This method is used to execute query
	 * 
	 * @param query
	 * @param columIndex
	 * @param expected
	 * @return
	 * @throws SQLException 
	 * @throws Throwable
	 */
	public String executeQuery(String query, String columIndex, String expected) throws SQLException {

		ResultSet result = con.createStatement().executeQuery(query);
	
		boolean flag = false;
		try {
			while (result.next()) {
				String actual = result.getString(columIndex);
				if (actual.equals(expected)) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			System.out.println("data is verfied");
			return expected;
		} else {
			System.out.println("data is not created");
			return "";
		}
	}

	/**
	 * This method is used to close database
	 * @throws SQLException 
	 * 
	 * @throws Throwable
	 */
	public void closeDatabase() throws SQLException {
		
			con.close();
		
	}

}
