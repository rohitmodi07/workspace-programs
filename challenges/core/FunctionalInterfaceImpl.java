package challenges.core;

public class FunctionalInterfaceImpl implements FunctionalIDemo{
	
	public void show() {
		System.out.println("ovridden method");
	}
	
	public static void main(String[] args) {
		FunctionalIDemo.show1();
		FunctionalIDemo fd = new FunctionalInterfaceImpl();
		fd.show2();
	}

}
