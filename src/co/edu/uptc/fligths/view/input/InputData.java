package co.edu.uptc.fligths.view.input;

import java.util.Scanner;

public class InputData {
	private static InputData inputData;
	private Scanner scanner;
	
	private InputData() {
		scanner = new Scanner(System.in);
	}
	
	public static InputData getInstance() {
		if(inputData == null) {
			inputData = new InputData();
		}
		return inputData;
	}
	
	public int readOption(String message) {
		System.out.println(message);
		return scanner.nextInt();
	}
	
	public int readOption() {
		return readOption("Choose an option");
	}
	
	public long readLong(String message) {
		System.out.println(message);
		return scanner.nextLong();
	}
	
	public String readText(String message) {
		System.out.println(message);
		return scanner.next();
	}

}
