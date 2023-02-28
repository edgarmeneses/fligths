package co.edu.uptc.fligths.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import co.edu.uptc.fligths.service.FIleOperations;
/**
 * Clase que usa la interface FileOperations
 * En esta clase se implementan los metodos read y write que permiten leer y escribir
   un fichero de texto
 * @version 1.0.0
 * @author Edgar Antonio Meneses Cadena
 *
 */
public class FileOperationsImpl implements FIleOperations{

	/**
	 * Metodo que permite escribir una linea en un fiechero de texto
	 * @param path indica la ruta donde se va a almacenar el archivo ej:(src/resources/file.txt)
	 * @param info es el objecto o dato que se va a almacenar en el archivo
	   El param info puede ser un objecto como la clase Arplane, Customer e incluso un dato 
	   primitivo como un int o un String y se apoya del metodo toString de la clase u objeto
	   para guardar la linea en el archivo
	   
	   Cuando se esten guardando informacion en el archivos se recomienda usar la estrategia 
	   implementada en los archivos CSV es decir separar cada atributo de la clase por comas,
	   punto y comas o el delimitador de su preferencia. 
	   
	 * En caso de no encontrar la ruta o si el archivo ya esta abiero se genera una excepcion
	   del tipo IoException. Si el archivo no existe en la ruta se crea atomaticamente
	   
	   Siempre que se escriba en un archivo al finalizar el proceso se debe cerrar dicho archivo
	   No solo para liberar recursos en el equipo si no tambien para confirmar los cambios agregados
	   adicionalmente si no se cierra el archivo este se bloquea por lo que no puede ser
	   escrito o leido por otro recurso hasta que se libere este bloqueo
	 */
	@Override
	public void write(String path, Object info) {
		// Se usa la clase java.io.File para cargar el archivo que se va a leer o escribir
		File file = new File(path);
	
		try {
			// Cuando se quiere escribir en un archivo se usa la clase FileWrite que permite
			// escribir datos en forma de caracteres en un archivo
			// El constructor de la clase FileWriter requiere de dos parametros
			// El primer parametro es el archivo sobre el cual se va ha escribir la informacion
			// El segundo parametro indica si se quiere borrar y sobreescribir todo el archivo o no
			// El valor por default para el parametro es false y cuando este esta seteado en dicho
			// Valor el archivo se sobre escribe completamente
			FileWriter fileWriter = new FileWriter(file, true);
			// Para el manejo de archivos de texto se pueden usar dos clases que complementan
			// y mejoran el performance al momento de bajar datos a disco
			// Estas clases son BufferWriter y PrintWriter
			// COn PrintWritter podes imprimir en el archivo un buffer de datos 
			// Tiene metodos como el write, el append que permiten bajar la informacion al archivo
			// Pero tambien se puede hacer uso del metodo print y println
			// Con print simplemente se pinta la informacion en el archivo
			// Con println se pinta y ademas se realiza un salto de linea en el archivo
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(info.toString());
			//printWriter.append(info.toString()).append("\n");
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * Metodo que permite leer un archivo
	 
	 * Si no se encuentra el archivo se genera una excepcion del tipo FileNotFoundException
	   Tambien se debe manejar la IOExcepcion por si falla la apertura del archivo
	   No es necesario lanzar la excepcion del tipo FileNotFoundException pues es de tipo
	   IOException asi que solo es necesario alnzar esta ultima
	 * @param path es la ruta donde se encuentra el archivo que se quiere leer
	 *
	 */
	@Override
	public String read(String path) {
		File file = new File(path);
		StringBuilder builder = new StringBuilder();
		// Se usa la asignacion de scanner dentro del try para no tener que usar el 
		// Metodo close y cerrar el archivo
		try (Scanner scanner = new Scanner(file)) {
			// Con el delimitador se indica en que momento durante la lectura del archivo
			// Se encuentra otra linea
			scanner.useDelimiter("\n");
			// con hasNext se valida si existe una siguente pocision
			while (scanner.hasNext()) {
				// scanner.next() se obtiene el siguente valor
				// tambien se puede usar scanner.nextInt(), nextDouble() ...
				builder.append(scanner.next()).append("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}

}
