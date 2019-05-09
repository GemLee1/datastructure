package tju.queue;

import java.util.Arrays;

/**
 * @author GemLee
 * @version 1.0
 * Description 自己实现一个队列（FIFO），包括入队，出队，判空和返回队列大小，查看队首元素；
 * 
 * */
public class MyQueue<AnyType> {
	//初始化一个数组
	AnyType [] arr;
	public MyQueue() {
		arr = (AnyType[])new Object[0];
	}
	//判断队列的大小
	public int size() {
		return arr.length;
	}
	//判断队列是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	//入队操作；
	public void pullIn(AnyType val) {
		AnyType[] newArr = (AnyType[])new Object[arr.length + 1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		arr = newArr;
	}
	//出队操作
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
	//查看队首元素
	public void look() {
		if(!isEmpty()) {
			System.out.println(arr[0]);
		}
	}
	//队列遍历
	public void show() {
		System.out.println(Arrays.toString(arr));
	}
}
