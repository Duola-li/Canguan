
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class test {
    public static void main(String[] args) {
        	DefaultTableModel model = new DefaultTableModel(new String[]{"num", "name", "level", "�۸�"}, 0);
        	//Vector vv = new Vector();
        //	vv.addElement(obj);
        	String[][] abc = {
        			{"001", "������", "³��", "100"},
        			{"002", "������1", "³��", "300"},
        			{"003", "������2", "³��", "120"}
        	};
        	for(int i=0; i<abc.length; i++){
        		model.addRow(abc[i]);
        		System.out.println(i);
        	}
        	System.out.println(model.toString());
        
    }
    public static DefaultTableModel getmodel(){
    	DefaultTableModel model = new DefaultTableModel(new String[]{"num", "name", "level", "�۸�"}, 0);
    	String[][] abc = {
    			{"001", "������", "³��", "100"},
    			{"002", "������1", "³��", "300"},
    			{"003", "������2", "³��", "120"}
    	};
    	for(int i=0; i<abc.length; i++){
    		model.addRow(abc[i]);
    		System.out.println(i);
    	}
    	return model;
    }


}
