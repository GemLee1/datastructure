package tju.test;

import tju.array.MyArray;

/**
 * @author GemLee
 * @version 1.0
 * Description ������MyArray.java
 * */
public class MyArrayTest {
	public static void main(String[] args) {
		MyArray<Integer> arr = new MyArray<>();
		arr.add(22);
		arr.add(23);
		arr.add(24);
		arr.add(25);
		arr.add(26);
		//����
		//arr.show();
		System.out.println("=======================");
		arr.show2();
		
		//ɾ��
		System.out.println("=======================");
		arr.delete(3);
		arr.show2();
		
		//��С
		System.out.println(arr.size());
		
		//�滻ָ��λ��Ԫ��
		arr.set(3, 199);
		arr.show2();
		
		//��ȡָ��λ�õ�Ԫ��
		System.out.println(arr.get(2));
		
		//����Ԫ�ص�ָ��λ��
		arr.insert(3,188);
		arr.show2();
		
		//���Բ���
		System.out.println(arr.search(188));
		
		System.out.println(arr.BinarySearch(199));
	}

}
