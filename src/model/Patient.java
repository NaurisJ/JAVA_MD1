package model;

import java.util.ArrayList;

public class Patient extends Person{
	
	private long pID;
	private Address address;
	private String phoneNo;
	private ArrayList<PatientDiseaseHistory> history = new ArrayList<PatientDiseaseHistory>();
	private String patientCode;
	
	private long counter = 0;


	
	// getter
	
	public long getpID() {
		return pID;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}


	public String getPatientCode() {
		return patientCode;
	}

	public long getCounter() {
		return counter;
	}
	
	// setter
	
	public void setpID() {
		pID = counter++;
	}
	
	public void setAddress(Address inputAddress) {
		if (inputAddress != null) {
			address = inputAddress;
		} else {
			address = new Address();
		}
	}
	
	public void setPhoneNo(String inputPhoneNo) {
		if (inputPhoneNo != null
				&& inputPhoneNo.matches("[1-9]{8}")) {
			phoneNo = inputPhoneNo;
		} else {
			phoneNo = "UNKNOWN";
		}
	}
	
	public void addNewHistoryRecord(PatientDiseaseHistory historyRecord) throws NullPointerException {
		if (historyRecord != null) {
			history.add(historyRecord);
		} else {
			throw new NullPointerException("NOTHING TO ADD!");
		}
	}
	
	public void setPatientCode() {
		if (this.getSurname() != null && this.getName() != null && this.getPersonCode() != null) {
			patientCode = this.getSurname().charAt(0) + "_" + this.getName().charAt(0) + "_" + this.getPersonCode();
		}
	}
	
	// bez arg konstruktors
	
	public Patient() {
		setpID();
		setAddress(new Address());
		setPhoneNo("00000000");
		setPatientCode();
	}
	
	// arg konstruktors
	
	public Patient(String name, String surname, String personCode, Address address, String phone) {
		super(name,surname,personCode);
		setAddress(address);
		setPhoneNo(phone);
		setPatientCode();
	}
	
	
	// toString
	
	public String toString() {
		return "ID: " + pID + " | NAME: " + super.getName().charAt(0) + ". " + super.getSurname() +
				" | ADDRESS: " + address + " | PHONE NO: " + phoneNo + " | PATIENT CODE: " + patientCode;
	}

}
