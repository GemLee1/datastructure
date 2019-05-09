package tju.test;

import tju.chapter3.SequenceStack;

public class StackTest {
	public static void main(String[] args) {
		SequenceStack<Integer> stack = new SequenceStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
	}

}
