package persistence;

import java.util.ArrayList;

public interface IFileManager {
	abstract ArrayList<Object> readFile(String name);
	abstract void writeFile(String name);
}
