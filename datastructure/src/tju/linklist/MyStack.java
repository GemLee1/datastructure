package tju.stack;
/**
 * @author GemLee
 * @version 1.0
 * Description �Լ�ʵ��һ��ջ���Ƚ����FILO����������Щ������ѹջ����ջ���пա��鿴ջ��Ԫ�ء�ջ��С��
 * created 2019/05/09
 * */

public class MyStack<AnyType> {
	//��ʼ��һ��ջ��ʹ������ʵ�֣�
	AnyType[] arr;
	//��ʼ��һ����ջ
	public MyStack() {
		arr = (AnyType[])new Object[0];
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return size() == 0;
	}
	//����ջ�Ĵ�С
	public int size() {
		return arr.length;
	}
	
	//ѹջ�����������ݷ��������У���ʵ��������Ԫ�ؾ���ѹջ����
	public void push(AnyType val) {
		AnyType[] newArr = (AnyType[]) new Object[arr.length + 1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		arr = newArr;
	}
	//�鿴ջ��Ԫ�أ�ֻ�ǲ鿴����Ҫ��ջ���в�����
	public AnyType look() {
		if(!isEmpty()) {
			return arr[arr.length - 1];
		}else {
			throw new RuntimeException("the stack is empty");
		}
	}
	
	//��ջ������������Ҫ�пգ�Ȼ����������ȡԪ�أ�
	public AnyType pop() {
		if(!isEmpty()) {
			AnyType[] newArr = (AnyType[])new Object[arr.length - 1];
			for(int i = 0;i < newArr.length;i++) {
				newArr[i] = arr[i];
			}
			AnyType count = arr[arr.length - 1];
			arr = newArr;
			return count;
		}else {
			throw new RuntimeException("the stack is empty");
		}
	}
	//��������ջ
	public void show() {
		if(!isEmpty()) {
			for(int i = arr.length-1;i >= 0;i--) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}else {
			throw new RuntimeException("the stack is empty");
		}
	}
	

}
