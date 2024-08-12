package challenges.designPattern.builder;

public class ShopPhone {

	public static void main(String[] args) {
		
		PhoneBuilder builder = new PhoneBuilder();
		builder.setBrand("Nokia");
		
		Phone phone = builder.setMemory(32).setModel("N2").getPhone();
		System.out.println("phone: " + phone);

	}

}
