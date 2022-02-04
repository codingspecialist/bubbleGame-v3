package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

// Ctrl + F11
public class FlowLayoutEx01 extends MyFrame{

	public FlowLayoutEx01() {
		super(300,300); // �����Ǿ� ����.
		System.out.println("FlowLayoutEx01");
		JPanel panel = (JPanel) getContentPane(); // JFrame�� �г� ��������
		panel.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("��ư1");
		JButton btn2 = new JButton("��ư2");
		JButton btn3 = new JButton("��ư3");
		JButton btn4 = new JButton("��ư4");
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		setVisible(true); // �׸� �׸���
	}

	public static void main(String[] args) {
		FlowLayoutEx01 mf = new FlowLayoutEx01();
	}

}
