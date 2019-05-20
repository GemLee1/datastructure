package tju.linklist;
/**
 * @author GemLee
 * @version 1.0
 * Description 实现一个单链表,添加元素，然后逆序单链表；
 * */
class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class MyLinkList{
	int theSize;
	Node head;
	//初始化一个链表
	public MyLinkList() {
		head = null;
		theSize = 0;
		
	}
	//单链表判空
	public boolean isEmpty() {
		return theSize == 0;
	}
	//求单链表的大小
	public int size() {
		return theSize;
	}
	
	//单链表的添加,可以分为头插法和尾插法；
	//头插法建立单链表；
	public void headInsert(Node inode) {
		if(isEmpty()) {
			head = inode;
		}else {
			inode.next = head;
			head = inode;
			theSize++;
		}
		
	}
	//尾插法建立单链表
	public void tailInsert(Node inode) {
		if(isEmpty()) {
			head = inode;
		}else {
			Node currentNode = head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = inode;
			theSize++;
		}
	}
	//单链表的遍历
	public void show() {
		Node curNode = head;
		while(true) {
			System.out.print(curNode.data + " ");
			if(curNode.next == null) {
				break;
			}
			curNode = curNode.next;
		}
	}
	//单链表的逆置；

}
