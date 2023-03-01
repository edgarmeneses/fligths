package co.edu.uptc.fligths.presenter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.fligths.model.Pilot;
import co.edu.uptc.fligths.model.Route;
import co.edu.uptc.fligths.service.FIleOperations;
import co.edu.uptc.fligths.service.impl.FileOperationsImpl;
import co.edu.uptc.fligths.view.input.InputData;
import co.edu.uptc.fligths.view.menu.Menu;
import co.edu.uptc.fligths.view.menu.Messages;

public class Airline {
	List<Pilot> pilots;
	List<Route> routes;
	FIleOperations operations;
	
	private static Airline airline; 
	
	private Airline() {
		pilots = new ArrayList<>();
		routes = new ArrayList<>();
		operations = new FileOperationsImpl();
	}
	
	public void runApp() {
		int option = 0;
		Menu.getGeneralMenu();
		while((option = InputData.getInstance().readOption()) != -1) {
			switch (option) {
			case 1:
				Menu.getAirplanesMenu();
				int menuOption = InputData.getInstance().readOption();
				AirplanePresenter.getInstance().runAirplaneMenu(menuOption);
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
