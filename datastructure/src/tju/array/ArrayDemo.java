package tju.array;
/**
 * @author zhuhai
 * @version 1.0
 * Description 这个类是数组的基本操作，比如说赋值和遍历；
 * Created 2019/05/06
 * 
 * */

public class ArrayDemo {
	public static void main(String[] args) {
		int[] arr = new int[3];
		//循环初始化
		for(int i = 0;i < arr.length;i++) {
			arr[i] = i;
		}
		
		//为具体某个元素复制
		arr[2] = 5;
		
		//创建时初始化，不需要写上长度
		int[] arr2 = new int[] {1,2,3};
		
		//遍历
		for(int i = 0;i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr2.length);
	}

}
