package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;

import util.ComonManage;
import util.Define;
import util.MyAATModel;
import util.MyDTModel;
import util.RetrieveObject;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.lang.model.type.NullType;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JF_Chief extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private MyAATModel model_consume;						//该滚滚滚滚滚滚滚滚	用全局替换
	private TableRowSorter sorter;
	private JRadioButton OnlyNodone;
	static int Dealrow = -1;
	String sqlsql;
	RetrieveObject RO = new RetrieveObject();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_Chief frame = new JF_Chief(30000);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF_Chief(final int Num) {
		sqlsql = "select Tnum, Cnum, Wnum, send, made from consume where Knum ="+Num;
		setTitle("厨师做菜服务管理("+Num+")");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_bar = new JPanel();
		contentPane.add(panel_bar, BorderLayout.NORTH);
		panel_bar.setLayout(new BoxLayout(panel_bar, BoxLayout.X_AXIS));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(50);
		panel_bar.add(horizontalStrut_2);
		
		JLabel lblNewLabel = new JLabel("桌号:");
		panel_bar.add(lblNewLabel);
		
		textField = new JTextField();
		panel_bar.add(textField);
		textField.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(80);
		panel_bar.add(horizontalStrut);
		
		OnlyNodone = new JRadioButton("只显示未做完");
		panel_bar.add(OnlyNodone);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(120);
		panel_bar.add(horizontalStrut_1);
		
		JButton Button_search = new JButton("查 询");
		Button_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int table_num=-1;
				String IsOnlyDone = "";
				String IsTable = "";
				String Stable_num = textField.getText();
				if (!Stable_num.equals("")){//不为空，要考虑桌子
					try {
						table_num = Integer.valueOf(Stable_num);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,"对不起，桌号不合适啊！","错误",JOptionPane. INFORMATION_MESSAGE);
						textField.requestFocus();
						return;
					}
					if(table_num < 0 || table_num > 5){
						JOptionPane.showMessageDialog(null,"对不起，桌号不存在啊！","错误",JOptionPane. INFORMATION_MESSAGE);
						textField.requestFocus();
						return;
					}
					IsTable = " AND Tnum = "+table_num;
				}
				if( OnlyNodone.isSelected() ){
					//选择了只显示未完成
					IsOnlyDone = " AND made = 0";
				}
				
				
				/*
				 * sql
				 */
				model_consume = RO.getTableModel(Define.Consume_columnNames, sqlsql+IsTable+IsOnlyDone);					//该滚滚滚滚滚滚滚滚
				sorter = new TableRowSorter(model_consume);  					//该滚滚滚滚滚滚滚滚
				//ListSelectionModel cellSelectionModel = table.getSelectionModel();
				table.setModel(model_consume);
				table.setRowSorter(sorter);
				table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
					
					System.out.println(IsTable+"\t"+IsOnlyDone);
					Dealrow = -1;
			}
		});
		panel_bar.add(Button_search);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(40);
		panel_bar.add(horizontalStrut_4);
		
		JButton Button_done = new JButton("做好了");
		Button_done.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Dealrow >= 0){
					int i=JOptionPane.showConfirmDialog(null, "确定完成此菜品？","提示", JOptionPane.YES_NO_OPTION);
	  	  			if(i==JOptionPane.OK_OPTION){
	  	  				table.setValueAt(1, Dealrow, Define.MADE);
	  	  				int Cnum = (int) table.getValueAt(Dealrow, Define.Consume_Cnum);
	  	  				int Tnum = (int) table.getValueAt(Dealrow, Define.Consume_Tnum);
	  	  				ComonManage.setMade(Tnum, Cnum, Num, 1);
	  	  				Dealrow = -1;
	  	  				
//	  	  			model_consume = RO.getTableModel(Define.Consume_columnNames, sqlsql+IsTable+IsOnlyDone);					//该滚滚滚滚滚滚滚滚
//					sorter = new TableRowSorter(model_consume);  					//该滚滚滚滚滚滚滚滚
//					table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
//					ListSelectionModel cellSelectionModel = table.getSelectionModel();
//					//panel_1.setLayout(new BorderLayout(0, 0));
					table.setModel(model_consume);
					table.setRowSorter(sorter);
				
	  	  			}
				}else{
					JOptionPane.showMessageDialog(null,"对不起，未选择菜品！","错误",JOptionPane. INFORMATION_MESSAGE);

				}
			}
		});
		panel_bar.add(Button_done);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(50);
		panel_bar.add(horizontalStrut_3);
		
		JPanel panel_table = new JPanel();
		contentPane.add(panel_table, BorderLayout.CENTER);
		panel_table.setLayout(null);
		
		/*
		 * 表格
		 */
		model_consume = RO.getTableModel(Define.Consume_columnNames, sqlsql);					//该滚滚滚滚滚滚滚滚
		sorter = new TableRowSorter(model_consume);  					//该滚滚滚滚滚滚滚滚
		table = new JTable();
		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		table.setModel(model_consume);
		table.setRowSorter(sorter); 
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
              	
              	//结束监听动作
                }
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(0, 10, 674, 368);
		panel_table.add(scrollPane_1);
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
	}
}
