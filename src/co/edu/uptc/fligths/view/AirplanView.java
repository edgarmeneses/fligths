package co.edu.uptc.fligths.view;

import co.edu.uptc.fligths.model.AirplanType;
import co.edu.uptc.fligths.view.input.InputData;

public class AirplanView {
	public static String readAirplanClass() {
		return InputData.getInstance().readText("Write the ariplane class");
	}
	
	public static AirplanType readAirplanType() {
		return AirplanType.valueOf(InputData.getInstance().readText("Write the airplane type values (AIRBUS, BOEING OR ANTONOB)"));
	}
	
	public static int readCapacity() {
		return InputData.getInstance().readOption("Write the airplan capacity");
	}
	
	public static long readCode() {
		return InputData.getInstance().readLong("Write the airplan code");
	}
}
