package co.edu.uptc.fligths.model;

import java.util.Objects;

public class Coordinate {
	String departure;
	String arrival;
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}

	public Coordinate(String departure, String arrival) {
		super();
		this.departure = departure;
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrival, departure);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return Objects.equals(arrival, other.arrival) && Objects.equals(departure, other.departure);
	}

	@Override
	public String toString() {
		return departure + ";" + arrival;
	}
}
