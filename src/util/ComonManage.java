package util;


//1.取出最大值2.define
import java.sql.*;

import model.Obj_Cai;
import model.Obj_Chief;
import model.Obj_Table;
import model.Obj_Waiter;
import model.Obj_consume;

public class ComonManage {
	
	public static final int Delete = 1;
	public static final int Update = 2;
	public static final int Insert = 3;
	
	//private Connection con = null;
    //private Statement stmt = null;
    //private PreparedStatement pstmt = null;
    
/*    //验证数据表中是否存在数据
    public static boolean validate(String tname, int tnum){ //tname为表的名字，如menu
        String sqlStr = null;
        if(tname == "menu")
        	sqlStr = "select count(*) from " + tname + " where Cnum = " + tnum ;
        else if(tname == "chief")
        	sqlStr = "select count(*) from " + tname + " where Knum = " + tnum ;
        else if(tname == "book")
        	sqlStr = "select count(*) from " + tname + " where Tnum = " + tnum ;
        else 
        	return false;
        try{//连接数据库
        	//String url = "jdbc:mysql://localhost:3306/canguan?"
              //      + "user=root&password=liukai&useUnicode=true&characterEncoding=UTF8";
        	con = CommonJdbc.conection;       //需要有连接数据库的公共类CommonJdbc
            
            pstmt = con.prepareStatement(sqlStr);
            java.sql.ResultSet rs = null;
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0)   return true;   //表不为空
            }
        }catch (Exception e) {
        	//System.out.println(e.getMessage()); //在控制台输出异常信息,应该需要在窗口里显示
        	return false;
        }

        return false;
    }
*/
    //对菜单表的操作（删除，更新，插入）
	public static boolean Cai_manage(Obj_Cai objcai,int type) throws SQLException{  //管理成功则返回true
		//Menu_manage()函数需要两个参数，参数objcai为表menu,参数type表示1：删除，2：更新，3：插入
		//String tname = "menu";
		int tnum = objcai.getCnum(); //获取菜号
		String sqlStatement = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
		switch(type){
			case Delete: //删除表中信息
				sqlStatement = "Delete from menu where Cnum = " + tnum ;
				System.out.println(sqlStatement);
				try {
					stmt.executeUpdate(sqlStatement);
				}catch (Exception e){
					e.printStackTrace();
					}
				break;
			case Update: //更新
				sqlStatement = "Update menu set Cname = '" + objcai.getCname()
					+ "',Clevel = " + objcai.getClevel()
					+ ",CPrice = " +  objcai.getCprice()
					+" where Cnum = " + tnum;
				try {
					stmt.executeUpdate(sqlStatement);
				}catch (Exception e){
					e.printStackTrace();
				}
				break;
			case Insert:  //插入
				sqlStatement = "Insert into menu (Cnum,Cname,Clevel,Cprice) values (" + tnum
						+ ",'" + objcai.getCname()
						+ "'," + objcai.getClevel()
						+ "," + objcai.getCprice()
						+ ")";
				try {
					stmt.executeUpdate(sqlStatement);
					}catch (Exception e){
					e.printStackTrace();  //插入异常
					}
				break;
			default:
				break;
			}
		con.close();
		return true;
	}
//	//对厨师表的操作（删除，更新，插入）
	public static boolean Chief_manage(Obj_Chief objchief,int type) throws SQLException{ //管理成功则返回true
		//Chief_manage()函数需要两个参数，参数objchief为表chief,参数type表示1：删除，2：更新，3：插入
		//String tname = "chief";  //表名
		int tnum = objchief.getKnum(); //获取厨师号
		String sqlStatement = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
		switch(type){
			case Delete: //删除厨师表中信息
				sqlStatement = "Delete from chief where Knum = " + tnum ;
				try {
				       stmt.executeUpdate(sqlStatement);
				    }catch (Exception e){
				        e.printStackTrace();
				      	}
				break;
			case Update: //更新
					sqlStatement = "Update chief set Kname = '" + objchief.getKname()
						+ "',Klevel = " + objchief.getKlevel()
						+ ",Kprice = " + objchief.getKprice()
						+" where Knum = " + tnum;
					try {
				        stmt.executeUpdate(sqlStatement);
				    }catch (Exception e){
				        e.printStackTrace();
				        }
					break;
			case Insert:  //插入
					sqlStatement = "Insert into chief (Knum,Kname,Klevel,Kprice) values (" + tnum
						+ ",'" + objchief.getKname()
						+ "'," + objchief.getKlevel()
						+ "," + objchief.getKprice()
						+ ")";
					try {
						stmt.executeUpdate(sqlStatement);
					}catch (Exception e){
						e.printStackTrace();  //插入异常
			        	}
					break;	
			default:
					break;
			}
		con.close();		
		return true;	
	}
//	public static boolean Book_manage(Obj_book objbook,int type) throws SQLException{ //管理成功则返回true
//		//Book_manage()函数需要两个参数，参数objbook为表book,参数type表示1：删除，2：更新，3：插入
//		//String tname = "book";  //表名
//		int tnum = objbook.getTnum(); //获取桌号
//		String sqlStatement = null;
//		Connection con = null;
//		String url = "jdbc:mysql://localhost:3306/canguan?"
//                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
//		con = DriverManager.getConnection(url);
//        Statement stmt = con.createStatement();
//		switch(type){
//			case Delete: //删除预订表中信息，即取消预订
//					sqlStatement = "Delete from book" + " where Tnum = " + tnum ;
//					try {
//				        stmt.executeUpdate(sqlStatement);
//				    }catch (Exception e){
//				        e.printStackTrace();
//				      	}
//					break;
//			case Update: //更新联系的手机、姓名
//					sqlStatement = "Update book set name = '" + objbook.getname()
//						+ "',phone = '" + objbook.getphone()
//						+"'where Tnum = " + tnum;
//					try {
//				        stmt.executeUpdate(sqlStatement);
//				    }catch (Exception e){
//				        e.printStackTrace();
//				        }
//					break;
//			case Insert:  //插入
//				sqlStatement = "Insert into book (Tnum,name,phone,finish) values (" + tnum
//					+ ",'" + objbook.getname()
//					+ "','" + objbook.getphone() + "'," + objbook.getfinish()
//					+ ")";
//					try {
//						stmt.executeUpdate(sqlStatement);
//					}catch (Exception e){
//						e.printStackTrace();  //插入异常
//			         }
//					break;	
//				 
//			case 4: //已完成就餐，设置finish
//				sqlStatement = "Update book set finish = true where Tnum = " + tnum;
//					try {
//					    stmt.executeUpdate(sqlStatement);
//					}catch (Exception e){
//					     e.printStackTrace();
//					 }
//				break;
//		}
//		con.close();
//		return true;
//	}
	public static boolean Consume_manage(Obj_consume objconsume,int type) throws SQLException{ //管理成功则返回true
	//Consume_manage()函数需要两个参数，参数objconsume为表consume,参数type表示1：删除，2：更新，3：插入
		//String tname = "consume";  //表名
		int tnum = objconsume.getTnum(); //获取桌号
		String sqlStatement = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
		switch(type){
			case Delete: //删除
				sqlStatement = "Delete from consume" + " where Tnum = " + tnum ;
				try {
					stmt.executeUpdate(sqlStatement);
				}catch (Exception e){
					e.printStackTrace();
		      		}
				break;
			case Insert:  //插入
				sqlStatement = "Insert into consume (Tnum,Cnum,Knum,Wnum,send,made,finished) values (" + tnum
					+ "," + objconsume.getCnum()
					+ "," + objconsume.getKnum()
					+ "," + objconsume.getWnum()
					+ "," + objconsume.getsend()
					+ "," + objconsume.getmade()
					+ ",0"
					+ ")";
				try {
					stmt.executeUpdate(sqlStatement);
				}catch (Exception e){
					e.printStackTrace();  //插入异常
				       }
				break;
			case Update: //已完成就餐，设置finish
				sqlStatement = "Update book set finish = true where Tnum = " + tnum;
					try {
						stmt.executeUpdate(sqlStatement);
						}catch (Exception e){
						   e.printStackTrace();
						}
				break;										
			}
		System.out.println("执行的sql："+sqlStatement);
		con.close();
		return true;	
	}
	public static boolean Waiter_manage(Obj_Waiter objwaiter,int type) throws SQLException{ //管理成功则返回true
		//String tname = "waiter";  //表名
		int tnum = objwaiter.getWnum(); //获取服务员号
		String sqlStatement = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
		switch(type){
			case Delete: //删除
				sqlStatement = "Delete from waiter" + " where Wnum = " + tnum ;
				try {
				       stmt.executeUpdate(sqlStatement);
				    }catch (Exception e){
				        e.printStackTrace();
				      	}
				break;
			case Update: //更新
					sqlStatement = "Update waiter set Wname = '" + objwaiter.getWname()
						+ "',Wlevel = " + objwaiter.getWlevel()
						+ ",Wprice = " +objwaiter.getWprice()
						+" where Wnum = " + tnum;
					try {
				        stmt.executeUpdate(sqlStatement);
				    }catch (Exception e){
				        e.printStackTrace();
				        }
					break;
			case Insert:  //插入
					sqlStatement = "Insert into waiter (Wnum,Wname,Wprice,Wlevel) values (" + tnum
						+ ",'" + objwaiter.getWname()
						+ "'," + objwaiter.getWprice()
						+ "," + objwaiter.getWlevel()
						+ ")";
					try {
						stmt.executeUpdate(sqlStatement);
					}catch (Exception e){
						e.printStackTrace();  //插入异常
			        	}
					break;				
			}
		con.close();		
		return true;	
	}
//	public static boolean Pay_manage(Obj_pay objpay,int type) throws SQLException{ //管理成功则返回true
//		//String tname = "pay";  //表名
//		String sqlStatement = null;
//		Connection con = null;
//		String url = "jdbc:mysql://localhost:3306/canguan?"
//                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
//		con = DriverManager.getConnection(url);
//        Statement stmt = con.createStatement();
//		switch(type){
//			case Delete: //删除
//					sqlStatement = "Delete from pay" + " where phone = " + objpay.getphone() ;
//					try {
//				        stmt.executeUpdate(sqlStatement);
//				    }catch (Exception e){
//				        e.printStackTrace();
//				      	}
//					break;
//			case Update: //更新
//					sqlStatement = "Update pay set cost = " + objpay.cost()
//						+ ",name = '" + objpay.name()
//						+"' where phone = '" + objpay.getphone() +"'";
//					try {
//				        stmt.executeUpdate(sqlStatement);
//				    }catch (Exception e){
//				        e.printStackTrace();
//				        }
//					break;
//			case Insert:  //插入
//				sqlStatement = "Insert into pay (phone,name,cost) values ('" + objpay.getphone()
//					+ "','" + objpay.name()
//					+ "'," + objpay.cost()
//					+ ")";
//					try {
//						stmt.executeUpdate(sqlStatement);
//					}catch (Exception e){
//						e.printStackTrace();  //插入异常
//			         }
//					break;	
//		}
//		con.close();
//		return true;
//	}
	public static boolean Table_manage(Obj_Table objtable,int type) throws SQLException{ //管理成功则返回true
		//String tname = "table";  //表名
		String sqlStatement = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
		switch(type){
			case Delete: //删除
					sqlStatement = "Delete from tables" + " where Tnum = " + objtable.getTnum() ;
					try {
				        stmt.executeUpdate(sqlStatement);
				    }catch (Exception e){
				        e.printStackTrace();
				      	}
					break;
			case Update: //更新
					sqlStatement = "Update tables set Tlevel = " + objtable.getTlevel()
						+ ",Twaiter = " + objtable.getTwaiter()
						+ ",Tused = " + objtable.getTused()
						+" where Tnum = " + objtable.getTnum();
					try {
				        stmt.executeUpdate(sqlStatement);
				    }catch (Exception e){
				        e.printStackTrace();
				        }
					break;
			case Insert:  //插入
				sqlStatement = "Insert into tables (Tnum,Tlevel,Twaiter,Tused) values (" + objtable.getTnum()
					+ "," + objtable.getTlevel() +"," + objtable.getTwaiter()
					+ "," + objtable.getTused()
					+ ")";
					try {
						stmt.executeUpdate(sqlStatement);
					}catch (Exception e){
						e.printStackTrace();  //插入异常
			         }
					break;	
		}
		con.close();
		return true;
	}
//	public static boolean Cookmanager_manage(Obj_cookmanager objcookmanager,int type) throws SQLException{ //管理成功则返回true
//		String sqlStatement = null;
//		Connection con = null;
//		String url = "jdbc:mysql://localhost:3306/canguan?"
//                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
//		con = DriverManager.getConnection(url);
//        Statement stmt = con.createStatement();
//		switch(type){
//			case Delete: //删除
//				sqlStatement = "Delete from cookmanager" + " where Knum = " + objcookmanager.getKnum()
//					+ " AND Cnum = " + objcookmanager.Cnum();
//				try {
//				       stmt.executeUpdate(sqlStatement);
//				    }catch (Exception e){
//				        e.printStackTrace();
//				      	}
//				break;
//			case Update: //更新
//					sqlStatement = "Update cookmanager set finish = true" 
//						+" where Knum = " + objcookmanager.getKnum()
//						+" AND Cnum = " + objcookmanager.Cnum();
//					try {
//				        stmt.executeUpdate(sqlStatement);
//				    }catch (Exception e){
//				        e.printStackTrace();
//				        }
//					break;
//			case Insert:  //插入
//					sqlStatement = "Insert into cookmanager (Knum,Cnum,finish) values (" + objcookmanager.getKnum()
//						+ "," + objcookmanager.Cnum()
//						+ "," + objcookmanager.finish()
//						+ ")";
//					try {
//						stmt.executeUpdate(sqlStatement);
//					}catch (Exception e){
//						e.printStackTrace();  //插入异常
//			        	}
//					break;				
//			}
//		con.close();		
//		return true;	
//	}	
	
