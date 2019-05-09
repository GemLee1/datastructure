package tju.chapter3;

import org.junit.jupiter.api.Test;

public class ListDemo1 {
	
	@Test
	/**
	 * 表的简单数组实现
	 * 数组实现，查找最快，但是修改（插入和删除）比较麻烦
	 * */
	public void listArr() {
		//创建数组，并且初始化
		int[] arr = new int[10];
		System.out.println("arr数组元素为：");
		for(int i = 0;i < arr.length;i++) {
			arr[i] = i*i; 
			System.out.print(arr[i] + " ");
		}
		//数组扩容成两倍
		int [] newArr = new int[arr.length*2];
		System.out.println();
		System.out.println("newArr数组元素为：");
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
			System.out.print(newArr[i] + " ");
		}
		arr = newArr;
		System.out.println();
		System.out.println("修改后的arr元素为：");
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
