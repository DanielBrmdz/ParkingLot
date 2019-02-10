package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TextFileManager implements IFileManager{

	@Override
	public ArrayList<Object> readFile(String name) {
		Object object = null;
		try {
			object = Files.readAllLines(Paths.get(name));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return (ArrayList<Object>) object;
		
	}

	@Override
	public void writeFile(String name) {
		System.out.println("Esta escribiendo en un archivo de nombre: " + name);
	}

	public void showMessage() {
		System.out.println("Este es un archivo de texto que no quiere ser mostrado");
	}
	


}