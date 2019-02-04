package parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import fileManager.FileManager;

public class ParkingLot {

	public static final double TARIFA = 0.05;

	private ArrayList<Car> cars;
	private ArrayList<String> salida;
	private ArrayList<Product> fruits;
	private ArrayList<Product> vegetables;
	private ArrayList<Product> tubers;
	private FileManager fileManager;

	public ParkingLot() {

		cars = new ArrayList();
		fruits = new ArrayList();
		tubers = new ArrayList();
		vegetables = new ArrayList();
		salida = new ArrayList();
		try {
			fileManager = new FileManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void read() {
		readFruits();
		readTubers();
		readVegetables();
	}

	public void addCar(double weight, String plate, Product producto) {

		Car newCar = new Car(weight, plate, producto.getName(), producto.getPrice());
		cars.add(newCar);

	}

	public double removeCar(int pos, Calendar time, double peso) {

		long minute = ((time.getTimeInMillis() - cars.get(pos).getDate().getTimeInMillis()) / 60000);

		if (minute < 180) {
			double pesoF = cars.get(pos).getWeight() - peso;
			double tarifa = ((cars.get(pos).getPrice() * (pesoF / 100)) * TARIFA);
			double precio = tarifa * (minute / 10);
			salida.add(cars.get(pos).toString() + " Peso Final: " + pesoF + "kg" + " Pago: $" + (int) precio);
			cars.remove(pos);
			return precio;
		} else {
			double pesoF = cars.get(pos).getWeight() - peso;
			double tarifa = ((cars.get(pos).getPrice() * (pesoF / 100)) * TARIFA);
			double precio = tarifa * (minute) + (minute - 180) * 200;
			salida.add(cars.get(pos).toString() + " Peso Final: " + pesoF + "kg" + " Pago: $" + (int) precio
					+ "Recargo de: $" + (int) (minute - 180) * 200);
			cars.remove(pos);
			return precio;
		}

	}

	private void readFruits() {
		for (String fruit : fileManager.getFruits()) {
			String[] data = fruit.split("/");
			int price = Integer.parseInt(data[1]);
			fruits.add(new Product(data[0], price));
		}

	}

	private void readVegetables() {
		for (String vegetable : fileManager.getVegetables()) {
			String[] data = vegetable.split("/");
			int price = Integer.parseInt(data[1]);
			vegetables.add(new Product(data[0], price));
		}

	}

	public void generateReport() {
		
		try {
			fileManager.writeFile(salida , cars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readTubers() {
		for (String tuber : fileManager.getVegetables()) {
			String[] data = tuber.split("/");
			int price = Integer.parseInt(data[1]);
			tubers.add(new Product(data[0], price));
		}

	}

	public ArrayList<String> getSalida() {
		return salida;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public ArrayList<Product> getFruits() {
		return fruits;
	}

	public ArrayList<Product> getVegetables() {
		return vegetables;
	}

	public ArrayList<Product> getTubers() {
		return tubers;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

}
