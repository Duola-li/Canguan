package model;

public class Obj_Chief {
	private int Knum;// 厨师号
	private String Kname;//厨师姓名
	private int Klevel;//厨师级别
	private int Kprice;
	public Obj_Chief(int Knum,String Kname,int Klevel, int Kprice)
	{
		this.Kname=Kname;
		this.Knum=Knum;
		this.Klevel=Klevel;
		this.Kprice=Kprice;
	}
	public int getKnum()
	{return Knum;}
	public void setKum(int Knum)
	{this.Knum=Knum;}
	public String getKname()
	{return Kname;}
	public void setKname(String Kname)
	{this.Kname=Kname;}
	public int getKlevel()
	{return Klevel;}
	public void setKlevel(int Klevel)
	{this.Klevel=Klevel;}
	public int getKprice()
	{return Kprice;}
	public void setKprice(int Klevel)
	{this.Kprice=Klevel;}

	public static int Tointlevel(String level) {
		if(level.equals("初级"))
			return 0;
		if(level.equals("中级"))
			return 1;
		if(level.equals("高级"))
			return 2;
		if(level.equals("特级"))
			return 3;
		if(level.equals("技师"))
			return 4;
		return -1;
		
	}

}
