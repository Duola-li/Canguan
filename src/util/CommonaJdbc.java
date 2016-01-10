package util;
import java.sql.*;
public class CommonaJdbc {
	public Connection connection = null;
	public CommonaJdbc(){
		getCon();
	}
	
	private Connection getCon(){
		try{
				String driver = "com.mysql.jdbc.Driver";

	           // URL指向要访问的数据库名scutcs
	           String url = "jdbc:mysql://127.0.0.1:3306/canguan";
	           
	           // MySQL配置时的用户名
	           String user = "root"; 

	           // MySQL配置时的密码
	           String password = "toor";

	          // 加载驱动程序
	            Class.forName(driver);
			  connection = DriverManager.getConnection(url, user, password);
			  
		}catch(ClassNotFoundException e1) {
            System.out.println("Sorry,can`t find the Driver!"); 
            e1.printStackTrace();
        }catch(SQLException e2) {
            e2.printStackTrace();
        }
		return connection;
	}
}
