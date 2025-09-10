package Pack1;

public class Car {
	
	private int numOfDoors;
	private String color;
	
	
	//defaul cons
	
	public Car() {
		System.out.println("creating car with defaulcons");
		numOfDoors = 2;
		color = "blue";
	}
	//parameter cons
	public Car(int nd, String c) {
		System.out.println("creating car with param cons");
		numOfDoors = nd;
		color = c;
	}
	//copy cons
	public Car(Car c) {
		System.out.println("creating car with copy cons");
		numOfDoors = c.numOfDoors;
		color = c.color;
	}
	
	//crazy cons
	public Car(int nd,Car c) {
		System.out.println("creating car with crazy cons");
		numOfDoors = nd;
		color = c.color;
	}
	
	
	public int getnumOfDoors() {
		return numOfDoors;
	}
	
	public void setNumOfDoors(int numOfDoors) {
		if(numOfDoors<0) {
			return;
		}
		this.numOfDoors = numOfDoors;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public void displayCar() {
		System.out.println("numofDoors " +numOfDoors 
				+ "color is " + color);
	}

}
