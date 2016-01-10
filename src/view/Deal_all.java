package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class Deal_all extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deal_all frame = new Deal_all(1111);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Deal_all(int Num) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JP_cai panel_cai = new JP_cai();
		tabbedPane.addTab("菜 单", null, panel_cai, null);
		
		JP_chief panel_Chief = new JP_chief();
		tabbedPane.addTab("厨 师", null, panel_Chief, null);
		
		JP_waiter panel_waiter = new JP_waiter();
		tabbedPane.addTab("服务员", null, panel_waiter, null);
		
		JP_table panel_table = new JP_table();
		tabbedPane.addTab("餐桌", null, panel_table, null);
		setVisible(true);
	}

}
