package util;

public class Define {
	/*
	 * 菜的
	 */
	public static final int Model_Cnum = 1;
	public static final int Model_Cname = 2;
	public static final int Model_Clevel = 3;
	public static final int Model_Choose = 0;
	public static final int Model_Cprice = 4;
	public static final String Clevel[]={"鲁菜","川菜","粤菜","苏菜"};
	public static String[] Cai_columnNames = { "选择", "编号", "菜名", "菜系", "价格"};
	public static String[] Cai_columnNames2 = { "编号", "菜名", "菜系", "价格"};

	
	/*
	 * 厨师
	 */
	public static final int Model_Chiefnum = 0;
	public static final int Model_Chiefname = 1;
	public static final int Model_Chieflevel = 2;
	public static final int Model_Chiefprice = 3;
	public static final String Chieflevel[]={"初级","中级","高级","特级","技师"};
	public static final String Chief_columnNames[] = {"工号","姓名", "级别", "工资"};
	/*
	 * 服务员
	 */
	public static final int Model_Waiternum = 0;
	public static final int Model_Waitername = 1;
	public static final int Model_Waiterlevel = 2;
	public static final int Model_Waiterprice = 3;
	public static final String Waiterlevel[]={"服务员","前台","大堂经理","总经理"};
	public static final String Waiter_columnNames[] = {"工号","姓名", "级别", "工资"};
	
	/*
	 * 桌子
	 */
	public static final int Model_Tablenum = 0;
	public static final int Model_Tablewaiter = 1;
	public static final int Model_Tablelevel = 2;
	public static final String Tablelevel[]={"情侣桌","家庭桌","超大桌"};
	public static final String Table_columnNames[]={"桌号","服务员","类型"};
	public static final int Table_NUM = 5;
	public static final int PEOPLE_SCALE = 16;
	//public static final boolean[] test_Tables={true,true,true,true,true};
	public static final boolean[] test_Tables={true,false,false,true,false};

	/*
	 * 订桌
	 */
	public static final int MADE = 4;
	public static final int SEND = 3;
	public static final int Consume_Cnum = 1;
	public static final int Consume_Tnum = 0;
	public static final String Consume_columnNames[] = {"桌号","菜品","服务员", "是否上菜", "是否做完"};
	public static final String Consume_columnNamesW[] = {"桌号","菜品","厨师", "是否上菜", "是否做完"};
	
	public static final String Cost_columnNamesW[] = {"菜品","价格"};

	

}
