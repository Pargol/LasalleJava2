package Pack1;

public class Computer {
	 
	private String brand;
	private String model;
	private long SN;
	private double price;
	
	private static int numOfComputer = 0;
	
	public Computer(String brand,String model, 
			long SN,double price) {
		numOfComputer++;
		this.brand = brand;
		this.model = model;
		this.SN = SN;
		this.price = price;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public String getModel(){
		return model;
	}
	public long getSN(){
		return SN;
	}
	public double getPrice(){
		return price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setmodel(String model) {
		this.model = model;
	}
	public void setSN(long SN) {
		this.SN = SN;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", model="
	+ model + ", SN=" + SN + ", price=" + price + "]";
	}
	
	public static int findNumberOfCreatedComputers() {
		return numOfComputer;
	}
	
    
}
