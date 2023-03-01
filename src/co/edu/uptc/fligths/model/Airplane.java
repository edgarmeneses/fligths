package co.edu.uptc.fligths.model;

import java.util.Objects;

public class Airplane {
	String airplanClass;
	AirplanType type;
	int capacity;
	long code;
	int chairsNumbers;
	String description;
	
	public Airplane() {
	}

	public Airplane(String airplanClass, AirplanType type, int capacity, long code) {
		super();
		this.airplanClass = airplanClass;
		this.type = type;
		this.capacity = capacity;
		this.code = code;
	}

	public String getAirplanClass() {
		return airplanClass;
	}

	public void setAirplanClass(String airplanClass) {
		this.airplanClass = airplanClass;
	}

	public AirplanType getType() {
		return type;
	}

	public void setType(AirplanType type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getChairsNumbers() {
		return chairsNumbers;
	}

	public void setChairsNumbers(int chairsNumbers) {
		this.chairsNumbers = chairsNumbers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airplanClass, capacity, code, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		return Objects.equals(airplanClass, other.airplanClass) && capacity == other.capacity && code == other.code
				&& type == other.type;
	}

	@Override
	public String toString() {
		return  code + ";" + type + ";" + airplanClass + ";" + capacity+";"+chairsNumbers+";"+description+";";
	}
}
