package controller;

import java.util.Calendar;

import parking.ParkingLot;
import parking.Product;
import view.Console;

public class Controller {

	private ParkingLot parking;
	private Console console;

	public Controller() {
		console = new Console();
		try {
			parking = new ParkingLot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parking.read();
		index();
		System.out.println(parking.getCars());

	}

	private void index() {
		switch (console.menu()) {
		case 1:
			if(parking.getCars().size() < 16) {
				addCar();
			}else {
				
				console.noMore();
			}
			index();
			break;
		case 2:
			removeCar(console.removeCar(parking.getCars()), console.time() , console.getWeigth());
			index();
			break;
		case 3:
			generateReport();
			console.aviso();
			index();
			break;	
		default:
			break;
		}
	}
	
	public void generateReport() {
		parking.generateReport();
	}

	public void addCar() {
		String plate = console.getplate();
		
		double weight = console.getWeigth();
		
		Product product  = producto();
		parking.addCar(weight, plate, product);

	}

	private Product producto() {
		switch (console.list()) {
		case 1:
			
			return console.product(parking.getFruits());
		
		case 2:
			return console.product(parking.getTubers());
			
		case 3:
			return console.product(parking.getVegetables());
			
		default:
			break;
		}
		return null;
	}
	
	private void removeCar( int pos , Calendar time , double peso ) {
		console.tarifa(parking.removeCar(pos, time, peso));
		for (int i = 0; i < parking.getSalida().size(); i++) {
			System.out.println(i+1 +") " + parking.getSalida().get(i) );
			
		}
	}

	public static void main(String[] args) {
		new Controller();
	}

}
