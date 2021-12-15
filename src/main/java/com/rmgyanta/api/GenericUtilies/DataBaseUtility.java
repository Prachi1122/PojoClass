package com.rmgyanta.api.GenericUtilies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;






/**
 * This class contains generic methods to read the data from DataBase
 * @author Prachi
 *
 */
public class DataBaseUtility {
	static Connection con;
	static ResultSet result;
	static Driver driver;
	/**
	 * connection with database Established
	 * @throws SQLException
	 */
	public void ConnectionToDB() throws SQLException
	{
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(IPathConstant.DB_PATH,IPathConstant.USER_NAME,IPathConstant.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * DB connection is closed
	 * @throws SQLException
	 */
	public void  closeDB() throws SQLException
	{
		con.close();
	}

	/**
	 * This method returns the data wrt to column index
	 * @param query
	 * @param columnindex
	 * @return
	 * @throws SQLException
	 */
	public String getDataFromDB(String query,int columnindex) throws SQLException
	{
		String value = null;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			value = result.getString(columnindex);
		}
		return value;
	}

	/**
	 * get data from DB and verify
	 * @param query
	 * @param colomnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */

	public String getDataFromDBAndVerify(String query,int colomnName, String expData) throws SQLException
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			try {
				if(result.getString(colomnName).equals(expData))
				{
					flag=true;
					break;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}

		if(flag)
		{
			System.out.println(expData + "data verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verified");
			return expData;
		}


	}
}



