package co.edu.uptc.fligths.presenter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.fligths.model.AirplanType;
import co.edu.uptc.fligths.model.Airplane;
import co.edu.uptc.fligths.model.Pilot;
import co.edu.uptc.fligths.model.Route;
import co.edu.uptc.fligths.service.FIleOperations;
import co.edu.uptc.fligths.service.impl.FileOperationsImpl;
import co.edu.uptc.fligths.view.AirplanView;
import co.edu.uptc.fligths.view.input.InputData;
import co.edu.uptc.fligths.view.menu.Menu;
import co.edu.uptc.fligths.view.menu.Messages;

public class Airline {
	List<Airplane> airplanes;
	List<Pilot> pilots;
	List<Route> routes;
	FIleOperations operations;
	
	private static Airline airline; 
	
	private Airline() {
		airplanes = new ArrayList<>();
		pilots = new ArrayList<>();
		routes = new ArrayList<>();
		operations = new FileOperationsImpl();
	}
	
	public void runAirplaneMenu(int option) {
		switch (option) {
		case 1:
			String airplaneClass = AirplanView.readAirplanClass();
			AirplanType type = AirplanView.readAirplanType();
			int capacity = AirplanView.readCapacity();
			Airplane airplane = new Airplane(airplaneClass, type, capacity, capacity);
			
			
			break;
		default:
			Messages.invalidOption();
		}
	}
	
	public void runApp() {
		int option = 0;
		Menu.getGeneralMenu();
		while((option = InputData.getInstance().readOption()) != -1) {
			switch (option) {
			case 1:
				Menu.getAirplanesMenu();
				int menuOption = InputData.getInstance().readOption();
				System.out.println(menuOption);
				break;
			case 2:
				Messages.buildingAction();
				break;
			case 3:
				Messages.buildingAction();
				break;
			case 4:
				Messages.buildingAction();
				break;
			default:
				Messages.invalidOption();
				break;
			}
		}
	}
	
	public static Airline getInstance() {
		if(airline == null) {
			airline = new Airline();
		}
		return airline;
	}
}
