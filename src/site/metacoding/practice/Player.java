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

	// 컴포지션
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
		setLocation(x, y); // JLabel의 위치

		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
	}
	
	// left(), right(), down()
	private void 바닥충돌감지() {
		// System.out.println(TAG+"바닥충돌계산중");
		int bottomColor = backgroundMap.getImage().getRGB(getX() + 10, getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(getX()+50 - 10, getY() + 50 + 5); // -1
		
		if(bottomColor == -2) { // 바닥이 흰색
			System.out.println("바닥이 흰색이에요.");
			if(!isUp && !isDown) down(); // 업 다운 상태가 아닐때
		}else if(bottomColor != -2) { // 바닥에 장애물이 있다는 것
			System.out.println("바닥에 장애물이 있어요.");
			isDown = false;
		}
	}
	
	private void 왼쪽벽충돌감지() {
		//System.out.println(TAG+"왼쪽충돌계산중");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(getX() - 10, getY() + 25));
		
		if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			System.out.println(TAG+"왼쪽벽에 충돌했어요");
			leftWallCrash = true;
			isLeft = false;
		}
	}
	
	private void 오른쪽벽충돌감지() {
		//System.out.println(TAG+"오른쪽충돌계산중");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(getX() + 50 + 15, getY() + 25));
		
		if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			System.out.println(TAG+"오른쪽벽에 충돌했어요");
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
					setLocation(x, y); // paintComponent()를 자동 호출해준다. 내부적으로 repaint가 된다.
					Thread.sleep(10);
					
					왼쪽벽충돌감지();
					바닥충돌감지();
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
					setLocation(x, y); // paintComponent()를 자동 호출해준다. 내부적으로 repaint가 된다.
					Thread.sleep(10);
					
					오른쪽벽충돌감지();
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

	} // 이게 종료될 때 paintComponent() -> repaint() 호출됨.

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
				바닥충돌감지();
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
