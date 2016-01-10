package util;

import java.sql.SQLException;
import java.util.Vector;

import model.Obj_consume;

public class Deal {
	/*
	 * 处理订单，将菜分配给厨师，并插入到数据库
	 */
	private static Vector vector = Chief_Start();
	public static int Order(int Num, Vector vv) {
				
		/*
		 * 根据桌号找到服务员
		 */
		String sql = "select Twaiter from tables where Tnum = " + Num;
		RetrieveObject SGO = new RetrieveObject();
		int Waiter = (int) SGO.getObjectRow(sql).get(0);
		System.out.println("table num:"+Num+"  waiter:"+Waiter);			
		
		Obj_consume consume = new Obj_consume(Num, 0, 0, Waiter, 0, 0);

		
//		for(int j=0; j<vector.size(); j++){
//			System.out.println(vector.get(j));//vv 里面存放菜号
//		}
		for(int i=0; i<vv.size(); i++){//循环存入数据库，每次改变的是菜和厨师，不同的菜给不同的厨师。
			//System.out.println(vv.get(i));//vv 里面存放菜号
			if(vector.size()==0){
				vector = Chief_Start();
			}
			 //vector.get(0);//vector存放厨师号，给厨师分配任务。
			/*
			 * 一顿操作插入数据库
			 */
			consume.setKnum((int) vector.get(0));
			consume.setCnum((int) vv.get(i));
			try {
				ComonManage.Consume_manage(consume, ComonManage.Insert);
				ComonManage.setTableUsed(Num, 1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("插入出错");
			}
			vector.remove(0);
		}

		return 0;
	}
//	private Vector Chief_v() {
//		Vector vv;
//		String sqlStr = "select Knum from chief";
//		RetrieveObject SGO = new RetrieveObject();
//		vv = SGO.getObjectRow(sqlStr);
//		return null;
//	}
	private static Vector Chief_Start() {
		String sqlStr = "select Knum from chief";//用光了重新扫一遍
		RetrieveObject SGO = new RetrieveObject();
		return SGO.getObjectRow(sqlStr);
	}
}
