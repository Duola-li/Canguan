package util;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MyDTModel extends AbstractTableModel {//居然是继承的这个，我草我草！！！！！
    private Vector TableTitle;//表格的 列标题
	private Vector TableData;//用来存放表格数据的线性表    
    public MyDTModel(Vector vname, Vector dd ) {
		// TODO Auto-generated constructor stub
//    	TableData = (Vector) dd.clone();
//    	TableTitle = (Vector) vname.clone();
//    	for(int i=0; i<vname.length; i++){
//    		TableTitle.addElement(vname[i]);
//    	}
    	TableData = dd;
    	TableTitle = vname;
//    	for(int i=0; i<TableData.size(); i++){
//    		Vector vdata = (Vector) TableData.get(i);
//    		for(int j=0; j<vdata.size(); j++){
//    			System.out.println(vdata.get(j));
//    		}
//    	}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		return  getValueAt(0, columnIndex).getClass();
	}   
	 
	@Override
	public String getColumnName(int column)
	{
		return (String)TableTitle.get(column);//[column];
	}
	       @Override
	       public int getRowCount()
	       {
	              //这里是告知表格应该有多少行，我们返回TableData上挂的String数组个数
	              return TableData.size();
	       }
	  
	       @Override
	       public int getColumnCount()
	       {
	              //告知列数，用标题数组的大小,这样表格就是TableData.size()行，TableTitle.size()列了
	              return TableTitle.size();
	       }
	  
	       @Override
	       public Object getValueAt(int rowIndex, int columnIndex)
	       {
	              //获取了表格的大小，当然还要获取数据，根据坐标直接返回对应的数据
	              //小心 都是从 0开始的，小心下标越界 的问题
	              //我们之前是将 String[]挂到了线性表上，所以要先获取到String[]
	              //
	              //获取每一行对应的String[]数组
	              //String LineTemp[] = (String[])this.TableData.get(rowIndex);
	              //提取出对 应的数据
	              //return LineTemp[columnIndex];
	               
	              //如果我们是将 线性表Vector挂到了Vector上要注意每次我们获取的是 一行线性表
	              //例如
	              return ((Vector)TableData.get(rowIndex)).get(columnIndex);
	       }
	  
	       @Override
	       public boolean isCellEditable(int rowIndex, int columnIndex)
	       {
	              //这个函数式设置每个单元格的编辑属性的
	              //这个函数AbstractTableModel已经实现，默认的是 不允许编辑状态
	              //这里我们设置为允许编辑状态
	              //return false;//super.isCellEditable(rowIndex, columnIndex);
	    	   if (columnIndex < 1)
					return true;
				else
					return false;
	       }
	       @Override
	       public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	       {
	              //当单元格的数据发生改变的时候掉用该函数重设单元格的数据
	              //我们想一下，数据是放在TableData 中的，说白了修改数据就是修改的
	              //TableData中的数据，所以我们仅仅在此处将TableData的对应数据修改即可
	               
	              //((String[])this.TableData.get(rowIndex))[columnIndex]=(String)aValue;
	    	   		((Vector) TableData.get(rowIndex)).set(columnIndex, aValue);
	              
	              super.setValueAt(aValue, rowIndex, columnIndex);
	              
	              //
	              //其实这里super的方法是调用了fireTableCellUpdated()只对应更新了
	              //对应单元格的数据
	              //fireTableCellUpdated(rowIndex, columnIndex);
	       }
	       public static void main(String[] args)
	       {               
	    	   RetrieveObject RO = new RetrieveObject();
	    	   	MyDTModel myModel=  RO.getCaiTableModel(Define.Cai_columnNames, "select * from menu");
//	    	   Vector vname = new Vector(), dd=null;
//	    	   for (int i = 0 ; i < Define.Cai_columnNames.length ; i++){
//	               vname.addElement(Define.Cai_columnNames[i]);
//	           }
//	    	   MyDTModel myModel = new MyDTModel(vname, dd);
	             JTable table = new JTable(myModel);
	             JScrollPane scrollpane = new JScrollPane(table);
	             JFrame jf = new JFrame();
	             JScrollPane jsp = new JScrollPane(table);
	             jf.add(jsp);
	             jf.setBounds(0, 0, 500, 500);
	             jf.setVisible(true);    
	       }
}
