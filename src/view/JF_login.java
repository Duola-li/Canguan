package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.KeyAdapter;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import com.mysql.jdbc.Statement;

import util.CommonaJdbc;

import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JF_login extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel1 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JPasswordField jPasswordField1 = new JPasswordField();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBlogin = new JButton();
    JButton jBexit = new JButton();
    JLabel jLabel3 = new JLabel();
    Border border1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
            Color.white, new Color(148, 145, 140));

    public JF_login() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(borderLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jLabel3.setForeground(Color.red);

        this.setResizable(false);
        this.setTitle("用户登录");
        jTextField1.addKeyListener(new JF_login_jTextField1_keyAdapter(this));
        jPanel1.setBorder(border1);
        jPasswordField1.addKeyListener(new JF_login_jPasswordField1_keyAdapter(this));
        jBexit.addActionListener(new JF_login_jBexit_actionAdapter(this));
        jBlogin.addActionListener(new JF_login_jBlogin_actionAdapter(this));
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jTextField1.setText("");
        jLabel2.setText("用户口令：");
        jPasswordField1.setText("");
        jPanel2.setLayout(flowLayout1);
        jBlogin.setText("登录");
        jBexit.setText("退出");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jLabel2);
        jPanel1.add(jPasswordField1);
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
        jPanel2.add(jLabel3);
        jPanel2.add(jBlogin);
        jPanel2.add(jBexit);
        jLabel1.setText("用户ID：");
        gridLayout1.setColumns(2);
        gridLayout1.setRows(2);
        jPanel1.setLayout(gridLayout1);
        this.setSize(360,140);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JF_login jf_login = new JF_login();
    }

    public void jTextField1_keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
        	//当输入完用户，检查是否存在该用户。
            String sqlSelect = null;
            sqlSelect = "Select username from login where userid = " + jTextField1.getText();
            CommonaJdbc conn = new CommonaJdbc();
	        try {
				Statement stmt = (Statement) conn.connection.createStatement();
				ResultSet res = stmt.executeQuery(sqlSelect);
			
				if (res.next()){
	                jLabel3.setText("当前用户姓名: " + String.valueOf(res.getString("username")) );
	                jPasswordField1.requestFocus();
	            }else{
	                javax.swing.JOptionPane.showMessageDialog(null,"输入的用户ID不存在，请重新输入!!!","系统提示"
	                        ,javax.swing.JOptionPane.ERROR_MESSAGE);
	                jTextField1.requestFocus();
	            }
	        	System.out.println("id:" + jTextField1.getText());
	
				res.close();
				stmt.close();
				conn.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    public void jPasswordField1_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
           ActionEvent login = new ActionEvent(jBlogin,0,null);
           jBlogin_actionPerformed(login);

        }
    }

    //退出
    public void jBexit_actionPerformed(ActionEvent e) {
        int result = javax.swing.JOptionPane.showOptionDialog(null,"是否退出系统登录?","系统提示",
                                  javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE,
                                  null,new String[]  {"是","否"},"否");
       if (result == javax.swing.JOptionPane.YES_OPTION) {
           System.exit(0);
       }

    }

    //登录
    public void jBlogin_actionPerformed(ActionEvent e) {
        	String pass = null;
           pass = String.valueOf(jPasswordField1.getPassword());
           //判断密码是否正确
           String sqlSelect = null;
           sqlSelect = "select password from login where userid = " + jTextField1.getText();
                   //+ " and password = '" + pass + "'";
           CommonaJdbc conn = new CommonaJdbc();
	        try {
				Statement stmt = (Statement) conn.connection.createStatement();
				ResultSet res = stmt.executeQuery(sqlSelect);
			
				if (res.next() && pass.equals(res.getString(1)) ){
					int Num = Integer.valueOf(jTextField1.getText());
					System.out.println(Num);
					if(Num < 10000){//管理员
						Deal_all frame = new Deal_all(Num);
					}else if(Num < 20000){//前台10000~20000
						JF_Welcome frame = new JF_Welcome();
						frame.setVisible(true);
					}else if(Num < 30000){//服务员20000~30000
						JF_Waiter frame = new JF_Waiter(Num);
						frame.setVisible(true);
					}else {//厨师30000-》
						JF_Chief frame = new JF_Chief(Num);
						frame.setVisible(true);
					}
		            this.setVisible(false);
	            }else{
	            	javax.swing.JOptionPane.showMessageDialog(null, "输入的口令不正确,请重新输入!!!", "系统提示",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
	            	jPasswordField1.requestFocus();
	            }
				System.out.println("password:"+pass);
	
				res.close();
				stmt.close();
				conn.connection.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    }
}

//监听类
class JF_login_jBlogin_actionAdapter implements ActionListener {
    private JF_login adaptee;
    JF_login_jBlogin_actionAdapter(JF_login adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jBlogin_actionPerformed(e);
    }
}


class JF_login_jPasswordField1_keyAdapter extends KeyAdapter {
    private JF_login adaptee;
    JF_login_jPasswordField1_keyAdapter(JF_login adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.jPasswordField1_keyPressed(e);
    }
}


class JF_login_jBexit_actionAdapter implements ActionListener {
    private JF_login adaptee;
    JF_login_jBexit_actionAdapter(JF_login adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jBexit_actionPerformed(e);
    }
}


class JF_login_jTextField1_keyAdapter extends KeyAdapter {
    private JF_login adaptee;
    JF_login_jTextField1_keyAdapter(JF_login adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent keyEvent) {
        adaptee.jTextField1_keyPressed(keyEvent);
    }
}
