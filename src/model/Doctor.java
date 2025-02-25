package model;

import model.Person;

public class Doctor {
	private long dID;
	private long certificateNumber;
	private int experienceInYears;
	DoctorType doctortype;
	Person person;
	
	private long counter = 0;
	
	
	// getter
	public long getdID() {
		return dID;
	}
	public long getCertificateNumber() {
		return certificateNumber;
	}
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public DoctorType getDoctortype() {
		return doctortype;
	}
	public Person person() {
		return person;
	}
	
	// setter
	
	
	public void setdID() {
		dID = counter++;
	}
	
	public void setCertificateNumber(long inputCertificateNumber) {
		// TODO - noskaidrot kas ieklaujas certificate number
	}
	
	public void setExperienceInYears(int inputExperienceInYears) {
		if (inputExperienceInYears < 50 && inputExperienceInYears > 0) {
			experienceInYears = inputExperienceInYears;
		} else {
			experienceInYears = 0;
		}
	}
	
	public void setDoctorType(DoctorType inputDoctorType) {
		if (inputDoctorType != null) {
			doctortype = inputDoctorType;
		} else {
			doctortype = DoctorType.cits;
		}
	}
	
	public void setPerson(Person inputPerson) {
		if (inputPerson != null) {
			person = inputPerson;
		} else {
			person = new Person();
		}
	}
	
	
	// bez argumenta konstruktors
	
	public Doctor() {
		setdID();
		setCertificateNumber(123);
		setExperienceInYears(5);
		setDoctorType(DoctorType.kirurgs);
		setPerson(new Person());	
	}
	
	// argumenta konstruktors
	
	public Doctor(long inputCertificateNumber, int inputExperienceInYears, DoctorType inputDoctorType, Person inputPerson) {
		setdID();
		setCertificateNumber(inputCertificateNumber);
		setExperienceInYears(inputExperienceInYears);
		setDoctorType(inputDoctorType);
		setPerson(inputPerson);
	}
	
	// toString funkcija
	
	@Override
	
	public String toString() {
		return "ID: " + dID + " | " + person.getName().charAt(0) + " " + person.getSurname() + " | Type -  " + doctortype + " | Expereince - "
				+ experienceInYears + " years" + " | Certification number - " + certificateNumber;
	}
}
