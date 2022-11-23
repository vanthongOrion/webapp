package mysql;
import java.sql.*;

public class ConnectMysql {
	public static Connection con = null;
	public static Statement st;
	public static PreparedStatement preSt;
	public static ResultSet rs;

	static {
			//Allocate connection as null;
		// Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/newdb";
			String user = "root";
			String pass = "root";
			//Asign jdbc class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Use getConnetion method to connect to mysql
			con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultSet selectFrom(String query){

		//Use try-catch with DriverManager
		try {

			st = con.createStatement();
			rs = st.executeQuery(query);
			return rs;

		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static int insertInfo(String regNo,String firstName,String lastName,
		String phone, String education, String email){
		try{
			preSt = con.prepareStatement("insert into studentInfo(regno,firstname,lastname,phone,education,email) values(?,?,?,?,?,?)");
			preSt.setString(1,regNo);
			preSt.setString(2,firstName);
			preSt.setString(3,lastName);
			preSt.setString(4,phone);
			preSt.setString(5,education);
			preSt.setString(6,email);
			int count;
			count = preSt.executeUpdate();
			return count;
			// con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}