package co.edu.uptc.fligths.service;

public interface FIleOperations {
	void write(String path, Object info);
	String read(String path);
}
