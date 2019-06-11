package tju.recursion;

public class HanoiTest {
	public static void main(String[] args) {
		char A = 'a',C = 'c',B = 'b';
		hanoi(7,A,C,B);
	}
	public static void hanoi(int n,char from,char to,char using) {
		if(n == 1) {
			System.out.println("��" + from + "��" + to);
		}else {
			hanoi(n - 1,from,using,to);
			System.out.println("��" + from + "��" + to);
			hanoi(n - 1,using,to,from);
		}
	}

}
