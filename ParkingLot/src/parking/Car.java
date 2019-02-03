package parking;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Car extends Product{

	private double weight;
	private String plate;
	private Calendar date;

	public Car(double weight, String plate, String name , double price) {
		super(name , price);
		date = new GregorianCalendar();
		this.weight = weight;
		this.plate = plate;
		
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}


	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Plate" + plate + ", Weight" + weight + "kg"+ ", producto= " + getName()  + ", price= $" + getPrice() + ", date= " + date.get(Calendar.YEAR)
				+ "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH) + "/"
				+ date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) ;
	}

}
