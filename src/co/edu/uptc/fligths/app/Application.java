package co.edu.uptc.fligths.app;

import co.edu.uptc.fligths.service.FIleOperations;
import co.edu.uptc.fligths.service.impl.FileOperationsImpl;

public class Application {
	static final String PATH = "src/resources/prueba1.txt";
	public static void main(String[] args) {
		FIleOperations operations = new FileOperationsImpl();
		operations.write(PATH, "hola");
		operations.write(PATH, "hola1");
		operations.write(PATH, "hola2");
		operations.write(PATH, "hola3");
		System.out.println(operations.read(PATH));
		System.out.println("Run SUCCESS");
		
	}
}
