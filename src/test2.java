import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import com.mysql.jdbc.Statement;
import util.*;

/*
 * sql的测试结果
 */
public class test2 {
	 public static void main(String[] args) {
		 
		 /*
		  * 测试数据库查询函数
		  */
//		 String sqlStr = "Select * from login";
//		 RetrieveObject duola = new RetrieveObject();
//		 Vector vector = duola.getObjectRow("Select * from login");
//		 for(int i=0;i<vector.size();i++){
//			  HashMap map = (HashMap)vector.get(i);
//			  System.out.println(map.get(i));
//		}
//		 
		 
		 /*
		  * 下面是连接数据库的测试
		  */
		 	String sql = "select Twaiter from tables where Tnum = " + 0;
			RetrieveObject SGO = new RetrieveObject();
			int Waiter = (int) SGO.getObjectRow(sql).get(0);
			System.out.println(Waiter);
//	        CommonaJdbc conn = new CommonaJdbc();
//	        try {
//				Statement stmt = (Statement) conn.connection.createStatement();
//				
//				String sql = "Select * from login ";//where userid = "+"1111";
//				ResultSet res = stmt.executeQuery(sql);
//				System.out.println(res.getRow());
//				while(res.next()){
//					System.out.print("the id: ");
//					System.out.println(res.getInt(1));
//					System.out.print("the password: ");
//					System.out.println(res.getString("password"));
//					System.out.println();
//				}
//				res.close();
//				stmt.close();
//				conn.connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        
//	    }
	 }
}
