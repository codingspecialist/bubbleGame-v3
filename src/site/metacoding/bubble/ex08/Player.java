package site.metacoding.bubble.ex08;

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
	
	private BubbleFrame context;
	private int x;
	private int y;
	private ImageIcon playerR, playerL;
	
	private boolean isRight;
	private boolean isLeft;
	private boolean up; // ���� ���� (up, down)
	private boolean down;
	
	private int direction; // -1 �� ���� ����, 1�� ������ ����, 0 ���� ����
	
	
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;
	
	
	
	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player(BubbleFrame context) {
		this.context = context;
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}
	
	private void initSetting() {
		x = 90;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������
		
		isRight = false;
		isLeft = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
		
		direction = 0; // ���� ����
	}
	
	public void attack() {
		// 1. ���� new
		Bubble bubble = new Bubble(context);
		// 2. ȭ�鿡 �ٿ��� �� ? 
		context.add(bubble);
	    // 3. �����̵� (�÷��̾� ����)
	}
	
	public void left() {
		direction = -1;
		isLeft = true;
		setIcon(playerL);
		System.out.println("���� �̵�");
		
		new Thread(()->{
			
			// �� ���� Ȯ�� - ����
			while(isLeft) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void right() {
		direction = 1;
		isRight = true;
		setIcon(playerR);
		System.out.println("������ �̵�");
		
		new Thread(()->{
			
			// �� ���� Ȯ�� - ����
			while(isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void up() {
		System.out.println("��");
		up = true;		
		// ������ for���� ������ �ǿ�.
		// up �϶��� sleep(5) -> for
		
		// 2�ʶ��
		new Thread(()->{
			
			// �� ���� Ȯ�� - ����
			// up
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			up = false;
			down();
		}).start();
		// down �϶��� sleep(3) -> for		
	}
	
	public void down() {
		System.out.println("�ٿ�");
		down = true;		
		// ������ for���� ������ �ǿ�.
		// up �϶��� sleep(5) -> for
		
		// 2�ʶ��
		new Thread(()->{	
			
			// �� ���� Ȯ�� - ����
			
			// down
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();

		// down �϶��� sleep(3) -> for		
	}

}
