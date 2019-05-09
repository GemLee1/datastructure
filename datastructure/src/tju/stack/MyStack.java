package tju.stack;
/**
 * @author GemLee
 * @version 1.0
 * Description 自己实现一个栈（先进后出FILO），包括这些操作：压栈、出栈、判空、查看栈顶元素、栈大小；
 * created 2019/05/09
 * */

public class MyStack<AnyType> {
	//初始化一个栈，使用数组实现；
	AnyType[] arr;
	//初始化一个空栈
	public MyStack() {
		arr = (AnyType[])new Object[0];
	}
	//判断栈是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	//返回栈的大小
	public int size() {
		return arr.length;
	}
	
	//压栈操作，把数据放在数组中，其实数组增加元素就是压栈过程
	public void push(AnyType val) {
		AnyType[] newArr = (AnyType[]) new Object[arr.length + 1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		arr = newArr;
	}
	//查看栈顶元素，只是查看不需要对栈进行操作；
	public AnyType look() {
		if(!isEmpty()) {
			return arr[arr.length - 1];
		}else {
			throw new RuntimeException("the stack is empty");
		}
	}
	
	//出栈操作，首先需要判空，然后从数组最后取元素；
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
	//遍历整个栈
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
