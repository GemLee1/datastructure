package tju.test;

import tju.queue.MyQueue;

public class MyQueueTest {
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		//���
		q.pullIn(23);
		q.pullIn(24);
		q.pullIn(25);
		//��������
		q.show();
		//�鿴����Ԫ�أ�
		q.look();
		System.out.println("=================");
		//����
		System.out.println(q.pullOut());
		q.show();
		q.look();
		System.out.println(q.isEmpty());
		System.out.println(q.size());
	}

}
