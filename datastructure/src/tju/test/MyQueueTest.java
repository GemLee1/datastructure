package tju.test;

import tju.queue.MyQueue;

public class MyQueueTest {
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		//入队
		q.pullIn(23);
		q.pullIn(24);
		q.pullIn(25);
		//遍历队列
		q.show();
		//查看队首元素；
		q.look();
		System.out.println("=================");
		//出队
		System.out.println(q.pullOut());
		q.show();
		q.look();
		System.out.println(q.isEmpty());
		System.out.println(q.size());
	}

}
