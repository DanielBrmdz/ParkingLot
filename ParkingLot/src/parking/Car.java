package parking;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Car {

	private double weight;
	private String plate;
	private String producto;
	private Calendar date;

	public Car(double weight, String plate, String producto) {
		date = new GregorianCalendar();
		this.weight = weight;
		this.plate = plate;
		this.producto = producto;
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

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Plate" + plate + ", Weight" + weight + ", producto= " + producto + ", date= " + date.get(Calendar.YEAR)
				+ "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH) + "/"
				+ date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE);
	}

}
