package challenges.designPattern.builder;

public class PhoneBuilder {
	private String brand;
	private int memory;
	private String size;
	private String model;
	
	public String getBrand() {
		return brand;
	}
	public PhoneBuilder setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	public int getMemory() {
		return memory;
	}
	public PhoneBuilder setMemory(int memory) {
		this.memory = memory;
		return this;
	}
	public String getSize() {
		return size;
	}
	public PhoneBuilder setSize(String size) {
		this.size = size;
		return this;
	}
	public String getModel() {
		return model;
	}
	public PhoneBuilder setModel(String model) {
		this.model = model;
		return this;
	}
	
	public Phone getPhone() {
		return new Phone(brand, memory, size, model);
	}

	
}
