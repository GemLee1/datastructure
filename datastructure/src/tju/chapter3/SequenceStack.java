package tju.chapter3;

import java.util.Arrays;

/**
 * @author GemLee
 * @version 1.0
 * created 2019/04/26
 * Description ʹ��������ʵ��һ��˳��ջ��������̲μ����ݽṹ���㷨����
 * Operation ������������һ����pop(),һ����push()
 * ����������ã��п�ֵ����������ƣ���Ҫ�Ľ�
 * */

public class SequenceStack<AnyType> {
	//stack��������ʽ
	private Object [] stack;
	//stack��Ĭ������������ʹ����������
	private int maxSize;
	//stack ָ��
	private int top;
	//�ղι�����,�����ָ�����͵����вι���������ʼ��ֵΪ10;
	public SequenceStack() {
		this(10);
	}
	//�����ʼ����
	public SequenceStack(int maxSize) {
		
		this.maxSize = maxSize;
		this.stack = new Object[maxSize];
		top = -1;
	}
	
	//�ж�ջ�Ƿ�Ϊ��ջ
	public boolean Empty() {
		return top == -1;
	}
	//ѹջ֮ǰ�ж��ǲ���ջ����
	public void push (AnyType t)  {
		if(top == maxSize - 1) {
			throw new RuntimeException("ջ����");
		}
		stack[++top] = t;
	}
	//��ջ����ջ֮ǰ���ж��ǲ���ջΪ�գ�
	public AnyType pop() {
		if(top == -1) {
			throw new RuntimeException("ջΪ��");
		}
		
		AnyType t = (AnyType) stack[top];
		stack[top--] = null;
		return t;
	}
	//��дtoString()���������ջ��Ԫ�أ�
	public String toString() {
		return Arrays.toString(stack);
	}
	
}
