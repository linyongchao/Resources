package initorder;

/**
 * 调用一个对象的构造函数时<br>
 * 先调用类中所有的静态代码块，先父类后子类，顺序调用<br>
 * 然后调用父类的构造函数<br>
 * （可以通过super关键字指定父类的构造函数，否则默认调用无参的构造函数，并且需要在子类的构造函数的第一行调用）
 * 之后静态成员变量的初始化函数和静态初始化块则按照在代码当中的顺序执行<br>
 * 成员变量如果没有指定值的话则赋予默认值，即基本数据类型为0或false等，对象则为null；<br>
 * 最后调用自身构造函数。
 * 
 * @author lin
 * @date 2016年2月12日 上午9:53:58
 */
public class InitOrder extends Base {
	static {
		System.out.println("this is static 1");
	}

	private Member m1 = new Member("Member 1");

	static {
		System.out.println("this is static 2");
	}

	{
		System.out.println("Initial Block()");
	}

	public InitOrder() {
		super(10);
		System.out.println("ShunXu()");
	}

	private Member m2 = new Member("Member 2");
	private int i = getInt();

	private int getInt() {
		System.out.println("getInt()");
		return 2;
	}

	static {
		System.out.println("this is static 3");
	}

	public static void main(String[] args) {
		new InitOrder();
	}
}

class Base {
	public Base() {
		System.out.println("Base()");
	}

	static {
		System.out.println("parent static 1");
	}

	public Base(int i) {
		System.out.println("Base()" + i);
	}

	static {
		System.out.println("parent static 2");
	}
}

class Member {
	public Member(String m) {
		System.out.println("Member() " + m);
	}
}