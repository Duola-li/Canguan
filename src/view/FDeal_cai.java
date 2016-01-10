package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FDeal_cai extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FDeal_cai frame = new FDeal_cai();
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
	public FDeal_cai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Deal_cai_panel = new JPanel();
		contentPane.add(Deal_cai_panel, BorderLayout.CENTER);
		Deal_cai_panel.setLayout(null);
		
		JPanel up_panel = new JPanel();
		up_panel.setBounds(0, 0, 674, 265);
		Deal_cai_panel.add(up_panel);

		MyTableModel ml = new MyTableModel();
		TableRowSorter sorter = new TableRowSorter(ml);  
		
		table = new JTable();
		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		up_panel.setLayout(new BorderLayout(0, 0));
		table.setModel(ml);
		table.setRowSorter(sorter); 
		
		JScrollPane scrollPane = new JScrollPane(table);
		up_panel.add(scrollPane);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		
		//panel_table.add(table);
		/*
		 * 排序的东西
		 * 
		 */
		
		
		JPanel south_panel = new JPanel();
		south_panel.setBounds(0, 265, 674, 136);
		south_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Deal_cai_panel.add(south_panel);
		south_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 10, 40, 22);
		south_panel.add(lblNewLabel);
		
		JLabel label = new JLabel("名字");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(287, 10, 40, 22);
		south_panel.add(label);
		
		JLabel label_1 = new JLabel("价格");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(287, 49, 40, 22);
		south_panel.add(label_1);
		
		JLabel label_2 = new JLabel("菜系");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(20, 49, 40, 22);
		south_panel.add(label_2);
		
		JLabel label_3 = new JLabel("编号");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(20, 89, 40, 22);
		south_panel.add(label_3);
		
		JLabel label_4 = new JLabel("其他");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(287, 89, 40, 22);
		south_panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(58, 7, 136, 30);
		south_panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(58, 46, 136, 30);
		south_panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(58, 86, 136, 30);
		south_panel.add(textField_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(337, 7, 136, 30);
		south_panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(337, 46, 136, 30);
		south_panel.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(337, 86, 136, 30);
		south_panel.add(textField_5);
		
		JButton buttonchange = new JButton("修 改");
		buttonchange.setFont(new Font("宋体", Font.BOLD, 16));
		buttonchange.setBounds(527, 10, 112, 38);
		south_panel.add(buttonchange);
		
		JButton buttondrop = new JButton("删 除");
		buttondrop.setFont(new Font("宋体", Font.BOLD, 16));
		buttondrop.setBounds(527, 73, 112, 38);
		south_panel.add(buttondrop);
	}
}
