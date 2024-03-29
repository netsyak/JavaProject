package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.25.38:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<MemberVo> list(String id) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM DENTALMEMBER";
			if (id != null) {
//				query += " where id='" + id.toUpperCase() + "'";
				query += " where id='" + id + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected....");
				rs.previous();
				
				while (rs.next()) {
					String strid = rs.getString("ID"); // 레이어드 수정
					String strpwd = rs.getString("PWD"); // 레이어드 수정
					String strname = rs.getString("Name");
					String strbirth = rs.getString("Birth");
					String strtel = rs.getString("Tel");
					String straddress = rs.getString("Address");
					
					MemberVo data = new MemberVo(strid, strpwd, strname, strbirth, strtel, straddress);
					list.add(data);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("connDB_jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			// stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
