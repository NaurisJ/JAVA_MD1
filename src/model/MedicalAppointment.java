package model;

import java.time.LocalDateTime;

public class MedicalAppointment {

	// mainigie
	private long aID;
	private Patient patient;
	private Doctor doctor;
	private LocalDateTime datetime;
	private String cabinet;
	
	private static long counter = 0;


	
	// getter
	
	public long getaID() {
		return aID;
	}

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public String getCabinet() {
		return cabinet;
	}

	
	// setter
	
	public void setaID() {
		aID = counter++;
	}
	
	public void setPatient(Patient inputPatient) {
		if (inputPatient != null) {
			patient = inputPatient;
		} else {
			patient = new Patient();
		}
	}
	
	public void setDoctor(Doctor inputDoctor) {
		if (inputDoctor != null) {
			doctor = inputDoctor;
		} else {
			doctor = new Doctor();
		}
	}
	
	public void setDateTime(LocalDateTime inputDateTime){
		if (inputDateTime.isAfter(LocalDateTime.now()) || inputDateTime.equals(LocalDateTime.now())) {
			datetime = inputDateTime;
		} else {
			throw new IllegalArgumentException("Appointment cannot be set in the past.");
		}
	}
	
	public void setCabinet(String inputCabinet) {
		if (inputCabinet != null
				&& inputCabinet.matches("[A-Za-z1-90]{1,6}")) {
			cabinet = inputCabinet;
		} else {
			cabinet = "unknown";
		}
	}
	
	
	// bez arg konstruktors
	public MedicalAppointment() {
		setaID();
		setPatient(new Patient());
		setDoctor(new Doctor());
		setDateTime(LocalDateTime.now().plusDays(1));
		setCabinet("C106");
	}
	
	
	// arg konstruktors
	public MedicalAppointment(Patient patient, Doctor doctor, LocalDateTime datetime, String cabinet) {
		setaID();
		setPatient(patient);
		setDoctor(doctor);
		setDateTime(datetime);
		setCabinet(cabinet);
	}
	
	
	// toString
	
	public String toString() {
		return "| ID: " + aID + " | PATIENT: " + patient.getName().charAt(0) + ". " + patient.getSurname()
		+ " | Doctor: " + doctor.getName().charAt(0) + ". " + doctor.getSurname() + " | DATE: " + datetime
		+ " | CABINET: " + cabinet;
	}
	
	
	
}
