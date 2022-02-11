package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 메타코딩
 *  플레이어는 좌우 이동이 가능하다.
 *  점프가 가능하다.
 *  방울 발사 (나중에 생각하자)
 */

public class Player extends JLabel{
	
	private int x;
	private int y;
	private ImageIcon playerR, playerL;
	
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // 점프 상태 (up, down)
	
	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;
	
	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
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

	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}
	
	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌
		
		isRight = false;
		isLeft = false;
		isJump = false;
	}
	
	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽 이동");
		
		new Thread(()->{
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
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		
		new Thread(()->{
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
	
	// 키보드 윗방향키
	public void jump() {
		System.out.println("점프");
		isJump = true;		
		// 점프는 for문을 돌려야 되요.
		// up 일때는 sleep(5) -> for
		
		// 2초라면
		new Thread(()->{
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
			
			// down
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			isJump = false;
		}).start();

		// down 일때는 sleep(3) -> for		
	}

}
