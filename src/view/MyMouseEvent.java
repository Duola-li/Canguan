package view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import util.Define;

public class MyMouseEvent extends MouseAdapter{
	/*
	 * (non-Javadoc)
	 * 为实体选座位弄得鼠标监听类
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	//label_table[i].addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		int num=-1;				
		JLabel tempLabel = (JLabel) e.getSource();
		for(int i=0; i<Define.Table_NUM; i++){
			if(tempLabel == Choose_Table.label_table[i]){
				num = i;
				break;
			}
		}
		//JOptionPane.showMessageDialog(null,"确定要预定此桌并点菜吗","提示",JOptionPane.INFORMATION_MESSAGE);
		int choose=JOptionPane.showConfirmDialog(null, "在此("+num+"号桌)就餐？","提示", JOptionPane.YES_NO_OPTION);
			if(choose==JOptionPane.OK_OPTION){
				System.out.println("修改保存了");
				JF_Welcome.frame2 = new Diancai(num);
				JF_Welcome.frame2.setVisible(true);
				JF_Welcome.frame.setVisible(false);
			}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		Toolkit kit2 = Toolkit.getDefaultToolkit();
		Image img=kit2.getImage("images/table/Mon1.png");
		Cursor cu=kit2.createCustomCursor(img,new Point(20,5),"choose");
		JF_Welcome.frame.setCursor(cu);//设置自己鼠标的图标
//		Cursor cu = new Cursor(Cursor.HAND_CURSOR);       
//		Choose_Table.frame.setCursor(cu);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Cursor cu = new Cursor(Cursor.DEFAULT_CURSOR);       
		JF_Welcome.frame.setCursor(cu);
	}


}
