package site.metacoding.ex13;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


class ResponseDto {
	private int seq; // 코로나 감염자 수
}

class MyPanel extends JPanel{
	
	int x = 100;
	int y = 200;
	
	// JPanel 을 새로고침(다시 그린다)하는 것
	@Override
	protected void paintComponent(Graphics g) { // g 는 붓이다.
		super.paintComponent(g);
		System.out.println("패널 다시 그려짐");
		g.drawLine(10, 20, x, y);
	}
}

public class EventEx02 extends JFrame implements UserInterface{

	MyPanel myPanel;
	JLabel labelText;
	JButton btn1, btn2; // 200, 300으로 변경
	
	public EventEx02() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}
	
	@Override
	public void initSetting() {
		setSize(500, 500);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료
	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("첫글자");
		btn1 = new JButton("글자변경");
		btn2 = new JButton("그림변경");
	}

	@Override
	public void initAssign() {
		add(myPanel);
		myPanel.add(labelText);
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListener() {
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// setText 메서드는 부분 변경!!
				labelText.setText("두번째글자"); // setText 메서드는 내부에 paintComponent를 재호출해준다.
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30;
				
				System.out.println(myPanel.x);
				System.out.println(myPanel.y);
				
				myPanel.repaint();
			}
		});
	}
	
	public static void main(String[] args) {
		new EventEx02();
	}

}
