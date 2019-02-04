package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import parking.Car;
import parking.Product;

public class Console {

	private Scanner sc;

	public Console() {
		sc = new Scanner(System.in);

	}

	public int menu() {
		System.out.println("Bienvenido al Administrador de parqueadero");
		System.out.println("1) Agregar Auto");
		System.out.println("2) Sacar Auto");
		System.out.println("3) Generar reporte"); 
		
		return sc.nextInt();
	}
	
	public int removeCar(ArrayList<Car> cars) {
		
		System.out.println("Seleccione el numero del vehiculo");
		
		for (int i = 0; i < cars.size(); i++) {
				System.out.println(i+1 +") " + cars.get(i));
		}
		return sc.nextInt()-1;
		
	}
	
	public  Calendar time() {
	
		Calendar aux = new GregorianCalendar();
		System.out.println("diguite la hora del dia en fomato 24H");
		int hour = sc.nextInt();
		System.out.println("digite el minuto de la hora");
		int minute = sc.nextInt();
		return new GregorianCalendar(aux.get(Calendar.YEAR),aux.get(Calendar.MONTH) ,aux.get(Calendar.DAY_OF_MONTH) , hour, minute);
	}
	

	public double getWeigth() {
		System.out.println("Ingrese El Peso en (kg):");
		return sc.nextDouble();
	}

	public String getplate() {
		System.out.println("Ingrese La Placa:");
		return sc.next();
	}

	public int list() {
		System.out.println("Seleccione el Tipo de Producto");
		System.out.println("1) Fruta");
		System.out.println("2) Tuberculos");
		System.out.println("3) Holtalizas");
		return (sc.nextInt() );
	}
	
	public Product product(ArrayList<Product> product) {
		System.out.println("Seleccione el producto");
		for (int i = 0; i < product.size(); i++) {
			System.out.println(i+1 + ") " + product.get(i));
		}
		
		return product.get(sc.nextInt()-1);
		
		
	}
	public void aviso() {
		System.out.println("Se genero el Reporte en <<./Report.txt>>  ");
	}
	
	public void noMore() {
		System.out.println("El parqueadero esta lleno");
	}
	
	public void tarifa(double tarifa) {
		System.out.println("el vehiculo debe pagar: $" + (int)tarifa);
	}

	

	
	
}


