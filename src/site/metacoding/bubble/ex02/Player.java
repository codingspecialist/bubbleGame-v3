package site.metacoding.bubble.ex02;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ��Ÿ�ڵ�
 *  �÷��̾�� �¿� �̵��� �����ϴ�.
 *  ������ �����ϴ�.
 *  ��� �߻� (���߿� ��������)
 */

public class Player extends JLabel{
	
	private int x;
	private int y;
	private ImageIcon playerR;
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
	}
	
	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������
	}
	

}
