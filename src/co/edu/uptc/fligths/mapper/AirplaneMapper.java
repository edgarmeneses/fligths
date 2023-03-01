package co.edu.uptc.fligths.mapper;

import java.util.List;

import co.edu.uptc.fligths.mapper.impl.AirplaneMapperImpl;
import co.edu.uptc.fligths.model.Airplane;

public interface AirplaneMapper {
	 List<Airplane> stringToAirplanes(String airplanes, String useDelimiter);
	 
	 public static AirplaneMapper getInstance() {
		return  AirplaneMapperImpl.getInstance();
	}
}
