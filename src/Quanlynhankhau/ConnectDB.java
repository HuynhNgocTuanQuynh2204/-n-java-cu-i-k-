package Quanlynhankhau;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    
	public Connection conn;
	private Statement stmt;
	private ResultSet rs;
	public void Connect() {

		String userName = "root";
		String password = "220404";
		String url = "jdbc:mysql://localhost/quanlynhankhau";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
//			System.out.println("ok");
		} catch (Exception e) {
			// ClassNotFoundException
			e.printStackTrace();
		}
//		System.out.println(conn);
	}
	public ResultSet executeQuery(String sql) {
		try {
			Connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
    public static void main(String[] args) {
    	ConnectDB a = new ConnectDB();
    	a.Connect();
    	System.out.println("hello");
    }
    
    
   
}