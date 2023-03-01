package co.edu.uptc.fligths.presenter;

import java.util.List;

import co.edu.uptc.fligths.app.Constants;
import co.edu.uptc.fligths.mapper.AirplaneMapper;
import co.edu.uptc.fligths.model.AirplanType;
import co.edu.uptc.fligths.model.Airplane;
import co.edu.uptc.fligths.service.FIleOperations;
import co.edu.uptc.fligths.view.AirplanView;
import co.edu.uptc.fligths.view.menu.Messages;
import co.edu.uptc.fligths.view.output.OutputData;

public class AirplanePresenter {
	private List<Airplane> airplanes;
	private static AirplanePresenter airplanePresenter;
	
	private AirplanePresenter() {
		airplanes = loadAirplanes();
	}
	
	private List<Airplane> loadAirplanes() {
		String airplanes = FIleOperations.getInstance().read(Constants.AIRPLANE_PATH);
		return AirplaneMapper.getInstance().stringToAirplanes(airplanes, "\n");
	}
	
	private void createAndWriteNewAirplane() {
		String airplaneClass = AirplanView.readAirplanClass();
		AirplanType type = AirplanView.readAirplanType();
		int capacity = AirplanView.readCapacity();
		long code = AirplanView.readCode();
		Airplane airplane = new Airplane(airplaneClass, type, capacity, code);
		
		airplanes.add(airplane);
		
		FIleOperations.getInstance().write(Constants.AIRPLANE_PATH, airplane);
	}

	public void runAirplaneMenu(int option) {
		switch (option) {
		case 1:
			createAndWriteNewAirplane();
			Messages.success();
			break;
		case 2:
			Messages.buildingAction();
			break;
		case 3:
			OutputData.showList(airplanes);
			break;
		case 4:
			Messages.buildingAction();
			break;
		default:
			Messages.invalidOption();
		}
	}
	
	public static AirplanePresenter getInstance() {
		if(airplanePresenter == null) {
			airplanePresenter = new AirplanePresenter();
		}
		return airplanePresenter;
	}
}
