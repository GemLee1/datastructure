package tju.chapter3;

import java.util.Iterator;
/**
 * @author GemLee
 * @version 1.0
 * 自己实现ArrayList类；Mark Allen 版本；
 * 代码有值得优化之处，请大家多多指教
 * */
class ArrayListDemo<AnyType> implements Iterable<AnyType> {
	//定义ArrayList的大小，和移动角标
	private  int theSize;
	//定义ArrayList变量名字
	private AnyType [] theItems;
	//设置ArrayList容量，默认容量大小是10，等于，经过初始化后，theSize等于0；
	private static final int DEFAULT_CAPACITY = 10;
	/**
	 * 创建ArrayList数组时，应该先进行初始化；
	 * */
	public ArrayListDemo() {
		doClear();
	}
	/**
	 * 数组初始化，设置大小初始为0；
	 * 调用
	 * */
	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
		
	}
	/**
	 * 清除数组存储值；
	 * */
	public void clear() {
		doClear();
	}
	/**
	 * 返回数组的容量；比最大角标大1；
	 * ArrayList中没有length，只有size，遍历时；
	 * */
	public int size() {
		return theSize;
	}
	public boolean IsEmpty() {
		return size() == 0;
	}
	/**
	 * 为ArrayList设置值
	 * 首先判断是否角标越界；然后对应角标赋值即可
	 * Mark是设置完后，把旧的值返回了；
	 **/
	public AnyType set(int idx,AnyType newValue) {
		if(idx<0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index=" + idx + ";size=" + size() + "越界了");
		AnyType old = theItems[idx];
		theItems[idx] = newValue;
		//返回原始角标值；
		return old;
	}
	/**
	 * 返回对应角标的值；
	 * 越界判断，然后才能取值
	 * */
	public AnyType get(int idx) {
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index=" + idx + ";size=" + size() + "越界了");
		return theItems[idx];
	}
	/**
	 * 1.保证数组容量的操作，也可以看做是ArrayList的扩容操作；在实现ArrayList的增加时，要考虑数组的容量是不是够，默认是存储是10
	 * 2.当超过10的时候，就要给数组扩容，这里的思想，就是开辟一个新的数组，把原始数组的内容复制到新的数组中，然后舍弃原始数组；
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
	 * 外部调用add(),只需要传入参数值即可
	 * */
	public boolean add(AnyType value) {
		add(size(),value);
		return true;
	}
	/**
	 * 具体实现由于依赖的是数组，所以需要传入角标
	 * 由于默认数组的容量是10，所以在这里要做扩容处理，给出一种扩容机制；
	 * 首先判断增加时的容量是不是等于默认容量，如果是，说明增加时，默认容量已经不够了，需要扩容
	 * */
	public void add(int idx, AnyType value) {
		if(theItems.length == size())
			//这里扩容，就是首先把容量增大为原来的2倍+1，然后在在ensureCapacity（）方法里，实现数据扩容
			//思想就是先new出一个容量为原来2倍+1的数组，然后把旧的数组复制给新的数组；
			ensureCapacity(size()*2 + 1);
		//插入过程，就是首先根据角标确定插入位置，然后开始移动数组；这里这种插入移动是在idx后面一位插入，如果是i>=idx,时，则在当前位置插入；
		for(int i = theSize;i > idx;i--) {
			theItems[i] = theItems[i-1];
		}
		theItems[idx] = value;
		theSize++;
	}
	/**
	 * 课本上移除，没有做判断，我认为应该需要加上越界异常判断
	 * 移除时，首先根据角标找到移除位置，然后逐步从后向前把元素向后移动一位；移除完成后，让数组的容量减去1；
	 * 把要移除数据返回去；
	 * */
	public AnyType remove(int idx) {
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index=" + idx + ";size=" + size() + "越界了");
		AnyType old = theItems[idx];
		for(int i = idx;i < size()-1;i++)
			theItems[i] = theItems[i+1];
		theSize--;
		return old;
	}
	/**
	 * 直接打印数组名字时,把数组内容转化成toString；
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
	 * 实现Iterable接口，必须实现它的抽象方法，就是iterator（），这个方法是对ArrayList的存储item进行遍历，并且在遍历过程中能进行修改操作;
	 * 实现Iterable接口后，能进行foreach遍历；
	 * Iterable接口后的泛型在定义时，可以写任意类型，在使用时，传递具体的实际类型即可。
	 * 注意，内部类拥有所有外部类成员的访问权。
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
