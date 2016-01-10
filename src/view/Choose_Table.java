package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.Define;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Choose_Table extends JFrame {

	public static Choose_Table frame;
	private JPanel contentPane;
	public static JTextField textField;
	//public static JLabel background;
	public static JLabel[] label_table = new JLabel[5];
	public static int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Choose_Table(Define.test_Tables);
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
	public Choose_Table(boolean[] Tables_used) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i = -1;
		setBounds(200, 10, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*
		 * 背景标签初始话
		 */
		JLabel background = new JLabel();
		Icon icon_table=new ImageIcon("images/table/table.jpg");
		background.setIcon(icon_table);
		
		/*
		 * 一个坐标提示和六个桌子标签
		 */
		textField = new JTextField();
		textField.setVisible(false);
		textField.addMouseListener(new MyMouseEvent());
//		textField.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
		textField.setBounds(45, 262, 176, 38);
		//panel.add(textField);
		textField.setColumns(10);
		
		for(i=0; i<Define.Table_NUM; i++){
			label_table[i] = new JLabel();		//一样的用循环，坐标不一样
			
			if(Tables_used[i]){//已经被占用 则按比例缩放图片，否则添加动作
				ImageIcon icon_temp=new ImageIcon("images/table/ok1.png");
				icon_temp.setImage(icon_temp.getImage().getScaledInstance(200-i*Define.PEOPLE_SCALE,200-i*Define.PEOPLE_SCALE,Image.SCALE_DEFAULT));
				label_table[i].setIcon(icon_temp);
			}else {
				System.out.println(i);
				label_table[i].addMouseListener(new MyMouseEvent());
			}
			background.add(label_table[i]);
		}
		label_table[0].setBounds(150, 350, 200, 200);
		label_table[1].setBounds(780, 500, 200, 200);
		label_table[2].setBounds(820, 360, 200, 140);
		label_table[3].setBounds(420, 300, 200, 200);
		label_table[4].setBounds(650, 230, 200, 200);

				
		/*
		 * 组件整合，装入容器
		 */
		background.add(textField);
		background.add(label_table[0]);
		background.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int x=e.getX();
		        int y=e.getY();
		        String s = "坐标:"+x+','+y;
		        textField.setText(s);
//		        if(x>190 && x<210 && y<160 && y>140){
//					JOptionPane.showMessageDialog(null,"点点的","提示",JOptionPane.INFORMATION_MESSAGE);
//					ImageIcon icon=new ImageIcon("images/table/ok.png");
//					icon.setImage(icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); 
//					btnNewButton.setIcon(icon);
//		        }
			}
		});
		contentPane.add(background, BorderLayout.CENTER);
	}

}
//class MyMouseEvent extends MouseAdapter{
//	
//		//label_table[i].addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int num=-1;				
//				JLabel tempLabel = (JLabel) e.getSource();
//				for(int i=0; i<Define.Table_NUM; i++){
//					if(tempLabel == Choose_Table.label_table[i]){
//						num = i;
//						break;
//					}
//				}
//				//JOptionPane.showMessageDialog(null,"确定要预定此桌并点菜吗","提示",JOptionPane.INFORMATION_MESSAGE);
//				int choose=JOptionPane.showConfirmDialog(null, "在此("+num+"号桌)就餐？","提示", JOptionPane.YES_NO_OPTION);
//  	  			if(choose==JOptionPane.OK_OPTION){
//  	  				System.out.println("修改保存了");
//  	  			}
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Toolkit kit2 = Toolkit.getDefaultToolkit();
//				Image img=kit2.getImage("images/table/Mon1.png");
//				Cursor cu=kit2.createCustomCursor(img,new Point(20,5),"choose");
//				Choose_Table.frame.setCursor(cu);//设置自己鼠标的图标
////				Cursor cu = new Cursor(Cursor.HAND_CURSOR);       
////				Choose_Table.frame.setCursor(cu);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				Cursor cu = new Cursor(Cursor.DEFAULT_CURSOR);       
//				Choose_Table.frame.setCursor(cu);
//			}
//
//}
