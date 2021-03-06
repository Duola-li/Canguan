package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;

import model.Obj_Waiter;
import model.Obj_Waiter;
import util.ComonManage;
import util.Define;
import util.MyAATModel;
import util.RetrieveObject;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_waiter extends JPanel {
	private JTextField text_num;
	private JTextField text_name;
	private JComboBox comboBox_level;
	private JTextField text_price;
	private JTable table;
	private MyAATModel model_waiter;
	private TableRowSorter sorter;
	static int Dealrow = -1;//记录表格当前操作的行
	String sqlsql;
	RetrieveObject RO = new RetrieveObject();
	/**
	 * Create the panel.
	 */
	public JP_waiter() {
		sqlsql = "select * from waiter";
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 674, 265);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		model_waiter = RO.getTableModel(Define.Chief_columnNames, sqlsql);
		sorter = new TableRowSorter(model_waiter);  
		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。		
		table.setModel(model_waiter);
		table.setRowSorter(sorter); 
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(scrollPane, BorderLayout.NORTH);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 265, 674, 121);
		panel.add(panel_2);
		
		JLabel label = new JLabel("编号:");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(20, 15, 40, 22);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(243, 15, 40, 22);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("工资:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(243, 67, 40, 22);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("级别:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(20, 67, 40, 22);
		panel_2.add(label_3);
		
		text_num = new JTextField();
		text_num.setEditable(false);
		text_num.setColumns(10);
		text_num.setBounds(58, 12, 136, 30);
		panel_2.add(text_num);
		
		text_name = new JTextField();
		text_name.setColumns(10);
		text_name.setBounds(281, 12, 136, 30);
		panel_2.add(text_name);
		
		text_price = new JTextField();
		text_price.setColumns(10);
		text_price.setBounds(281, 64, 95, 30);
		panel_2.add(text_price);
		
		final JButton savechange = new JButton("保存");
		
		savechange.setFont(new Font("宋体", Font.PLAIN, 14));
		savechange.setBounds(462, 15, 67, 33);
		panel_2.add(savechange);
		
		final JButton drop = new JButton("删除");
		drop.setFont(new Font("宋体", Font.PLAIN, 14));
		drop.setBounds(462, 58, 67, 35);
		panel_2.add(drop);
		
		final JButton insert = new JButton("插入");
		insert.setFont(new Font("宋体", Font.PLAIN, 14));
		insert.setBounds(561, 15, 67, 33);
		panel_2.add(insert);
		
		final JButton refresh = new JButton("刷新");
		refresh.setFont(new Font("宋体", Font.PLAIN, 14));
		refresh.setBounds(561, 58, 67, 36);
		panel_2.add(refresh);
		
		final JButton saveinsert = new JButton("插 入");
		saveinsert.setFont(new Font("宋体", Font.PLAIN, 14));
		saveinsert.setVisible(false);
		saveinsert.setBounds(511, 15, 80, 33);
		panel_2.add(saveinsert);
		
		final JButton cancelinsert = new JButton("取 消");
		cancelinsert.setFont(new Font("宋体", Font.PLAIN, 14));
		cancelinsert.setVisible(false);
		cancelinsert.setBounds(511, 58, 80, 35);
		panel_2.add(cancelinsert);
		
		comboBox_level = new JComboBox(Define.Waiterlevel);
		comboBox_level.setBounds(70, 63, 80, 30);
		panel_2.add(comboBox_level);
		
		JLabel label_4 = new JLabel("(千元)");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(377, 67, 62, 22);
		panel_2.add(label_4);
		
		
		/*
		 * 监听动作
		 */
		cancelinsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 取消插入，清除内容，回复按钮
				 */
				text_num.setText("");
				text_price.setText("");
				//text_level.setText("");
				text_name.setText("");
				text_name.requestFocus();
				Dealrow = -1;
				savechange.setVisible(true);
				drop.setVisible(true);
				refresh.setVisible(true);
				insert.setVisible(true);
				saveinsert.setVisible(false);
				cancelinsert.setVisible(false);
			}
		});
		insert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 点击插入，做插入准备工作，隐藏按钮，清除内容，清除Dealrow
				 */
				
				int getCnum;
				try {
					getCnum = ComonManage.Max_num("waiter")+1;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("max error");
					return;
				}//刘凯getCnum; ？？？？？？？？！！！！“”“”“”“”“”！！！！！！！！！！！！
				
				text_num.setText(getCnum+"");
				text_price.setText("");
				//text_level.setText("");
				text_name.setText("");
				text_name.requestFocus();
				Dealrow = -1;
				savechange.setVisible(false);
				drop.setVisible(false);
				refresh.setVisible(false);
				insert.setVisible(false);
				saveinsert.setVisible(true);
				cancelinsert.setVisible(true);
				
			}
		});
		saveinsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 插入数据，先从数据库获得最大数据+1，也就是当前获得的分配号。然后获取text框中数据，检查，插入。
				 */
				
				String name = text_name.getText();
				String level = (String) comboBox_level.getSelectedItem();
				int price = 0;
				int num;
				int intlevel = Obj_Waiter.Tointlevel(level);
				try {	
					num = Integer.valueOf(text_num.getText());
					price = Integer.valueOf(text_price.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"对不起，价格不合适啊！","错误",JOptionPane. INFORMATION_MESSAGE);
					text_price.requestFocus();
					System.out.println("没有选择数据");
					return;
				}
				System.out.println("cnum:"+num+"\tprice:"+price+"\tintlevel:"+intlevel+"\tname:"+name);

				if (name.length()<0){
					JOptionPane.showMessageDialog(null,"对不起，名字不能为空！","错误",JOptionPane. INFORMATION_MESSAGE);
					text_name.requestFocus();
  	  				return;
				}
				if(price<1){
					JOptionPane.showMessageDialog(null,"对不起，价格过低！","错误",JOptionPane. INFORMATION_MESSAGE);
					text_price.requestFocus();
  	  				return;
				}
				if(intlevel<0){
					JOptionPane.showMessageDialog(null,"对不起，未知级别！","错误",JOptionPane. INFORMATION_MESSAGE);
					//text_level.requestFocus();
  	  				return;
				}
				/*
				 * 这里已经昨晚类型检测，接下来进行确认数据库更新操作。
				 */
				int i=JOptionPane.showConfirmDialog(null, "确定插入？","提示", JOptionPane.YES_NO_OPTION);
  	  			if(i==JOptionPane.OK_OPTION){
  	  				System.out.println("修改保存了");
  	  				/*
  	  				 * 数据库更新。确定更新成功后更改表格内容
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 */
  	  			Obj_Waiter cai = new Obj_Waiter(num, name, intlevel, price);
  				try {
				ComonManage.Waiter_manage(cai, ComonManage.Insert);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	  				System.out.println("数据库插入错误");
				return;
			}
  	  			model_waiter = RO.getTableModel(Define.Chief_columnNames, sqlsql);
  	  		sorter = new TableRowSorter(model_waiter);  
  	  		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。		
  	  		table.setModel(model_waiter);
  	  		table.setRowSorter(sorter); 
	  				
	  				text_num.setText("");
					text_price.setText("");
					text_name.setText("");
  	  				Dealrow = -1;
  	  				JOptionPane.showMessageDialog(null,"插入成功！","恭喜",JOptionPane. INFORMATION_MESSAGE);
  	  			}else{
  	  				System.out.println("放弃修改");
  	  			}
  	  			
	  	  		text_num.setText("");
				text_price.setText("");
				//text_level.setText("");
				text_name.setText("");
				text_name.requestFocus();
	  	  		savechange.setVisible(true);
				drop.setVisible(true);
				refresh.setVisible(true);
				insert.setVisible(true);
				saveinsert.setVisible(false);
				cancelinsert.setVisible(false);
			}
		});
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 刷新，重新从数据库获得数据
				 */
				model_waiter = RO.getTableModel(Define.Chief_columnNames, sqlsql);
				sorter = new TableRowSorter(model_waiter);  
				table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。		
				table.setModel(model_waiter);
				table.setRowSorter(sorter); 
	  				JOptionPane.showMessageDialog(null,"操作成功！","恭喜",JOptionPane. INFORMATION_MESSAGE);
	  				text_num.setText("");
					text_price.setText("");
					text_name.setText("");
  	  				Dealrow = -1;
			}
		});
		
		drop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 删除按钮
				 */
				if (Dealrow < 0) {
					JOptionPane.showMessageDialog(null,"对不起，没有选择数据！","错误",JOptionPane. INFORMATION_MESSAGE);
					System.out.println("没有选择数据");
					return;
				}
				
				int num = 0;				
				String name = (String) table.getValueAt(Dealrow, Define.Model_Waitername);
				try {
					num = Integer.valueOf(text_num.getText());								
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"对不起，没有选择数据！","错误",JOptionPane. INFORMATION_MESSAGE);
					System.out.println("没有选择数据");
					return;
				}
				
				int i=JOptionPane.showConfirmDialog(null, "确定删除 "+name+"("+num+")？","提示", JOptionPane.YES_NO_OPTION);
  	  			if(i==JOptionPane.OK_OPTION){
  	  				System.out.println("要删除");
  	  				/*
  	  				 * 数据库删除。成功后更改表格内容
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 */
  	  			Obj_Waiter cai = new Obj_Waiter(num, name, 0, 0);
  				try {
					ComonManage.Waiter_manage(cai, ComonManage.Delete);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
		  				System.out.println("数据库删除错误");
					return;
				}
  	  				//table.removeRow(Dealrow);		//删除行是table的内部函数，需要看看是怎么写table，继承还是怎样。
  	  			model_waiter = RO.getTableModel(Define.Chief_columnNames, sqlsql);
  	  		sorter = new TableRowSorter(model_waiter);  
  	  		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。		
  	  		table.setModel(model_waiter);
  	  		table.setRowSorter(sorter); 
  	  				
	  	  			text_num.setText("");
					text_price.setText("");
					text_name.setText("");
  	  				Dealrow = -1;
  	  				JOptionPane.showMessageDialog(null,"操作成功！","恭喜",JOptionPane. INFORMATION_MESSAGE);
  	  			}else{
  	  				System.out.println("放弃删除");
  	  			}
			}
		});
		
		savechange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 保存按钮，检查数据，提示输出
				 */
				
				int num = 0;				
				String name = text_name.getText();
				String level = (String) comboBox_level.getSelectedItem();
				int price = 0;
				int intlevel = Obj_Waiter.Tointlevel(level);
				try {
					//System.out.println(text_num.getText());
					//System.out.println(text_price.getText());
					//用错了，不是getInterget。
					num = Integer.valueOf(text_num.getText());								
					price = Integer.valueOf(text_price.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"对不起，没有选择数据！","错误",JOptionPane. INFORMATION_MESSAGE);
					System.out.println("没有选择数据");
					return;
				}
				System.out.println("num:"+num+"\tprice:"+price+"\tintlevel:"+intlevel+"\tname:"+name);

				if (name.length()<0){
					JOptionPane.showMessageDialog(null,"对不起，名字不能为空！","错误",JOptionPane. INFORMATION_MESSAGE);
  	  				return;
				}
				if(price<1){
					JOptionPane.showMessageDialog(null,"对不起，价格过低！","错误",JOptionPane. INFORMATION_MESSAGE);
  	  				return;
				}
				if(intlevel<0){
					JOptionPane.showMessageDialog(null,"对不起，未知菜系！","错误",JOptionPane. INFORMATION_MESSAGE);
  	  				return;
				}
				/*
				 * 这里已经昨晚类型检测，接下来进行确认数据库更新操作。
				 */
				int i=JOptionPane.showConfirmDialog(null, "确定修改？","提示", JOptionPane.YES_NO_OPTION);
  	  			if(i==JOptionPane.OK_OPTION){
  	  				System.out.println("修改保存了");
  	  				/*
  	  				 * 数据库更新。确定更新成功后更改表格内容
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 */
  	  			Obj_Waiter cai = new Obj_Waiter(num, name, intlevel, price);
  				try {
					ComonManage.Waiter_manage(cai, ComonManage.Update);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
			  				System.out.println("数据库更新错误");
						return;
				}
  	  				table.setValueAt(num, Dealrow, Define.Model_Waiternum);
  	  				table.setValueAt(name, Dealrow, Define.Model_Waitername);
  	  				table.setValueAt(intlevel, Dealrow, Define.Model_Waiterlevel);
  	  				table.setValueAt(price, Dealrow, Define.Model_Waiterprice);
  	  				JOptionPane.showMessageDialog(null,"操作成功！","恭喜",JOptionPane. INFORMATION_MESSAGE);
  	  			}else{
  	  				System.out.println("放弃修改");
  	  			}
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String selectedData = null;  
                int[] selectedRow = table.getSelectedRows();//被选择的行  
                int[] selectedColumns = table.getSelectedColumns();//被选择的列  
                if (selectedRow.length != 0){//有选择
                	int row = selectedRow[0];
                	int column = selectedColumns[0];
                	Dealrow = row;
                	/*
                	 * 测试输出
                	 */
              	  	selectedData = table.getValueAt(row, column).toString();  
              	  	System.out.println(selectedRow[0]+":"+selectedColumns[0]+"选择的: " + selectedData);
              	  	
              	  	/*
              	  	 * 这里就是点击一条信息，放到下面可以编辑，删除，不用判断新行
              	  	 * 数据采用公共类，定义了每个类型，在model中位置
              	  	 */
              	  	
              	  	text_num.setText(table.getValueAt(row, Define.Model_Waiternum).toString());
              	  	text_name.setText(table.getValueAt(row, Define.Model_Waitername).toString());
              	  	//text_level.setText(table.getValueAt(row, Define.Model_Waiterlevel).toString());
              	    comboBox_level.setSelectedIndex((int) table.getValueAt(row, Define.Model_Waiterlevel));
              	  	text_price.setText(table.getValueAt(row, Define.Model_Waiterprice).toString());
              	  	
              	//结束监听动作
                }
			}
		});

	}

}
