package model;

public class Obj_Waiter {
	private int Wnum;
	private String  Wname  ;
    private int  Wprice;
    private int Wlevel;
    private String data;
    public Obj_Waiter(int Wnum,String Wname,int Wlevel,int Wprice)
    {
    	this.Wnum=Wnum;
    	this.Wname=Wname;
    	this.Wprice=Wprice;
    	this.Wlevel=Wlevel;
    }
    public int getWnum()
    {return Wnum;}
    public void setWnum(int Wnum)
    {this.Wnum=Wnum;}
    public String  getWname()
    {return Wname;}
    public void setWname(String   Wname)
    {this.Wname=Wname;}
    public int getWprice()
    {return Wprice;}
    public void setWprice(int Wprice)
    {this.Wprice = Wprice;}
    public int  getWlevel()
    {return Wlevel;}
    public void setWlevel(int   Wlevel)
    {this.Wlevel=Wlevel;}
    public String  data()
    {return data;}
    public void setdata(String   data)
    {this.data = data;}
 
	public static int Tointlevel(String level) {
		if(level.equals("服务员"))
			return 0;
		if(level.equals("前台"))
			return 1;
		if(level.equals("大堂经理"))
			return 2;
		if(level.equals("总经理"))
			return 3;
		return -1;
		
	}
}
