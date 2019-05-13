package tju.linklist;

import java.util.Iterator;

/**
 * @author GemLee
 * @version 1.0
 * Description �Լ�ʵ��һ���������������ӽڵ㡢��ȡ��һ���ڵ㡢 ��ȡ�ڵ������ݡ��Ƿ������һ���ڵ㣬ʵ��foreach������
 * */

public class MySingleLink<AnyType> implements Iterable<AnyType>{
	
	AnyType data;
	MySingleLink next;
	/*//�Լ�����ڵ����ͣ������ٸ��ģ�
	private class Node<AnyType>{
		
	}*/
	
	//��ʼ��һ�����������Դ����չ��췽����set/get����ֵ��
	public MySingleLink(AnyType val) {
		this.data = val;
		this.next = null;
	}
	//��������õ���β�巨������ÿ�β��붼�ȱ��������뵽���
	public MySingleLink append(MySingleLink node) {
		//��ȡ����ǰ�ڵ㣻
		MySingleLink currentNode = this;
		
		//����Ǳ����Ĺ��̣�ȷ��currentNode.nextΪ���˲��ܲ��룻
		while(true) {
			MySingleLink  nextNode = currentNode.next;
			if(nextNode == null) {
				break;
			}
			currentNode = nextNode;
		}
		currentNode.next = node;
		return this;
	}
	//������õ���ͷ�巨������ÿ�ζ������ڵ�ǰ�ڵ�ĺ��棻�����˵�Ƚϼ�
	public void headAppend(MySingleLink node) {
		//��ȡ��ǰ�ڵ�
		MySingleLink currentNode = this;
		node.next = currentNode.next;
		currentNode.next = node;
	}
	
	//��ȡ��һ���ڵ�
	public MySingleLink next() {
		return this.next;
	}
	//��ȡ�ڵ��ֵ
	public AnyType get() {
		return this.data;
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		
		return null;
	}
	

}
