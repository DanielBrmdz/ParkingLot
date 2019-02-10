package persistence;

import java.util.ArrayList;

public class JSONFileManager implements IFileManager{

	@Override
	public ArrayList<Object> readFile(String name) {
		return null;
	}

	@Override
	public void writeFile(String name) {
		System.out.println("Esta escribiendo en un archivo de nombre: " + name);	
	}
}