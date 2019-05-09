package tju.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author GemLee
 * @version 1.0
 * @see 自己实现的LinkedList；
 * LinkedList链表为双链表，头尾数据域为空；
 * */
class LinkListDemo<AnyType> implements Iterable<AnyType>{
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	/**
	 * 注意Node<AnyType>的类型，有一个前驱，一个后继；双链表；
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
	 * 注意首先初始化；
	 * */
	public LinkListDemo(){
		doClear();
	}
	public void doClear() {
		beginMarker = new Node<AnyType>(null,null,null);
		endMarker = new Node(null, beginMarker, null);
		beginMarker.next = endMarker; //认真，这是我的一个bug，写错了，兄dei；
		
		theSize = 0;
		modCount++;
	}
	/**
	 * 全删除链表；
	 * */
	private void clear() {
		doClear();
	}
	/**
	 * size()方法返回的是list的长度；
	 * */
	public int size() {
		return theSize;
	}
	/**
	 * 判断是不是为空
	 * */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * 添加一个元素
	 * */
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	public void add(int idx,AnyType x) {
		addBefore(getNode(idx,0,size()),x);
	}
	/**
	 * 获取到在node节点之前插入一个元素；注意是双链表；
	 * */
	private void addBefore(Node<AnyType> node, AnyType x) {
		Node<AnyType> newNode = new Node<>(x,node.prev,node);
		node.prev.next = newNode;
		node.prev = newNode;
		
		theSize++;
		modCount++;
	}
	/**
	 * 获取到节点；
	 * 采取的二分查找法；
	 * */
	public Node<AnyType> getNode(int idx,int low,int up) {
		Node<AnyType> node;
		if(idx < low || idx > up) {
			throw new IndexOutOfBoundsException("角标越界");
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
	 * 获取到节点的值；
	 * */
	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	/**
	 * 根据id获取到节点；
	 * */
	public Node<AnyType> getNode(int idx){
		return getNode(idx,0,size()-1);
	}
	/**
	 * 设置某个节点的值；
	 * */
	public AnyType set(int idx,AnyType newVal) {
		Node<AnyType> node = getNode(idx);
		AnyType oldVal = node.data;
		node.data = newVal;
		return oldVal;
	}
	/**
	 * 根据id移除某个节点；
	 * */
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	/**
	 * 直接移除某个节点；
	 * */
	private AnyType remove(Node<AnyType>node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		theSize--;
		modCount++;
		return node.data;
		
	}
	/**
	 * 该方法允许返回一个iterator()的迭代器对象；
	 * */
	@Override
	public Iterator<AnyType> iterator() {
		
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<AnyType>{
		//当前节点指向的是头结点的next，也就是正式链表的节点
		private Node<AnyType> current = beginMarker.next;
		//modCount指的是链表修改版本是不是相同，不同则不能迭代；
		private int expectedModCount = modCount;
		//该节点remove有个前提，必须要存在；
		private boolean okToRemove = false;
		//如果current == endMarker,说明是空表；
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}
		//首先判断modCount的版本是不是一样，然后在判断是不是空表；
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
			//注意，这个remove方法在next之后执行；因此，删除的应该是current；我没有考虑到；
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
