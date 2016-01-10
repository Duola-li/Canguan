package model;

public class Obj_Table {
	private int Tnum;
	private int Tlevel  ;
    private int  Twaiter;
    private int Tused;
    public Obj_Table(int Tnum,int Tlevel,int Twaiter,int Tused)
    {
    	this.Tnum=Tnum;
    	this.Tlevel=Tlevel;
    	this.Twaiter=Twaiter;
    	this.Tused=Tused;
    }
    public Obj_Table(int num, int Twaiter, int intlevel) {
		// TODO Auto-generated constructor stub
    	this.Tnum=Tnum;
    	this.Tlevel=Tlevel;
    	this.Twaiter=Twaiter;
	}
	public int getTnum()
    {return Tnum;}
    public void setTnum(int Tnum)
    {this.Tnum=Tnum;}
    public int getTlevel()
    {return Tlevel;}
    public void setTlevel(int  Tlevel)
    {this.Tlevel  =  Tlevel;}
    public int getTwaiter()
    {return Twaiter;}
    public void setTwaiter (int Twaiter)
    {this.Twaiter = Twaiter;}
    public int getTused()
    {return Tused;}
    public void setTused  (int Tused)
    {this.Tused  = Tused;}
	public static int Tointlevel(String level) {
		if(level.equals("情侣桌"))
			return 0;
		if(level.equals("家庭桌"))
			return 1;
		if(level.equals("超大桌"))
			return 2;
		return -1;
		
	}

}
