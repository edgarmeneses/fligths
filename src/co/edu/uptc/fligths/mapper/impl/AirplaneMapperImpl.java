package co.edu.uptc.fligths.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.fligths.mapper.AirplaneMapper;
import co.edu.uptc.fligths.model.AirplanType;
import co.edu.uptc.fligths.model.Airplane;

public class AirplaneMapperImpl implements AirplaneMapper{
	
	private static AirplaneMapper airplaneMapper;
	
	private Airplane stringToAirplane(String line) {
		
		String [] airplaneData = line.split(";");
		Airplane airplane = new Airplane();
		airplane.setAirplanClass(airplaneData[2]);
		airplane.setCode(Long.parseLong(airplaneData[0]));
		airplane.setType(AirplanType.valueOf(airplaneData[1]));
		airplane.setCapacity(Integer.parseInt(airplaneData[3]));
		return airplane;
	}

	@Override
	public List<Airplane> stringToAirplanes(String airplanes, String useDelimiter) {
		String [] lines = airplanes.split(useDelimiter);
		List<Airplane> airplanesData = new ArrayList<>();
		
		for (int i = 0; i < lines.length; i++) {
			airplanesData.add(stringToAirplane(lines[i]));
		}
		return airplanesData;
	}
	
	public static AirplaneMapper getInstance() {
		if(airplaneMapper == null) {
			airplaneMapper = new AirplaneMapperImpl();
		}
		return airplaneMapper;
	}

}
