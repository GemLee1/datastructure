package tju.chapter3;

import java.util.Arrays;

/**
 * @author GemLee
 * @version 1.0
 * created 2019/04/26
 * Description 使用数组来实现一个顺序栈，这个过程参见数据结构与算法分析
 * Operation 有两个方法，一个是pop(),一个是push()
 * 这个方法不好，有空值，输出不友善，需要改进
 * */

public class SequenceStack<AnyType> {
	//stack的数组形式
	private Object [] stack;
	//stack的默认容量，可以使用数组扩容
	private int maxSize;
	//stack 指针
	private int top;
	//空参构造器,如果不指定，就调用有参构造器，初始化值为10;
	public SequenceStack() {
		this(10);
	}
	//构造初始化；
	public SequenceStack(int maxSize) {
		
		this.maxSize = maxSize;
		this.stack = new Object[maxSize];
		top = -1;
	}
	
	//判断栈是否为空栈
	public boolean Empty() {
		return top == -1;
	}
	//压栈之前判断是不是栈满了
	public void push (AnyType t)  {
		if(top == maxSize - 1) {
			throw new RuntimeException("栈已满");
		}
		stack[++top] = t;
	}
	//出栈，出栈之前先判断是不是栈为空；
	public AnyType pop() {
		if(top == -1) {
			throw new RuntimeException("栈为空");
		}
		
		AnyType t = (AnyType) stack[top];
		stack[top--] = null;
		return t;
	}
	//重写toString()方法，输出栈中元素；
	public String toString() {
		return Arrays.toString(stack);
	}
	
}
