package challenges.designPattern.prototype;

public class PrototypeDemo {
	
	public static void main(String[] args) {
		
		PrototypeRegistry pr = new PrototypeRegistry();
		pr.addInRegistry("Doc1", new NewDocument("chapter 1", "java refresher"));
		pr.addInRegistry("Doc3", new NewDocument("chapter 3", "java refresher"));
		pr.addInRegistry("Doc2", new NewDocument("chapter 2", "java refresher"));
		pr.addInRegistry("Doc4", new NewDocument("chapter 4", "java refresher"));
		
		
		NewProtoType npt = pr.getProtoType("Doc1");
		
	}

}
