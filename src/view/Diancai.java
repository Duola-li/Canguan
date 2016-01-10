package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;
import org.omg.CORBA.PUBLIC_MEMBER;

import util.Deal;
import util.Define;
import util.MyDTModel;
import util.RetrieveObject;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Diancai extends JFrame {

	static int oldnum = -1;
	static int Cost = 0; 
	static Vector vv = new Vector();
	
	public final static int YUDING = 0;//从0数，第4列是是否预定。
	public final static int PRICE = 4;
	private JPanel contentPane;
	private JTable table;
	private JTextField shuliang;
	private JTextField zongjia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diancai frame = new Diancai(0);
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
	public Diancai(final int Num) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				JF_Welcome.frame2.oldnum = -1;
				JF_Welcome.frame2.Cost = 0;
				JF_Welcome.frame2.vv.removeAllElements();
			}
		});
		setBackground(Color.LIGHT_GRAY);
		setTitle("点菜");
		setForeground(Color.RED);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JPanel panel_table = new JPanel();
		panel_table.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u83DC\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_table.setBounds(0, 10, 400, 381);
		panel.add(panel_table);
		panel_table.setLayout(new BoxLayout(panel_table, BoxLayout.X_AXIS));
		//panel_table.setVisible(false);
		
		table = new JTable();
		table.setCellSelectionEnabled(false);//设置此表是否允许同时存在行选择和列选择。
		ListSelectionModel cellSelectionModel = table.getSelectionModel(); 
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		
		//panel_table.add(table);
		/*
		 * 排序的东西
		 * 
		 */
		System.out.println("ss");
		RetrieveObject RO = new RetrieveObject();
		MyDTModel ml = RO.getCaiTableModel(Define.Cai_columnNames, "select * from menu");
		table.setModel(ml);
		//table.getColumn("选择").setCellEditor(new TableCellEditor(new JCheckBox ()));
		
		/*
		 * 排序
		 */
		TableRowSorter sorter = new TableRowSorter(ml);  
		table.setRowSorter(sorter); 
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		panel_table.add(scrollPane);
		
		JPanel panel_right = new JPanel();
		panel_right.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_right.setBounds(410, 10, 264, 381);
		panel.add(panel_right);
		panel_right.setLayout(null);
		
		final JLabel cai = new JLabel("菜品图片");
		ImageIcon image = new ImageIcon(".\\images\\1000.jpg");
		image.setImage(image.getImage().getScaledInstance(240,160,Image.SCALE_DEFAULT)); 
		cai.setIcon(image);
		cai.setBounds(10, 10, 244, 162);
		panel_right.add(cai);
		
		JLabel label = new JLabel("总  价：");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(20, 243, 72, 27);
		panel_right.add(label);
		
		JLabel label_1 = new JLabel("数  量：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(20, 207, 72, 27);
		panel_right.add(label_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setForeground(Color.RED);
		horizontalGlue.setBounds(0, 182, 254, 27);
		panel_right.add(horizontalGlue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setForeground(Color.RED);
		horizontalGlue_1.setBounds(0, 290, 254, 27);
		panel_right.add(horizontalGlue_1);
		
		JButton button = new JButton("提交订单");
		button.setForeground(Color.GREEN);
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBounds(72, 322, 114, 36);
		panel_right.add(button);
		
		shuliang = new JTextField();
		shuliang.setEditable(false);
		shuliang.setBounds(97, 209, 114, 27);
		panel_right.add(shuliang);
		shuliang.setColumns(10);
		
		zongjia = new JTextField();
		zongjia.setEditable(false);
		zongjia.setColumns(10);
		zongjia.setBounds(97, 245, 114, 27);
		panel_right.add(zongjia);
		
		
		/*
		 * 监听动作
		 */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String selectedData = null;  
                int[] selectedRow = table.getSelectedRows();//被选择的行  
                int[] selectedColumns = table.getSelectedColumns();//被选择的列  
                if (selectedRow.length != 0){//有选择
                	int row = selectedRow[0];
                	int column = selectedColumns[0];
                	
                	/*
                	 * 测试输出
                	 */
              	  	selectedData = table.getValueAt(row, column).toString();  
              	  	System.out.println(selectedRow[0]+":"+selectedColumns[0]+"选择的: " + selectedData);
              	  	
              	  	/*
              	  	 * 下面是每点一次新行，刷新一下图标
              	  	 */
              	  	int Cnum = (int) table.getValueAt(row, Define.Model_Cnum);//拿到序号
              	  	if(Cnum != oldnum)//新的行
              	  	{
              	  		oldnum = Cnum;
              	  		String ico = ".\\images\\cai\\"+ Cnum +".jpg";
              	  		System.out.println(ico);
              	  		ImageIcon image = new ImageIcon(ico);
              	  		image.setImage(image.getImage().getScaledInstance(240,160,Image.SCALE_DEFAULT));
              	  		cai.setIcon(image);
              	  	}
              	  	
              	  	/*
              	  	 * 下面是如果点菜，则改变价格，数量，点菜集合
              	  	 */
              	  	if(column == YUDING)
              	  	{
              	  		if( (boolean) table.getValueAt(row, YUDING) )//真，预定
              	  		{
              	  			vv.add(Cnum);//存菜号。
              	  			Cost += (int) table.getValueAt(row, PRICE);
              	  		}else{
              	  			if(vv.contains(Cnum)){
              	  			//System.out.println("sss");//调试代码
              	  				vv.remove((Object)Cnum);                  	  
              	  				Cost -= (int) table.getValueAt(row, PRICE);                  	 
              	  			}              
              	  		}
              	  		zongjia.setText(String.valueOf(Cost));
              	  		shuliang.setText( Integer.toString(vv.size()) );
              	  	}
              	  	
              	  	
              	//结束监听动作
                }
			}
		});
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
  	  			System.out.println("按了按钮！！");
  	  			//panel_table.setVisible(true);
  	  			//dialogTest jun = new dialogTest();
  	  			//jun.woo();
  	  			if(vv.size()==0)
  	  			{
  	  				JOptionPane.showMessageDialog(null,"对不起，订单为空！","提示",JOptionPane. INFORMATION_MESSAGE);
  	  				return;
  	  			}
  	  			
  	  			int i=JOptionPane.showConfirmDialog(null, "完成点菜？","提示", JOptionPane.YES_NO_OPTION);
  	  			if(i==JOptionPane.OK_OPTION){
  	  				System.out.println("打印了");
  	  				/*
  	  				 * 应该写个函数，把点的菜，vacter和桌号发过去，然后插入数据库，分配厨师做菜，服务员上菜等。
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
  	  				 */
  	  				Deal.Order(Num, vv);
  	  			JOptionPane.showMessageDialog(null,"恭喜，订单成功！","提示",JOptionPane. INFORMATION_MESSAGE);
  	  			JF_Welcome.frame2.setVisible(false);
  	  			}else{
  	  				System.out.println("没打印");
  	  				//重新点，不用干啥。
  	  			}
			}
		});
	}
}
