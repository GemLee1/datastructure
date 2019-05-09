package tju.queue;

import java.util.Arrays;

/**
 * @author GemLee
 * @version 1.0
 * Description �Լ�ʵ��һ�����У�FIFO����������ӣ����ӣ��пպͷ��ض��д�С���鿴����Ԫ�أ�
 * 
 * */
public class MyQueue<AnyType> {
	//��ʼ��һ������
	AnyType [] arr;
	public MyQueue() {
		arr = (AnyType[])new Object[0];
	}
	//�ж϶��еĴ�С
	public int size() {
		return arr.length;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return size() == 0;
	}
	//��Ӳ�����
	public void pullIn(AnyType val) {
		AnyType[] newArr = (AnyType[])new Object[arr.length + 1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		arr = newArr;
	}
	//���Ӳ���
	public AnyType pullOut() {
		if(!isEmpty()) {
			AnyType[] newArr = (AnyType[])new Object[arr.length - 1];
			for(int i = 0;i < newArr.length;i++) {
				newArr[i] = arr[i + 1];
			}
			AnyType count = arr[0];
			arr = newArr;
			return count;
		}else {
			throw new RuntimeException("the queue is empty");
		}
	}
	//�鿴����Ԫ��
	public void look() {
		if(!isEmpty()) {
			System.out.println(arr[0]);
		}
	}
	//���б���
	public void show() {
		System.out.println(Arrays.toString(arr));
	}
}
