package tju.chapter3;

class User{
	String name;
	public User(String name) {
		this.name = name;
	}
	public User() {
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
public class TestString {
	public static void main(String[] args) {
		
		User u = new User("Gem");
		//pass1(u);
		//pass2(u);
		StringBuffer buff = new StringBuffer("false");
		pass3(buff);
		System.out.println(buff);
		//System.out.println(u.getName());
		//String s = "true";
		//pass4(s);
		//System.out.println(s);
	}
	public static void pass1(User u) {
		u.setName("lee");
	}
	public static void pass2(User u) {
		u = new User();
		u.setName("gemlee");
		System.out.println(u.getName());
	}
	public static void pass3(StringBuffer buff) {
		buff = new StringBuffer("true");
	}
	public static void pass4(String s) {
		s = "false";
	}
	public static String pass(String name) {
		
		name = "gemlee";
		return name;
	}

}
