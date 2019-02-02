package fileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

	private List<String> fruits;
	private List<String> tubers;
	private List<String> vegetables;

	public FileManager() throws IOException {
		uploadFile();
	}

	public void uploadFile() throws IOException {
		fruits = Files.readAllLines(Paths.get("/home/usuarioacer/Escritorio/Frutas.txt"));
		tubers = Files.readAllLines(Paths.get("/home/usuarioacer/Escritorio/Tuberculos.txt"));
		vegetables = Files.readAllLines(Paths.get("/home/usuarioacer/Escritorio/Hortalizas.txt"));
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
