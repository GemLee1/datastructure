package tju.chapter3;

import org.junit.jupiter.api.Test;

public class ListDemo1 {
	
	@Test
	/**
	 * ��ļ�����ʵ��
	 * ����ʵ�֣�������죬�����޸ģ������ɾ�����Ƚ��鷳
	 * */
	public void listArr() {
		//�������飬���ҳ�ʼ��
		int[] arr = new int[10];
		System.out.println("arr����Ԫ��Ϊ��");
		for(int i = 0;i < arr.length;i++) {
			arr[i] = i*i; 
			System.out.print(arr[i] + " ");
		}
		//�������ݳ�����
		int [] newArr = new int[arr.length*2];
		System.out.println();
		System.out.println("newArr����Ԫ��Ϊ��");
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
			System.out.print(newArr[i] + " ");
		}
		arr = newArr;
		System.out.println();
		System.out.println("�޸ĺ��arrԪ��Ϊ��");
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
