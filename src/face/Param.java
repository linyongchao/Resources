package face;

public class Param {
	String str = new String("good");
	char ch[] = { 'a', 'b', 'c' };

	public static void main(String[] args) {
		Param p = new Param();
		p.change(p.str, p.ch);
		System.out.println(p.str);
		System.out.println(p.ch);
	}

	public void change(String str, char ch[]) {
		str = "test ok";
		ch[0] = 'g';
	}
}
