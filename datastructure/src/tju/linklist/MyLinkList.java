package tju.linklist;
/**
 * @author GemLee
 * @version 1.0
 * Description ʵ��һ��������,���Ԫ�أ�Ȼ����������
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
	//��ʼ��һ������
	public MyLinkList() {
		head = null;
		theSize = 0;
		
	}
	//�������п�
	public boolean isEmpty() {
		return theSize == 0;
	}
	//������Ĵ�С
	public int size() {
		return theSize;
	}
	
	//����������,���Է�Ϊͷ�巨��β�巨��
	//ͷ�巨����������
	public void headInsert(Node inode) {
		if(isEmpty()) {
			head = inode;
		}else {
			inode.next = head;
			head = inode;
			theSize++;
		}
		
	}
	//β�巨����������
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
	//������ı���
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
	//����������ã�

}
