package site.metacoding.practice;

/**
 * 
 * @author ������
 *  ������ ���� ����~~~~~~~~~~~~~~~~~~~~
 *  initObject 1�� ����
 *  initSetting 2�� ����
 *  initListener 3�� ���� (default)
 */

public interface Init {
	void initObject();
	void initSetting();
	default void initListener() {};
}
