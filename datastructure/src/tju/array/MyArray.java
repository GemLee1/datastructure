package tju.array;

import java.util.Arrays;

/**
 * @author GemLee
 * @version 1.0
 * Description 自己实现一个可变数组，实现数组的增加、删除、遍历、大小判断、获取某个元素、插入一个元素到指定位置、替换指定位置的元素、线性查找和二分法查找；
 * */

public class MyArray<AnyType> {
	//默认初始化一个数组
	AnyType[] arr;
	
	//数组初始化
	public MyArray() {
		arr = (AnyType[])new Object[0];
	}
	
	//判断数组的大小
	public int size() {
		return arr.length;
	}
	
	//遍历旧数组，把旧数组的值赋值给新数组，并且新数组增加一个元素；
	public void add(AnyType val) {
		AnyType[] newArr = (AnyType[])new Object[arr.length+1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		arr = newArr;
	}
	
	//删除指定角标的元素
	public void delete(int index) {
		
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("角标越界异常");
		}
		
		AnyType[] newArr = (AnyType[])new Object[arr.length-1];
		for(int i = 0;i < newArr.length;i++) {
			if(i < index) {
				newArr[i] = arr[i];
			}else {
				newArr[i] = arr[i+1];
			}
		}
		arr = newArr;
	}
	
	//遍历数组；
	public void show() {
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public void show2() {
		System.out.println(Arrays.toString(arr));
	}
	
	//获取某个位置上的元素
	public AnyType get(int index) {
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("角标越界异常");
		}
		return arr[index];
	}
	
	//替换指定角标的元素值；
	public void set(int index,AnyType val) {
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("角标越界异常");
		}
		arr[index] = val;
	}
	
	//在指定角标的地方添加元素；
	public void insert(int index,AnyType val) {
		if(index < 0 || index >= arr.length) {
			throw new RuntimeException("角标越界异常");
		}
		AnyType[] newArr = (AnyType[])new Object[arr.length+1];
		
		for(int i = 0;i < arr.length;i++) {
			if(i < index) {
				newArr[i] = arr[i];
			}else {
				newArr[i+1] = arr[i];
			}
		}
		newArr[index] = val;
		arr = newArr;
	}
	//线性查找,不能任意类型，以整形举例；
	public int search(int val) {	
		int[] newArr = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = (int) arr[i];
		}
		for(int i = 0;i < arr.length;i++) {
			if(val == newArr[i]) {
				return i;
			}else {
				continue;
			}
		}
		return -1;
	}
	
	
	//二分法查找,这里由于是任意类型，还不便查找，因此改为整数；
	public int BinarySearch(int val) {
		int begin = 0;
		int end = arr.length - 1;
		int mid;
		int[] newArr = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = (int) arr[i];
		}
		while(begin <= end) {
			mid = (begin + end) / 2;
			if(newArr[mid] == val) {
				return mid;
			}else if(val > newArr[mid]) {
				begin = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
}
