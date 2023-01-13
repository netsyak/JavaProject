package javapro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconn {

	String sql = "Select * from dental_Info";
	PreparedStatement pstmt = con.preparaStatment(sql) ;
	ResultSet rs= pstmt.executeQuery();
	private String dentalTreatment;
	
	if(rs.next()) {
		dentalTreatment = rs.getString("Dental_Treatment");
		dnetal_cost_low = rs.getString("Dental_cost_low");
		dnetal_cost_High = rs.getString("Dental_cost_High");
		dnetal_cost_Avg = rs.getString("Dental_cost_Avg");
		
	}
	
}
