package tju.array;

import java.util.Arrays;

/**
 * @author zhuhai
 * @version 1.0
 * Description 这个类是数组的修改长度；
 * Created 2019/05/06
 * 
 * */
public class ArrayOperation {
	public static void main(String[] args) {
		int[] arr = new int[3];
		for(int i = 0;i < arr.length;i++) {
			arr[i] = i * 2 + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		/*insert2(arr,20);
		System.out.println("无赋值修改：" + Arrays.toString(arr));
		
		//这个是修改了地址；
		arr = insert2(arr,20);
		System.out.println("赋值修改：" + Arrays.toString(arr));*/
		
		/*int[] arr = new int[] {1,2,3};
		//快速遍历数组
		System.out.println(Arrays.toString(arr));
		
		//把旧数组的值赋值给新数组，然后再在新数组最后加上需要插入的元素，最后新数组指向旧数组；
		int[] newArr = new int[arr.length+1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		int val = 6;
		newArr[arr.length] = val;
		arr = newArr;
		System.out.println(Arrays.toString(arr));*/
		
		arr = deleteArray(arr, 2);
		System.out.println("删除后的数组" + Arrays.toString(arr));
		
		
		
		
	}
	//这里需要注意，如果只是传递数组，没有返回值，所以就是不改变main方法中的arr，因为就是值传递；
	public static void insert(int[] arr,int val) {
		int[] newArr = new int[arr.length + 1];
		
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		arr[2] = 100;
		newArr[arr.length] = val;
		arr = newArr;
	}
	public static int[] insert2(int[] arr,int val) {
		int[] newArr = new int [arr.length + 1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = val;
		
		arr = newArr;
		return arr;
		
	}
	
	public static int[] deleteArray(int[] arr,int index) {
		int[] newArr = new int[arr.length - 1];
		
		for(int i = 0;i < newArr.length;i++) {
			if(i<index) {
				newArr[i] = arr[i];
			}else {
				newArr[i] = arr[i+1];
			}
		}
		return newArr;
		
	}

}
