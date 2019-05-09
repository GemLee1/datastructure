package tju.test;

import tju.stack.MyStack;

public class MyStackTest {
	public static void main(String[] args) {
		MyStack<Integer> arr = new MyStack<>();
		arr.push(23);
		arr.push(24);
		arr.push(25);
		//±éÀúÕ»
		arr.show();
		//³öÕ»
		/*System.out.println(arr.pop());
		System.out.println(arr.pop());
		System.out.println(arr.pop());
		
		arr.show();*/
		System.out.println(arr.isEmpty());
		System.out.println(arr.size());
		System.out.println(arr.look());
		System.out.println("pop " + arr.pop());
		System.out.println(arr.look());
	}

}
