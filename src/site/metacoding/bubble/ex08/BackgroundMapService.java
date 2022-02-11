package site.metacoding.bubble.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다)
public class BackgroundMapService implements Runnable {

	// 컴포지션
	private Player player;
	private BufferedImage image;

	// 컴포지션을 위한 기술 => 의존성 주입 (생성자를 통해서 주입) = DI (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw 하게 읽는 다는 뜻 : 낡것 그대로 읽는 것
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			// System.out.println("leftColor : "+leftColor);
			// System.out.println("rightColor : "+rightColor);
			// System.out.println(image.getRGB(player.getX(), player.getY()+50+5));
			
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
					+ image.getRGB(player.getX()+50 - 10, player.getY() + 50 + 5); // -1

			if(bottomColor != -2) { // 바텀 충돌 상태
				player.setDown(false);
			} else if(bottomColor == -2) { // 바텀이 흰색이면 down 호출
				//System.out.println("바닥 흰색인데?");
				if(player.isDown() == false && player.isUp() == false) {
					player.down();
				}
			}
			
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				//System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				//System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setRightWallCrash(false);
				player.setLeftWallCrash(false);
			}

			try {
				Thread.sleep(10); // 10/1000 -> 0.01초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
