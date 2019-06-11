package tju.recursion;

public class Demo1 {
	public static void main(String[] args) {
		print(5);
	}
	public static void print(int val) {
		if(val > 0) {
			print(val - 1);
			System.out.println(val);
			}
	}
}
