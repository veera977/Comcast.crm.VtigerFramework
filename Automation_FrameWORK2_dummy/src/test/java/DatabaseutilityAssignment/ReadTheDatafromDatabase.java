package DatabaseutilityAssignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import Com.comcast.crm.genaric.databaseutility.DatabaseUtility;

public class ReadTheDatafromDatabase {
	public static void main(String[] args) throws SQLException {
		DatabaseUtility du = new DatabaseUtility();
		du.getConnection();
		ResultSet res = du.executeQuery("select * from student;");
		
			while (res.next()) {
				String result = res.getString(1)+"    "+res.getString(2);
				System.out.println(result);
			}
		//		for(;;) {
//			if (res.next()) {
//				System.out.println(res.getString(1));
//			}
//			else {
//				break;
//			}
//		}

		du.closeConnectin();

	}
}
