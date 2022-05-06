
public class InitLesson {
	public static void main(String[] args) {
		new ClassB();
	}
}

class ClassA{
	static {
		System.out.println("A static init");
	}
	{
		System.out.println("A instance init");
	}
	ClassA(){
		System.out.println("A constructer");
	}
}
class ClassB extends ClassA{
	static {
		System.out.println("B static init");
	}
	{
		System.out.println("B instance init");
	}
	ClassB(){
		System.out.println("B constructer");
	}
}