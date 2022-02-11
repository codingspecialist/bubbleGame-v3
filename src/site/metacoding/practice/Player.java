package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

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

	private static final String TAG = "Player : ";

	// ��������
	private BackgroundMap backgroundMap;
	
	private ImageIcon playerR, playerL;
	private int x, y;

	private boolean isLeft, isRight, isUp, isDown;
	private boolean leftWallCrash, rightWallCrash;

	public Player(BackgroundMap backgroundMap) {
		this.backgroundMap = backgroundMap;
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");

		x = 70;
		y = 535; 
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // JLabel�� ��ġ

		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
	}
	
	// left(), right(), down()
	private void �ٴ��浹����() {
		// System.out.println(TAG+"�ٴ��浹�����");
		int bottomColor = backgroundMap.getImage().getRGB(getX() + 10, getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(getX()+50 - 10, getY() + 50 + 5); // -1
		
		if(bottomColor == -2) { // �ٴ��� ���
			System.out.println("�ٴ��� ����̿���.");
			if(!isUp && !isDown) down(); // �� �ٿ� ���°� �ƴҶ�
		}else if(bottomColor != -2) { // �ٴڿ� ��ֹ��� �ִٴ� ��
			System.out.println("�ٴڿ� ��ֹ��� �־��.");
			isDown = false;
		}
	}
	
	private void ���ʺ��浹����() {
		//System.out.println(TAG+"�����浹�����");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(getX() - 10, getY() + 25));
		
		if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			System.out.println(TAG+"���ʺ��� �浹�߾��");
			leftWallCrash = true;
			isLeft = false;
		}
	}
	
	private void �����ʺ��浹����() {
		//System.out.println(TAG+"�������浹�����");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(getX() + 50 + 15, getY() + 25));
		
		if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			System.out.println(TAG+"�����ʺ��� �浹�߾��");
			rightWallCrash = true;
			isRight = false;
		}
	}

	@Override
	public void left() {
		System.out.println(TAG + "left()");
		isLeft = true;
		rightWallCrash = false;
		setIcon(playerL);

		new Thread(() -> {
			try {
				while (isLeft) {
					x = x - 4;
					setLocation(x, y); // paintComponent()�� �ڵ� ȣ�����ش�. ���������� repaint�� �ȴ�.
					Thread.sleep(10);
					
					���ʺ��浹����();
					�ٴ��浹����();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();
	}

	@Override
	public void right() {
		System.out.println(TAG + "right()");
		isRight = true;
		leftWallCrash = false;
		setIcon(playerR);

		new Thread(() -> {
			try {
				while (isRight) {
					x = x + 4;
					setLocation(x, y); // paintComponent()�� �ڵ� ȣ�����ش�. ���������� repaint�� �ȴ�.
					Thread.sleep(10);
					
					�����ʺ��浹����();
					�ٴ��浹����();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

	} // �̰� ����� �� paintComponent() -> repaint() ȣ���.

	@Override
	public void up() {
		System.out.println(TAG + "up()");
		isUp = true;
		new Thread(()->{
			for(int i=0; i<130/2; i++) {
				y = y - 2;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			isUp = false;
			down();
			
		}).start();
	}

	@Override
	public void down() {
		System.out.println(TAG + "down()");
		isDown = true;
		new Thread(()->{
			while(isDown) {
				y = y + 2;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				�ٴ��浹����();
			}

		}).start();
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

}
