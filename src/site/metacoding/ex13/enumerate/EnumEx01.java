package site.metacoding.ex13.enumerate;

// �������̽��� ������ public static final �� �����Ǿ� �ִ�.
interface Direction {
	String LEFT = "Left";
	String RIGHT = "Right";
}

public class EnumEx01 {
	
	public static void add(String direction) {
		// "Left" , "Right"

		if(direction.equals("Left") || direction.equals("Right")) {
			System.out.println("�ߵ��Ա�");
		}else {
			System.out.println("�� �߸��Է��߾�");
		}
	}

	public static void main(String[] args) {
		add("RIGHT");
	}

}
