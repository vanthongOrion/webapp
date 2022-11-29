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
			System.out.println("Successfully connect to mysql");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultSet selectFrom(String query){

		//Use try-catch with DriverManager
		try {

			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query);
			System.out.println("Successfully executeQuery : " + query);
			// DBPrinter.printResultSet(rs);
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
			System.out.println("Successfully execute Query: " + preSt.toString());
			return count;
			// con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//for Exercise4
	public static int insertInto(String empno,String name, String designation, String phone){
		try {
			int count;
			preSt = con.prepareStatement("INSERT INTO employee(empno,name,designation,phone) values(?,?,?,?)");
			preSt.setString(1,empno);
			preSt.setString(2,name);
			preSt.setString(3,designation);
			preSt.setString(4,phone);
			count = preSt.executeUpdate();
			System.out.println("Successfully execute Update : " + preSt.toString());
			System.out.println(count + " affect");
			return count;
		} catch(Exception e ){
			e.printStackTrace();
			return -1;
		}
	}
}