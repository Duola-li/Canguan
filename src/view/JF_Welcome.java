package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ComonManage;
import util.Define;
import util.RetrieveObject;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_Welcome extends JFrame {
	public static Choose_Table frame;
	public static Diancai frame2;
	public static JF_Pay frame3;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_Welcome frame = new JF_Welcome();
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
	public JF_Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel background = new JLabel();
		Icon icon_table=new ImageIcon("images/main.png");
		background.setIcon(icon_table);
		
		contentPane.add(background, BorderLayout.CENTER);
		
		JButton Btn_over = new JButton("打卡下班");
		Btn_over.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 结束程序
				 */
				javax.swing.JOptionPane.showMessageDialog(null, "没到点就想下班？还想不想干了？", "系统提示",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		});

		Icon icon_begin=new ImageIcon("images/diancai.png");
		JButton Btn_begin = new JButton();
		Btn_begin.setIcon(icon_begin);
		Btn_begin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RetrieveObject RO = new RetrieveObject();
				frame = new Choose_Table(RO.getTableUsed());
				frame.setVisible(true);
				//setVisible(false);
				
			}
		});
		Icon icon_ok=new ImageIcon("images/jiezhang.png");
		JButton Btn_ok = new JButton();
		Btn_ok.setIcon(icon_ok);
		Btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RetrieveObject RO = new RetrieveObject();
				frame3 = new JF_Pay();
				frame3.setVisible(true);
				//setVisible(false);
				
			}
		});
		Btn_ok.setBounds(410,300,125,75);
		Btn_begin.setBounds(400, 200, 145, 75);
		Btn_over.setBounds(820, 570, 100, 30);

		background.add(Btn_begin);
		background.add(Btn_ok);
		background.add(Btn_over);
	}

}
