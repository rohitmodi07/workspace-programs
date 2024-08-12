package challenges.designPattern.builder;

public class Phone{
	private String brand;
	private int memory;
	private String size;
	private String model;
	
	public Phone(String brand, int memory, String size, String model) {
		super();
		this.brand = brand;
		this.memory = memory;
		this.size = size;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", memory=" + memory + ", size=" + size + ", model=" + model + "]";
	}
	
}

