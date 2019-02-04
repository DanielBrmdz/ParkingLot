package fileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import parking.Car;

public class FileManager {

	private List<String> fruits;
	private List<String> tubers;
	private List<String> vegetables;

	public FileManager() throws IOException {
		uploadFile();
	}

	public void uploadFile() throws IOException {
		fruits = Files.readAllLines(Paths.get("./resource/Frutas.txt"));
		tubers = Files.readAllLines(Paths.get("./resource/Tuberculos.txt"));
		vegetables = Files.readAllLines(Paths.get("./resource/Hortalizas.txt"));
	}
	
	public void writeFile(ArrayList<String> salida , ArrayList<Car> parking) throws IOException {
		
		
		Calendar date = new GregorianCalendar();
		
		
 		System.out.println("Entra al metodo");
		File archive = new File("./Report.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(archive));
		String titulo = ("Reporte Dia: " + date.get(Calendar.YEAR)
		+ "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH) + "/"
		+ date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) );	
		bw.write(titulo);
		bw.newLine();
		String cars = ("Autos en el Parkeadero"); 
		bw.write(cars);
		bw.newLine();
		for (Car lineParking : parking) {
			
			bw.write(lineParking.toString());
			bw.newLine();	
		}
		
		String carOut = ("Autos Que ya salieron");
		bw.write(carOut);
		bw.newLine();
		for (String lineReport : salida) {
			
				bw.write(lineReport);
				bw.newLine();	
		}
		
		bw.close();
	}

	public List<String> getFruits() {
		return fruits;
	}

	public List<String> getTubers() {
		return tubers;
	}

	public List<String> getVegetables() {
		return vegetables;
	}

}
