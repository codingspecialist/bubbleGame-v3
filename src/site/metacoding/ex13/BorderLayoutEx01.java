package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

public class BorderLayoutEx01 extends MyFrame{

	public BorderLayoutEx01() {
		super(1000, 600);
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout()); // ��������!! ����Ʈ�� BorderLayout �̴ϱ�!!
		
		JButton btnNorth = new JButton("����");
		JButton btnEast = new JButton("����");
		JButton btnWest = new JButton("����");
		JButton btnSouth = new JButton("����");
		JButton btnCenter = new JButton("���");
		
//		panel.add(btnNorth, BorderConstant.NORTH);
//		panel.add(btnEast, BorderConstant.EAST);
//		panel.add(btnWest, BorderConstant.WEST);
//		panel.add(btnSouth, BorderConstant.SOUTH);
//		panel.add(btnCenter, BorderConstant.CENTER);
		
		panel.add(btnNorth, BorderLayout.NORTH);
		//panel.add(btnEast, BorderLayout.EAST);
		panel.add(btnWest, BorderLayout.WEST);
		//panel.add(btnSouth, BorderLayout.SOUTH);
		panel.add(btnCenter, BorderLayout.CENTER);
		
		setVisible(true); // paint �޼���
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx01();
	}

}
