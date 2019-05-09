package tju.array;

import java.util.Arrays;

/**
 * @author GemLee
 * @version 1.0
 * Description �Լ�ʵ��һ���ɱ����飬ʵ����������ӡ�ɾ������������С�жϡ���ȡĳ��Ԫ�ء�����һ��Ԫ�ص�ָ��λ�á��滻ָ��λ�õ�Ԫ�ء����Բ��ҺͶ��ַ����ң�
 * */

public class MyArray<AnyType> {
	//Ĭ�ϳ�ʼ��һ������
	AnyType[] arr;
	
	//�����ʼ��
	public MyArray() {
		arr = (AnyType[])new Object[0];
	}
	
	//�ж�����Ĵ�С
	public int size() {
		return arr.length;
	}
	
	//���������飬�Ѿ������ֵ��ֵ�������飬��������������һ��Ԫ�أ�
	public void add(AnyType val) {
		AnyType[] newArr = (AnyType[])new Object[arr.length+1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		arr = newArr;
	}
	
	//ɾ��ָ���Ǳ��Ԫ��
	public void delete(int index) {
		
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("�Ǳ�Խ���쳣");
		}
		
		AnyType[] newArr = (AnyType[])new Object[arr.length-1];
		for(int i = 0;i < newArr.length;i++) {
			if(i < index) {
				newArr[i] = arr[i];
			}else {
				newArr[i] = arr[i+1];
			}
		}
		arr = newArr;
	}
	
	//�������飻
	public void show() {
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public void show2() {
		System.out.println(Arrays.toString(arr));
	}
	
	//��ȡĳ��λ���ϵ�Ԫ��
	public AnyType get(int index) {
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("�Ǳ�Խ���쳣");
		}
		return arr[index];
	}
	
	//�滻ָ���Ǳ��Ԫ��ֵ��
	public void set(int index,AnyType val) {
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("�Ǳ�Խ���쳣");
		}
		arr[index] = val;
	}
	
	//��ָ���Ǳ�ĵط����Ԫ�أ�
	public void insert(int index,AnyType val) {
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("�Ǳ�Խ���쳣");
		}
		AnyType[] newArr = (AnyType[])new Object[arr.length+1];
		
		for(int i = 0;i < arr.length;i++) {
			if(i < index) {
				newArr[i] = arr[i];
			}else {
				newArr[i+1] = arr[i];
			}
		}
		newArr[index] = val;
		arr = newArr;
	}
	//���Բ���,�����������ͣ������ξ�����
	public int search(int val) {	
		int[] newArr = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = (int) arr[i];
		}
		for(int i = 0;i < arr.length;i++) {
			if(val == newArr[i]) {
				return i;
			}else {
				continue;
			}
		}
		return -1;
	}
	
	
	//���ַ�����,�����������������ͣ���������ң���˸�Ϊ������
	public int BinarySearch(int val) {
		int begin = 0;
		int end = arr.length - 1;
		int mid;
		int[] newArr = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = (int) arr[i];
		}
		while(begin <= end) {
			mid = (begin + end) / 2;
			if(newArr[mid] == val) {
				return mid;
			}else if(val > newArr[mid]) {
				begin = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
}
