package co.edu.uptc.fligths.service;

import co.edu.uptc.fligths.service.impl.FileOperationsImpl;

public interface FIleOperations {
	void write(String path, Object info);
	String read(String path);
	static FIleOperations getInstance() {
		return FileOperationsImpl.getInstance();
	}
}
