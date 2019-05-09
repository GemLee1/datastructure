package tju.test;

import tju.array.MyArray;

/**
 * @author GemLee
 * @version 1.0
 * Description 测试类MyArray.java
 * */
public class MyArrayTest {
	public static void main(String[] args) {
		MyArray<Integer> arr = new MyArray<>();
		arr.add(22);
		arr.add(23);
		arr.add(24);
		arr.add(25);
		arr.add(26);
		//遍历
		//arr.show();
		System.out.println("=======================");
		arr.show2();
		
		//删除
		System.out.println("=======================");
		arr.delete(3);
		arr.show2();
		
		//大小
		System.out.println(arr.size());
		
		//替换指定位置元素
		arr.set(3, 199);
		arr.show2();
		
		//获取指定位置的元素
		System.out.println(arr.get(2));
		
		//插入元素到指定位置
		arr.insert(3,188);
		arr.show2();
		
		//线性查找
		System.out.println(arr.search(188));
		
		System.out.println(arr.BinarySearch(199));
	}

}
