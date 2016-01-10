package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;

import util.ComonManage;
import util.Define;
import util.MyAATModel;
import util.RetrieveObject;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class JF_Pay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private MyAATModel model_consume;						//该滚滚滚滚滚滚滚滚	用全局替换
	private TableRowSorter sorter;
	String sqlsql;
	String sqlCost;
	RetrieveObject RO = new RetrieveObject();
	private JTextField Cost;
	int Itable = -1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_Pay frame = new JF_Pay();
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
	public JF_Pay() {
		sqlsql = "SELECT Cname, Cprice FROM `consume`, `menu` WHERE finished = 0 and consume.Cnum = menu.Cnum and Tnum = ";
		sqlCost = "SELECT SUM(Cprice) FROM `consume`, `menu` WHERE finished = 0 and consume.Cnum = menu.Cnum and Tnum = ";
		 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 10, 504, 54);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("桌号：");
		lblNewLabel.setBounds(10, 10, 54, 34);
		panel_1.add(lblNewLabel);
		
		JButton btn_Ok = new JButton("完成结账");
		btn_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//结完帐，消除数据
				if(Itable>=0){
					ComonManage.OK(Itable);
					ComonManage.setTableUsed(Itable, 0);
					JF_Welcome.frame3.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null,"对不起，请说出桌号！","错误",JOptionPane. INFORMATION_MESSAGE);

				}
			}
		});
		btn_Ok.setForeground(Color.RED);
		btn_Ok.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_Ok.setBounds(377, 10, 93, 34);
		panel_1.add(btn_Ok);
		
		textField = new JTextField();
		textField.setBounds(46, 17, 66, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btn_search = new JButton("查 询");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Itable = Integer.valueOf(textField.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"对不起，桌号不合适啊！","错误",JOptionPane. INFORMATION_MESSAGE);
					textField.requestFocus();
					return;
				}
				if(Itable <0 && Itable>4){
					JOptionPane.showMessageDialog(null,"对不起，桌号不合适啊！","错误",JOptionPane. INFORMATION_MESSAGE);
					textField.requestFocus();
					return;
				}
				//拿到桌号码
				model_consume = RO.getTableModel(Define.Cost_columnNamesW, sqlsql+Itable);					//该滚滚滚滚滚滚滚滚
				table.setModel(model_consume);
				System.out.println(model_consume.getRowCount());
				//空表不能用sorter
				if(model_consume.getRowCount() > 0){
					sorter = new TableRowSorter(model_consume);  					//该滚滚滚滚滚滚滚滚
					table.setRowSorter(sorter); 
					System.out.println("空表不能用sorter");
				}
				table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
				
				
				//设置总价
				try {
					Cost.setText( ((BigDecimal)RO.getObjectRow(sqlCost+Itable).get(0)).intValue()+"元" );

				} catch (Exception e2) {
					// TODO: handle exception
					Cost.setText("0");
					System.out.println("没有数据");
				}
				System.out.println(sqlsql);
				
			}
		});
		btn_search.setBounds(133, 16, 66, 23);
		panel_1.add(btn_search);
		
		JLabel label = new JLabel("总价：");
		label.setBounds(224, 20, 54, 15);
		panel_1.add(label);
		
		Cost = new JTextField();
		Cost.setEditable(false);
		Cost.setBounds(264, 17, 66, 21);
		panel_1.add(Cost);
		Cost.setColumns(10);
		
		
//		model_consume = RO.getTableModel(Define.Consume_columnNames, sqlsql);					//该滚滚滚滚滚滚滚滚
//		sorter = new TableRowSorter(model_consume);  					//该滚滚滚滚滚滚滚滚
		
		JPanel panel_2 = new JPanel();
		table = new JTable();
//		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
//		ListSelectionModel cellSelectionModel = table.getSelectionModel();
//		table.setModel(model_consume);
//		table.setRowSorter(sorter); 
//		
		
		panel_2.setBounds(10, 60, 504, 331);
		panel.add(panel_2);
		panel_2.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 10, 504, 321);
		panel_2.add(scrollPane);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
	}
}
