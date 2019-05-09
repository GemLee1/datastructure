package tju.chapter3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ARR {
	private int[] arr;
	private int theSize;
	public ARR() {
		arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
	@Override
	public String toString() {
		return "ARR [arr=" + Arrays.toString(arr) + ", theSize=" + theSize + "]";
	}
	
}

public class TestArrayInit {
	public static void main(String[] args) {
/*		ARR arr = new ARR();
		System.out.println(arr);*/
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
	}
}
