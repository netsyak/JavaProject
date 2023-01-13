package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DentalMemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.151:1521:xe";
	String user = "c##green";
	String password = "green1234";

	public int memInsert(String pid, String ppwd, String pname, String pbirth, String ptel, String paddress) {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String id = pid, pwd = ppwd, name = pname, birth = pbirth, tel = ptel, address = paddress;
			String sql = "INSERT INTO dentalmember VALUES ('" + id + "','" + pwd + "','" + name + "','" + birth + "','"
					+ tel + "','" + address + "')";
//			String sql = "INSERT INTO dentalmember VALUES (?,?,?,?,?,?)";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}
			String sql2 = "SELECT id, pwd, name, birth, tel,address FROM dentalmember";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("pwd") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("birth") + "\t");
				System.out.print(rs.getString("tel") + " \t");
				System.out.println(rs.getString("address") + " ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 1;
	}
	
		public int memUpdate(String pid, String ppwd, String pname, String pbirth,String ptel, String paddress) {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

//			String id = pid, pwd = pwd;
			String sql = "UPDATE dentalmember set pwd = '" + ppwd + "' where id= '" + pid + "'";
//			String sql = "INSERT INTO dentalmember VALUES ('?','?','?','?','?','?')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("update success.\n");
			} else {
				System.out.println("update fail.\n");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 1;
	}

	public ArrayList<DentalMemberVo> list(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	public void memUpdate(String text, String text2, String text3, String text4, String text5) {
		// TODO Auto-generated method stub
		
	}
}
