package tju.chapter3;

import java.util.Iterator;
/**
 * @author GemLee
 * @version 1.0
 * �Լ�ʵ��ArrayList�ࣻMark Allen �汾��
 * ������ֵ���Ż�֮�������Ҷ��ָ��
 * */
class ArrayListDemo<AnyType> implements Iterable<AnyType> {
	//����ArrayList�Ĵ�С�����ƶ��Ǳ�
	private  int theSize;
	//����ArrayList��������
	private AnyType [] theItems;
	//����ArrayList������Ĭ��������С��10�����ڣ�������ʼ����theSize����0��
	private static final int DEFAULT_CAPACITY = 10;
	/**
	 * ����ArrayList����ʱ��Ӧ���Ƚ��г�ʼ����
	 * */
	public ArrayListDemo() {
		doClear();
	}
	/**
	 * �����ʼ�������ô�С��ʼΪ0��
	 * ����
	 * */
	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
		
	}
	/**
	 * �������洢ֵ��
	 * */
	public void clear() {
		doClear();
	}
	/**
	 * ��������������������Ǳ��1��
	 * ArrayList��û��length��ֻ��size������ʱ��
	 * */
	public int size() {
		return theSize;
	}
	public boolean IsEmpty() {
		return size() == 0;
	}
	/**
	 * ΪArrayList����ֵ
	 * �����ж��Ƿ�Ǳ�Խ�磻Ȼ���Ӧ�Ǳ긳ֵ����
	 * Mark��������󣬰Ѿɵ�ֵ�����ˣ�
	 **/
	public AnyType set(int idx,AnyType newValue) {
		if(idx<0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index=" + idx + ";size=" + size() + "Խ����");
		AnyType old = theItems[idx];
		theItems[idx] = newValue;
		//����ԭʼ�Ǳ�ֵ��
		return old;
	}
	/**
	 * ���ض�Ӧ�Ǳ��ֵ��
	 * Խ���жϣ�Ȼ�����ȡֵ
	 * */
	public AnyType get(int idx) {
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index=" + idx + ";size=" + size() + "Խ����");
		return theItems[idx];
	}
	/**
	 * 1.��֤���������Ĳ�����Ҳ���Կ�����ArrayList�����ݲ�������ʵ��ArrayList������ʱ��Ҫ��������������ǲ��ǹ���Ĭ���Ǵ洢��10
	 * 2.������10��ʱ�򣬾�Ҫ���������ݣ������˼�룬���ǿ���һ���µ����飬��ԭʼ��������ݸ��Ƶ��µ������У�Ȼ������ԭʼ���飻
	 * */
	private void ensureCapacity(int newCapacity) {
		if(newCapacity < theSize) {
			return;
		}
		AnyType [] old = theItems;
		theItems = (AnyType[]) new Object[newCapacity];
		for(int i = 0;i<size();i++) {
			theItems[i] = old[i];
		}
		
	}
	/**
	 * �ⲿ����add(),ֻ��Ҫ�������ֵ����
	 * */
	public boolean add(AnyType value) {
		add(size(),value);
		return true;
	}
	/**
	 * ����ʵ�����������������飬������Ҫ����Ǳ�
	 * ����Ĭ�������������10������������Ҫ�����ݴ�������һ�����ݻ��ƣ�
	 * �����ж�����ʱ�������ǲ��ǵ���Ĭ������������ǣ�˵������ʱ��Ĭ�������Ѿ������ˣ���Ҫ����
	 * */
	public void add(int idx, AnyType value) {
		if(theItems.length == size())
			//�������ݣ��������Ȱ���������Ϊԭ����2��+1��Ȼ������ensureCapacity���������ʵ����������
			//˼�������new��һ������Ϊԭ��2��+1�����飬Ȼ��Ѿɵ����鸴�Ƹ��µ����飻
			ensureCapacity(size()*2 + 1);
		//������̣��������ȸ��ݽǱ�ȷ������λ�ã�Ȼ��ʼ�ƶ����飻�������ֲ����ƶ�����idx����һλ���룬�����i>=idx,ʱ�����ڵ�ǰλ�ò��룻
		for(int i = theSize;i > idx;i--) {
			theItems[i] = theItems[i-1];
		}
		theItems[idx] = value;
		theSize++;
	}
	/**
	 * �α����Ƴ���û�����жϣ�����ΪӦ����Ҫ����Խ���쳣�ж�
	 * �Ƴ�ʱ�����ȸ��ݽǱ��ҵ��Ƴ�λ�ã�Ȼ���𲽴Ӻ���ǰ��Ԫ������ƶ�һλ���Ƴ���ɺ��������������ȥ1��
	 * ��Ҫ�Ƴ����ݷ���ȥ��
	 * */
	public AnyType remove(int idx) {
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index=" + idx + ";size=" + size() + "Խ����");
		AnyType old = theItems[idx];
		for(int i = idx;i < size()-1;i++)
			theItems[i] = theItems[i+1];
		theSize--;
		return old;
	}
	/**
	 * ֱ�Ӵ�ӡ��������ʱ,����������ת����toString��
	 * */
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (AnyType anyType : this) {
			builder.append(anyType + " ");
		}
		builder.append("]");
		return new String(builder);
	}
	@Override
	/**
	 * ʵ��Iterable�ӿڣ�����ʵ�����ĳ��󷽷�������iterator��������������Ƕ�ArrayList�Ĵ洢item���б����������ڱ����������ܽ����޸Ĳ���;
	 * ʵ��Iterable�ӿں��ܽ���foreach������
	 * Iterable�ӿں�ķ����ڶ���ʱ������д�������ͣ���ʹ��ʱ�����ݾ����ʵ�����ͼ��ɡ�
	 * ע�⣬�ڲ���ӵ�������ⲿ���Ա�ķ���Ȩ��
	 * */
	public Iterator<AnyType> iterator() {	
		return new MyArrayListIterator();
	}
	private class MyArrayListIterator implements Iterator<AnyType>{
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current < size();
		}
		@Override
		public AnyType next() {
			return theItems[current++];
		}
		/**
		 * 
		 * */
		public void remove() {
			ArrayListDemo.this.remove(--current);
		}
		
	}
}
public class ArrayListTest{
	public static void main(String[] args) {
		ArrayListDemo<Integer> list = new ArrayListDemo<>();
		for(int i = 0;i < 10;i++)
			list.add(i);
		for(int i = 20;i < 30;i++) {
			list.add(i);
		}
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(i);
			it.remove();
		}
		list.remove(18);
		System.out.println(list);
	}
	
}
