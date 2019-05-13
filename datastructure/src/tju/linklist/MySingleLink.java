package tju.linklist;

import java.util.Iterator;

/**
 * @author GemLee
 * @version 1.0
 * Description 自己实现一个单链表；包含增加节点、获取下一个节点、 获取节点中数据、是否是最后一个节点，实现foreach迭代；
 * */

public class MySingleLink<AnyType> implements Iterable<AnyType>{
	
	AnyType data;
	MySingleLink next;
	/*//自己定义节点类型；后面再更改；
	private class Node<AnyType>{
		
	}*/
	
	//初始化一个链表；还可以创建空构造方法，set/get来赋值；
	public MySingleLink(AnyType val) {
		this.data = val;
		this.next = null;
	}
	//在这里采用的是尾插法，就是每次插入都先遍历，插入到最后；
	public MySingleLink append(MySingleLink node) {
		//获取到当前节点；
		MySingleLink currentNode = this;
		
		//这就是遍历的过程，确认currentNode.next为空了才能插入；
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
	//这个采用的是头插法；就是每次都插入在当前节点的后面；相对来说比较简单
	public void headAppend(MySingleLink node) {
		//获取当前节点
		MySingleLink currentNode = this;
		node.next = currentNode.next;
		currentNode.next = node;
	}
	
	//获取下一个节点
	public MySingleLink next() {
		return this.next;
	}
	//获取节点的值
	public AnyType get() {
		return this.data;
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		
		return null;
	}
	

}
