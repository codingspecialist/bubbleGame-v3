package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Ctrl + Shift + F
// Ctrl + Shift + O
public class MyFrame extends JFrame {
	public MyFrame() {
		super(); // �����Ǿ� ����.
		System.out.println("MyFrame ����Ʈ");
		setSize(600, 400); // w, h
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� main ����
	}
	
	public MyFrame(int w, int h) {
		super(); // �����Ǿ� ����.
		System.out.println("MyFrame �����ε��� ������");
		setSize(w, h); // w, h
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� main ����
	}
}
