package parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileManager.FileManager;

public class ParkingLot {

	private ArrayList<Car> cars;
	private ArrayList<Product> fruits;
	private ArrayList<Product> vegetables;
	private ArrayList<Product> tubers;
	private FileManager fileManager;

	public ParkingLot() throws IOException {

		cars = new ArrayList();
		fruits = new ArrayList();
		tubers = new ArrayList();
		vegetables = new ArrayList();
		fileManager = new FileManager();
		read();

	}

	public void read() {
		readFruits();
		readTubers();
		readVegetables();
	}
	
	public void readFruits() {
		for (String fruit : fileManager.getFruits()) {
			String[] data = fruit.split("/");
			int price = Integer.parseInt(data[1]);
			fruits.add(new Product(data[0], price));
		}

	}

	public void readVegetables() {
		for (String vegetable : fileManager.getVegetables()) {
			String[] data = vegetable.split("/");
			int price = Integer.parseInt(data[1]);
			vegetables.add(new Product(data[0], price));
		}

	}

	public void readTubers() {
		for (String tuber : fileManager.getVegetables()) {
			String[] data = tuber.split("/");
			int price = Integer.parseInt(data[1]);
			tubers.add(new Product(data[0], price));
		}

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

	public static void main(String[] args) throws IOException {
		ParkingLot p = new ParkingLot();
		for (int i = 0; i < p.getFruits().size(); i++) {
			System.out.println(p.getFruits().get(i));
		}
	
		for (int i = 0; i < p.getTubers().size(); i++) {
			System.out.println(p.getTubers().get(i));
		}
		for (int i = 0; i < p.getVegetables().size(); i++) {
			System.out.println(p.getVegetables().get(i));
		}

	}

}
