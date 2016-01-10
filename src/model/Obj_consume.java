package model;


public class Obj_consume {
	private int Tnum;//桌号
	private int Cnum;//菜号
	private int Knum;//菜号
	private int Wnum;//菜号
	private int send;//是否完成
	private int made;
	public Obj_consume(int Tnum, int Cnum, int Knum, int Wnum, int send, int made){
		this.Cnum = Cnum;
		this.Knum = Knum;
		this.Tnum = Tnum;
		this.Wnum = Wnum;
		this.made = made;
		this.send = send;
	}
	public int getTnum()
		{return Tnum;}
	public void setTnum(int Tnum)
		{this.Tnum=Tnum;}
	public int getCnum()
		{return Cnum;}
	public void setCnum(int Cnum)
		{this.Cnum=Cnum;}
	public int getKnum()
		{return Knum;}
	public void setKnum(int Cnum)
		{this.Knum=Cnum;}
	public int getWnum()
		{return Wnum;}
	public void setWnum(int Cnum)
		{this.Wnum=Cnum;}
	public int getsend()
		{return send;}
	public void setsend(int finish)
		{this.send=finish;}
	public int getmade()
		{return made;}
	public void setmade(int finish)
		{this.made=finish;}
	
}
