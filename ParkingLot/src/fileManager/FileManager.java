package fileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	
	/*public void writeFile(ArrayList<String> report) throws IOException {
		
		
		File archive = new File("./Report.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(archive));
		
		for (String listLine : listBooks) {
			String[] data = listLine.split("#");
			int page = Integer.parseInt(data[3]);
			if ((page > 49 && page < 1401) && (data[5].equals("Educacion") || data[5].equals("Ciencia Ficcion"))) {
				booksValid.add(listLine);
			} else {
				bw.write(listLine);
				bw.newLine();
			}
		}
		bw.close();
		listBooks = booksValid;
		validBooks = listBooks.size();
		booksNotValid = (admittedBooks - listBooks.size());
	}*/

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
