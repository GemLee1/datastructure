package tju.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author GemLee
 * @version 1.0
 * @see �Լ�ʵ�ֵ�LinkedList��
 * LinkedList����Ϊ˫����ͷβ������Ϊ�գ�
 * */
class LinkListDemo<AnyType> implements Iterable<AnyType>{
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	/**
	 * ע��Node<AnyType>�����ͣ���һ��ǰ����һ����̣�˫����
	 * */
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		public Node(AnyType d,Node<AnyType> p,Node<AnyType> n) {
			data = d;
			prev = p;
			next = n;
		}
		
	}
	/**
	 * ע�����ȳ�ʼ����
	 * */
	public LinkListDemo(){
		doClear();
	}
	public void doClear() {
		beginMarker = new Node<AnyType>(null,null,null);
		endMarker = new Node(null, beginMarker, null);
		beginMarker.next = endMarker; //���棬�����ҵ�һ��bug��д���ˣ���dei��
		
		theSize = 0;
		modCount++;
	}
	/**
	 * ȫɾ������
	 * */
	private void clear() {
		doClear();
	}
	/**
	 * size()�������ص���list�ĳ��ȣ�
	 * */
	public int size() {
		return theSize;
	}
	/**
	 * �ж��ǲ���Ϊ��
	 * */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * ���һ��Ԫ��
	 * */
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	public void add(int idx,AnyType x) {
		addBefore(getNode(idx,0,size()),x);
	}
	/**
	 * ��ȡ����node�ڵ�֮ǰ����һ��Ԫ�أ�ע����˫����
	 * */
	private void addBefore(Node<AnyType> node, AnyType x) {
		Node<AnyType> newNode = new Node<>(x,node.prev,node);
		node.prev.next = newNode;
		node.prev = newNode;
		
		theSize++;
		modCount++;
	}
	/**
	 * ��ȡ���ڵ㣻
	 * ��ȡ�Ķ��ֲ��ҷ���
	 * */
	public Node<AnyType> getNode(int idx,int low,int up) {
		Node<AnyType> node;
		if(idx < low || idx > up) {
			throw new IndexOutOfBoundsException("�Ǳ�Խ��");
		}
		if(idx < size()/2) {
			node = beginMarker.next;
			for(int i = 0; i < idx;i++) {
				node = node.next;
			}
		}else {
			node = endMarker;
			for(int i = size();i > idx;i--) {
				node = node.prev;
			}
		}
		return node;
	}
	/**
	 * ��ȡ���ڵ��ֵ��
	 * */
	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	/**
	 * ����id��ȡ���ڵ㣻
	 * */
	public Node<AnyType> getNode(int idx){
		return getNode(idx,0,size()-1);
	}
	/**
	 * ����ĳ���ڵ��ֵ��
	 * */
	public AnyType set(int idx,AnyType newVal) {
		Node<AnyType> node = getNode(idx);
		AnyType oldVal = node.data;
		node.data = newVal;
		return oldVal;
	}
	/**
	 * ����id�Ƴ�ĳ���ڵ㣻
	 * */
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	/**
	 * ֱ���Ƴ�ĳ���ڵ㣻
	 * */
	private AnyType remove(Node<AnyType>node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		theSize--;
		modCount++;
		return node.data;
		
	}
	/**
	 * �÷���������һ��iterator()�ĵ���������
	 * */
	@Override
	public Iterator<AnyType> iterator() {
		
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<AnyType>{
		//��ǰ�ڵ�ָ�����ͷ����next��Ҳ������ʽ����Ľڵ�
		private Node<AnyType> current = beginMarker.next;
		//modCountָ���������޸İ汾�ǲ�����ͬ����ͬ���ܵ�����
		private int expectedModCount = modCount;
		//�ýڵ�remove�и�ǰ�ᣬ����Ҫ���ڣ�
		private boolean okToRemove = false;
		//���current == endMarker,˵���ǿձ�
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}
		//�����ж�modCount�İ汾�ǲ���һ����Ȼ�����ж��ǲ��ǿձ�
		@Override
		public AnyType next() {
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			
			AnyType val = current.data;
			current = current.next;
			okToRemove = true;
			return val;
		}
		public void remove() {
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalArgumentException();
			//ע�⣬���remove������next֮��ִ�У���ˣ�ɾ����Ӧ����current����û�п��ǵ���
			LinkListDemo.this.remove(current.prev);
			modCount++;
			okToRemove = false;
		}
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		for(AnyType x : this) {
			builder.append(x + " ");
		}
		builder.append("]");
		return new String(builder);
	}
}

public class LinkedListTest {
	public static void main(String[] args) {
		LinkListDemo<Integer> lst = new LinkListDemo<>();
		for(int i = 0;i < 5;i++) {
			lst.add(i);
			//System.out.println(lst.get(i));
		}
		System.out.println(lst);
	}
	
}
