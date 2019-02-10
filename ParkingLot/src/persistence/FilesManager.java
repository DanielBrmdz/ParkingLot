package persistence;

public class FilesManager {

	public static final String XML_FILE = "xml";
	public static final String TEXT_FILE = "txt";
	public static final String BINARY_FILE = "bin";
	public static final String JSON_FILE = "json";

	public IFileManager createTypeFile(String fileName){
		if(fileName.toLowerCase().endsWith(XML_FILE)){
			return new XMLFileManager();
		}else if(fileName.toLowerCase().endsWith(TEXT_FILE)){
			return new TextFileManager();
		}else if(fileName.toLowerCase().endsWith(BINARY_FILE)){
			return new BinaryFileManager();
		}else if(fileName.toLowerCase().endsWith(JSON_FILE)){
			return new JSONFileManager();
		}
		return null;
	}
}
