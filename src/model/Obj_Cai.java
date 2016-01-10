package model;

import javax.swing.table.DefaultTableModel;

public class Obj_Cai {
	private int Cnum;//菜号
	 private String Cname;//菜名
	 private int Clevel;//级别
	 private float Cprice;//价格
	 public Obj_Cai(int Cnum,String Cname,int Clevel,float Cprice)
	 {
		 this.Cnum=Cnum;
		 this.Cname=Cname;
		 this.Clevel=Clevel;
		 this.Cprice=Cprice;
	 }
	 public int getCnum()
	 {return Cnum;}
	 public void setCnum(int Cnum)
	 {this.Cnum=Cnum;}
	 public String getCname()
	 {return Cname;}
	 public void setCname(String Cname)
	 {this.Cname=Cname;}
	 public int getClevel()
	 {return Clevel;}
	 public void setClevel(int Clevel)
	 {this.Clevel=Clevel;}
	 public float getCprice()
	 {return Cprice;}
	 public void setCprice(float Cprice)
	 {this.Cprice=Cprice;}
	public static int Tointlevel(String level) {
		if(level.equals("鲁菜"))
			return 0;
		if(level.equals("川菜"))
			return 1;
		if(level.equals("粤菜"))
			return 2;
		if(level.equals("苏菜"))
			return 3;
		return -1;
		
	}

}
