package tju.recursion;

public class FabonacciDemo {
	public static void main(String[] args) {
		System.out.println(fabonacci(6));
	}
	
	public static int fabonacci(int n) {
		if(n == 1 || n ==2) {
			return 1;
		}else {
			return fabonacci(n - 1) + fabonacci(n - 2);
		}
	}
	

}
