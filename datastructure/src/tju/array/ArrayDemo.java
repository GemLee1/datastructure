package tju.array;
/**
 * @author zhuhai
 * @version 1.0
 * Description �����������Ļ�������������˵��ֵ�ͱ�����
 * Created 2019/05/06
 * 
 * */

public class ArrayDemo {
	public static void main(String[] args) {
		int[] arr = new int[3];
		//ѭ����ʼ��
		for(int i = 0;i < arr.length;i++) {
			arr[i] = i;
		}
		
		//Ϊ����ĳ��Ԫ�ظ���
		arr[2] = 5;
		
		//����ʱ��ʼ��������Ҫд�ϳ���
		int[] arr2 = new int[] {1,2,3};
		
		//����
		for(int i = 0;i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr2.length);
	}

}
