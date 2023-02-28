package co.edu.uptc.fligths.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pilot extends Person{
	String code;
	List<String> phoneNumber;
	String address;
	
	public Pilot(String fullName, String documentNumber, DocumentType documentType, String address) {
		super(fullName, documentNumber, documentType);
		this.address = address;
		this.phoneNumber = new ArrayList<>();
		this.setCode();
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addPhone(String phoneNumber) {
		this.phoneNumber.add(phoneNumber);
	}
	
	private void setCode() {
		this.code = this.getDocumentType() + "-" + this.getPhoneNumber();
	}
	
	public String getCode() {
		return this.code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(address, phoneNumber);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		return Objects.equals(address, other.address) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return code+";" + documentNumber + ";" +documentType + ";" +fullName + ";" + phoneNumber;
	}
}
