package co.edu.uptc.fligths.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import co.edu.uptc.fligths.service.FIleOperations;

public class FileOperationsImpl implements FIleOperations{

	@Override
	public void write(String path, String info) {
		File file = new File(path);
	
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.append(info).append("\n");
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
