package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel{
	
	private ImageIcon backgroundMap; // ���� ���̴� ��
	private BufferedImage image; // ���� �Ⱥ��̴� ����
	
	public BackgroundMap() {
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		backgroundMap = new ImageIcon("image/backgroundMap.png");
		setIcon(backgroundMap); // Div �ڽ��� �̹��� �ֱ�
	}

	public ImageIcon getBackgroundMap() {
		return backgroundMap;
	}

	public void setBackgroundMap(ImageIcon backgroundMap) {
		this.backgroundMap = backgroundMap;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
}
