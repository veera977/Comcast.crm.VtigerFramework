package DatabaseutilityAssignment;

import java.sql.SQLException;

import Com.comcast.crm.genaric.databaseutility.DatabaseUtility;

public class UpdataeValuesintodatabase {
public static void main(String[] args) throws SQLException {
	//create an object of database utility
	DatabaseUtility du=new DatabaseUtility();
	du.getConnection();
	int resu = du.excuteNonSelectQuery("insert into student values('S0010','girisha',9652998988);");
	System.out.println(resu);
	du.closeConnectin();
}
	
	
	
	
}
