package parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fileManager.FileManager;
import persistence.FilesManager;

public class ParkingLot {

    public static final double TARIFA = 0.05;


	private ArrayList<Car> cars;
	private ArrayList<String> salida;
	private ArrayList<Product> fruits;
	private ArrayList<Product> vegetables;
	private ArrayList<Product> tubers;
	private FileManager fileManager;



	public ParkingLot() {
		
		

		cars = new ArrayList<Car>();
		fruits = new ArrayList<Product>();
		tubers = new ArrayList<Product>();
		vegetables = new ArrayList<Product>();
		salida = new ArrayList<String>();
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
            fileManager.writeFile(salida, cars);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void readTubers() {
        for (String tuber : fileManager.getTubers()) {
            String[] data = tuber.split("/");
            int price = Integer.parseInt(data[1]);
            tubers.add(new Product(data[0], price));
        }

    }

    public double getPriceFruits(String product) {
        double value = 0.0;
        for (Product fruit : fruits) {
            if (fruit.getName().equals(product)) {
                value = fruit.getPrice();
            }
        }
        return value;
    }

    public double getPriceVegetables(String product) {
        double value = 0.0;
        for (Product vegetables : vegetables) {
            if (vegetables.getName().equals(product)) {
                value = vegetables.getPrice();
            }
        }
        return value;
    }

    public double getPriceTubers(String product) {
        double value = 0.0;
        for (Product tubers : tubers) {
            if (tubers.getName().equals(product)) {
                value = tubers.getPrice();
            }
        }
        return value;
    }

    public Product getProductTub(String name) {
    	
    	for (int i = 0; i < tubers.size(); i++) {
			if(tubers.get(i).getName().equals(name)) {
				return tubers.get(i);
			}
		}
    	return null;
    }
    
	public Product getProductVeg(String name) {
		for (int i = 0; i < vegetables.size(); i++) {
			if(vegetables.get(i).getName().equals(name)) {
				return vegetables.get(i);
			}
		}
    	return null;
    }


    public Product getProductFru(String name) {
    	for (int i = 0; i < fruits.size(); i++) {
			if(fruits.get(i).getName().equals(name)) {
				return fruits.get(i);
			}
		}
    	return null;
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
