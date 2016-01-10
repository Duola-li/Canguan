
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class test {
    public static void main(String[] args) {
        	DefaultTableModel model = new DefaultTableModel(new String[]{"num", "name", "level", "¼Û¸ñ"}, 0);
        	//Vector vv = new Vector();
        //	vv.addElement(obj);
        	String[][] abc = {
        			{"001", "³´ÍÁ¶¹", "Â³²Ë", "100"},
        			{"002", "³´ÍÁ¶¹1", "Â³²Ë", "300"},
        			{"003", "³´ÍÁ¶¹2", "Â³²Ë", "120"}
        	};
        	for(int i=0; i<abc.length; i++){
        		model.addRow(abc[i]);
        		System.out.println(i);
        	}
        	System.out.println(model.toString());
        
    }
    public static DefaultTableModel getmodel(){
    	DefaultTableModel model = new DefaultTableModel(new String[]{"num", "name", "level", "¼Û¸ñ"}, 0);
    	String[][] abc = {
    			{"001", "³´ÍÁ¶¹", "Â³²Ë", "100"},
    			{"002", "³´ÍÁ¶¹1", "Â³²Ë", "300"},
    			{"003", "³´ÍÁ¶¹2", "Â³²Ë", "120"}
    	};
    	for(int i=0; i<abc.length; i++){
    		model.addRow(abc[i]);
    		System.out.println(i);
    	}
    	return model;
    }


}
