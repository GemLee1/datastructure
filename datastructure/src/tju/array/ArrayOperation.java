package tju.array;

import java.util.Arrays;

/**
 * @author zhuhai
 * @version 1.0
 * Description �������������޸ĳ��ȣ�
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
		System.out.println("�޸�ֵ�޸ģ�" + Arrays.toString(arr));
		
		//������޸��˵�ַ��
		arr = insert2(arr,20);
		System.out.println("��ֵ�޸ģ�" + Arrays.toString(arr));*/
		
		/*int[] arr = new int[] {1,2,3};
		//���ٱ�������
		System.out.println(Arrays.toString(arr));
		
		//�Ѿ������ֵ��ֵ�������飬Ȼ��������������������Ҫ�����Ԫ�أ����������ָ������飻
		int[] newArr = new int[arr.length+1];
		for(int i = 0;i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		int val = 6;
		newArr[arr.length] = val;
		arr = newArr;
		System.out.println(Arrays.toString(arr));*/
		
		arr = deleteArray(arr, 2);
		System.out.println("ɾ���������" + Arrays.toString(arr));
		
		
		
		
	}
	//������Ҫע�⣬���ֻ�Ǵ������飬û�з���ֵ�����Ծ��ǲ��ı�main�����е�arr����Ϊ����ֵ���ݣ�
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
