package mysql;
import java.sql.*;

public class ConnectMysql {

	public static ResultSet executeQuery(String query){

		//Allocate connection as null;
		Connection con = null;

		//Use try-catch with DriverManager
		try {
			//Asign url, user,pass values
			String url = "jdbc:mysql://localhost:3306/newdb";
			String user = "root";
			String pass = "root";
			//Asign jdbc class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Use getConnetion method to connect to mysql
			con = DriverManager.getConnection(url,user,pass);
			
			Statement st;
			st = con.createStatement();
			ResultSet rs;
			rs = st.executeQuery(query);
			return rs;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}