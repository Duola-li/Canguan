package util;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import model.Obj_Cai;

import java.sql.ResultSet;
import java.awt.Checkbox;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.util.Collection;
import java.util.HashMap;
public class RetrieveObject {
    private Connection conn;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private PreparedStatement ptmt;
    private Statement stmt;
    public RetrieveObject(){

    }
    
    public static void main(String[] args) {
    	 String sql = "Select * from login ";
		 RetrieveObject duola = new RetrieveObject();
		 Vector vector;
//		 vector = duola.getObjectRow("Select * from login");
//		 Vector collect = (Vector) duola.getTableCollection("Select * from login ");
//		 for(int i=0;i<vector.size();i++){
//			  
//			  System.out.println(vector.get(i));
//		 }
//		 for(int i=0;i<collect.size();i++){
//			 vector = (Vector) collect.get(i);
//			 for(int j=0;j<vector.size();j++){
//				  
//				  System.out.println(vector.get(j));
//			 }
//		 }
		 boolean [] use = duola.getTableUsed();
		 for(int i=0; i<use.length; i++){
			 System.out.println(i+":"+use[i]);
		 }
    	//System.out.println();
    }
    /*
     * 返回集合
     */
    public Collection getTableCollection(String sqlStr){
        System.out.println("执行的集合查询为 :" + sqlStr);
        Collection collection = new Vector();
        CommonaJdbc conjdbc = new CommonaJdbc();
        conn = conjdbc.connection;
        try{
            rs = conn.prepareStatement(sqlStr).executeQuery();
            rsmd = rs.getMetaData();
            while(rs.next()){
                Vector vdata = new Vector();
                for ( int i = 1 ; i <= rsmd.getColumnCount() ; i ++){
                    vdata.addElement(rs.getObject(i));
                }
                collection.add(vdata);
            }
        }catch(java.sql.SQLException sql){
        	javax.swing.JOptionPane.showMessageDialog(null, "执行的SQL语句为:\n" + sqlStr + "\n错误信息为：" + sql.getMessage(), "系统提示",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            sql.printStackTrace();
            return null;
        }
        return collection;
    }
    
    /*
     * 返回tablemodel
     */
    public MyAATModel getTableModel(String[] name,String sqlStr){
    	Vector vname = new Vector();
        for (int i = 0 ; i < name.length ; i++){
            vname.addElement(name[i]);
        }
        Vector dd = new Vector();
        CommonaJdbc conjdbc = new CommonaJdbc();
        conn = conjdbc.connection;
        try{
            rs = conn.prepareStatement(sqlStr).executeQuery();
            rsmd = rs.getMetaData();
            while(rs.next()){
                Vector vdata = new Vector();
                //Object[] data = new Object[5];
               // data[0] = new Boolean(false);
                //data[0] = new  JCheckBox();
                //vdata.addElement(new Boolean(false));
                for ( int i = 1 ; i <= rsmd.getColumnCount() ; i ++){
                    vdata.addElement(rs.getObject(i));
                	//data[i] = rs.getObject(i);
                }
               
                //tableModel.addRow(vdata);
               // tableModel.addRow(data);
               dd.addElement(vdata);
            }
        }catch(java.sql.SQLException sql){
            sql.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "执行的SQL语句为:\n" + sqlStr + "\n错误信息为：" + sql.getMessage(), "系统提示",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return new MyAATModel(vname,dd);
    }
    public MyDTModel getCaiTableModel(String[] name,String sqlStr){
        Vector vname = new Vector();
        for (int i = 0 ; i < name.length ; i++){
            vname.addElement(name[i]);
        }
        Vector dd = new Vector();
        CommonaJdbc conjdbc = new CommonaJdbc();
        conn = conjdbc.connection;
        try{
            rs = conn.prepareStatement(sqlStr).executeQuery();
            rsmd = rs.getMetaData();
            while(rs.next()){
                Vector vdata = new Vector();
                //Object[] data = new Object[5];
               // data[0] = new Boolean(false);
                //data[0] = new  JCheckBox();
                vdata.addElement(new Boolean(false));
                for ( int i = 1 ; i <= rsmd.getColumnCount() ; i ++){
                    vdata.addElement(rs.getObject(i));
                	//data[i] = rs.getObject(i);
                }
                int ll = (int)vdata.get(Define.Model_Clevel);
                vdata.set(Define.Model_Clevel, Define.Clevel[ll]);
                
                //tableModel.addRow(vdata);
               // tableModel.addRow(data);
               dd.addElement(vdata);
            }
        }catch(java.sql.SQLException sql){
            sql.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "执行的SQL语句为:\n" + sqlStr + "\n错误信息为：" + sql.getMessage(), "系统提示",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return new MyDTModel(vname,dd);
    }
    
    
    //一条
    public Vector getObjectRow(String sqlStr){
        Vector vdata = new Vector();
        CommonaJdbc conjdbc = new CommonaJdbc();
        conn = conjdbc.connection;
        try{
        	stmt = (Statement) conjdbc.connection.createStatement();
        	rs = stmt.executeQuery(sqlStr);
            rsmd = rs.getMetaData();
            while(rs.next()){
                for ( int i = 1 ; i <= rsmd.getColumnCount() ; i ++){
                    vdata.addElement(rs.getObject(i));
                }
            }
        }catch(java.sql.SQLException sql){
            sql.printStackTrace();
            return null;
        }
        return vdata;
    }
    
    /*
     * 桌子使用数组
     */
    public boolean[] getTableUsed(){
    	boolean [] TableUsed = new boolean[5];
    	String sqlStr = "select Tused from tables ";
        CommonaJdbc conjdbc = new CommonaJdbc();
        conn = conjdbc.connection;
        try{
            rs = conn.prepareStatement(sqlStr).executeQuery();
            rsmd = rs.getMetaData();
            Vector vdata = new Vector();
            while(rs.next()){
            		//System.out.println(rs.getRow());
            		TableUsed[rs.getRow()-1] = (boolean)rs.getObject(1);
            }
//            while(rs.next()){
//                for ( int i = 1 ; i <= rsmd.getColumnCount() ; i ++){
//                    vdata.addElement(rs.getObject(i));
//                }
//            }
//            for(int i=0;i<vdata.size();i++){
//  			  
//  			  System.out.println(vdata.get(i));
//  		 }
        }catch(java.sql.SQLException sql){
        	javax.swing.JOptionPane.showMessageDialog(null, "执行的SQL语句为:\n" + sqlStr + "\n错误信息为：" + sql.getMessage(), "系统提示",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            sql.printStackTrace();
            return null;
        }
    	return TableUsed;
    }
}
