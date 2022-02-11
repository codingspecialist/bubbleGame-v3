package site.metacoding.bubble.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��� ���� (�������� ������� ������ �Ѵ�)
public class BackgroundMapService implements Runnable {

	// ��������
	private Player player;
	private BufferedImage image;

	// ���������� ���� ��� => ������ ���� (�����ڸ� ���ؼ� ����) = DI (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw �ϰ� �д� �ٴ� �� : ���� �״�� �д� ��
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// ���� Ȯ��
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			// System.out.println("leftColor : "+leftColor);
			// System.out.println("rightColor : "+rightColor);
			// System.out.println(image.getRGB(player.getX(), player.getY()+50+5));
			
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
					+ image.getRGB(player.getX()+50 - 10, player.getY() + 50 + 5); // -1

			if(bottomColor != -2) { // ���� �浹 ����
				player.setDown(false);
			} else if(bottomColor == -2) { // ������ ����̸� down ȣ��
				//System.out.println("�ٴ� ����ε�?");
				if(player.isDown() == false && player.isUp() == false) {
					player.down();
				}
			}
			
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				//System.out.println("���� ���� �浹��");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				//System.out.println("������ ���� �浹��");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setRightWallCrash(false);
				player.setLeftWallCrash(false);
			}

			try {
				Thread.sleep(10); // 10/1000 -> 0.01��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
