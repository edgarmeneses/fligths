package co.edu.uptc.fligths.model;

import java.util.Objects;

public class Person {
	String fullName;
	String documentNumber;
	DocumentType documentType;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String fullName, String documentNumber, DocumentType documentType) {
		super();
		this.fullName = fullName;
		this.documentNumber = documentNumber;
		this.documentType = documentType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentNumber, documentType, fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(documentNumber, other.documentNumber) && documentType == other.documentType
				&& Objects.equals(fullName, other.fullName);
	}
}