	public static boolean setTableUsed(int Num, int used){
		String sqlStr = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		try {
			con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        
        sqlStr = "update tables set Tused = "+ used + " where Tnum = " + Num;
        System.out.println(sqlStr);
        //stmt.executeQuery(sqlStr);
        stmt.executeUpdate(sqlStr);
        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean setMade(int Tnum,int Cnum,int Knum, int used){
		String sqlStr = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		try {
			con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        
        sqlStr = "update consume set made = "+ used + " where Cnum = " + Cnum+" and Knum = "+Knum+" and Tnum = "+Tnum;
        System.out.println(sqlStr);
        //stmt.executeQuery(sqlStr);
        stmt.executeUpdate(sqlStr);
        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean setSend(int Tnum, int Cnum,int Wnum, int used){
		String sqlStr = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		try {
			con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        
        sqlStr = "update consume set send = "+ used + " where Cnum = " + Cnum+" and Wnum = "+Wnum+" and Tnum = "+Tnum;
        System.out.println(sqlStr);
        //stmt.executeQuery(sqlStr);
        stmt.executeUpdate(sqlStr);
        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean OK(int Tnum){
		String sqlStr = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		try {
			con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        
        sqlStr = "update consume set finished = 1 where finished = 0 and Tnum = "+Tnum;
        System.out.println(sqlStr);
        //stmt.executeQuery(sqlStr);
        stmt.executeUpdate(sqlStr);
        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        return true;
	}
	//取出表中最大值
	public static int Max_num(String tname) throws SQLException{
		String sqlStr = null;
		int max;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/canguan?"
                + "user=root&password=toor&useUnicode=true&characterEncoding=UTF8";
		con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
		//con = CommonJdbc.conection;       //需要有连接数据库的公共类CommonJdbc
        //pstmt = con.prepareStatement(sqlStr);
        int a = tname.compareTo("menu");
        int b = tname.compareTo("chief");
        int c = tname.compareTo("tables");
        int d = tname.compareTo("waiter");
        if(a==0)
        	sqlStr = "select max(Cnum) from menu" ;
        else if(b==0)
        	sqlStr = "select max(Knum) from chief" ;
        else if(c==0)
        	sqlStr = "select max(Tnum) from tables" ;
        else if(d==0)
        	sqlStr = "select max(Wnum) from waiter" ;
        else 
        	return 1;//System.out.println("操作错误");
        ResultSet rs = stmt.executeQuery(sqlStr);
        rs.next();
        max = rs.getInt(1);
        con.close();
		return max;
		
	}
	
}
