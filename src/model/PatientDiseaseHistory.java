package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.print.attribute.standard.PresentationDirection;

public class PatientDiseaseHistory {
	
	
	// mainigie
	private long hID;
	private LocalDate diseaseStartingDate;
	private boolean isPresent;
	private Disease disease;
	private Doctor treatingDoctor;
	private String notes;
	private int severity;
	
	private Patient patient;
	
	private ArrayList<Medicine> prescribedMedicines = new ArrayList<Medicine>();

	private static long counter = 0;
	
	// getter
	
	public long gethID() {
		return hID;
	}
	public LocalDate getDiseaseStartingDate() {
		return diseaseStartingDate;
	}
	public boolean isPresent() {
		return isPresent;
	}
	public Disease getDisease() {
		return disease;
	}
	public Doctor getTreatingDoctor() {
		return treatingDoctor;
	}
	public String getNotes() {
		return notes;
	}
	public int getSeverity() {
		return severity;
	}
	public ArrayList<Medicine> getPrescribedMedicines() {
		return prescribedMedicines;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	// setter
	
	public void sethID() {
		hID = counter++;
	}
	
	public void setPatient(Patient patient) {
		if (patient != null) {
			this.patient = patient;
		} else {
			this.patient = new Patient();
		}
	}
	
	public void setDiseaseStartingDate(LocalDate inputDiseaseStartingDate) {
	    if (inputDiseaseStartingDate != null) {
	        diseaseStartingDate = inputDiseaseStartingDate;
	    } else {
	        diseaseStartingDate = LocalDate.now();
	    }
	}

	
	public void setIsPresent(boolean inputIsPresent) {
		isPresent = inputIsPresent;
	}
	public void setDisease(Disease inputDesease) {
		if (inputDesease != null) {
			disease = inputDesease;
		} else {
			disease = Disease.cits;
		}
	}
	
	public void setTreatingDoctor(Doctor inputTreatingDoctor) {
		if (inputTreatingDoctor != null) {
			treatingDoctor = inputTreatingDoctor;
		} else {
			treatingDoctor = new Doctor();
		}
	}
	public void setNotes(String inputNotes) {
		if (inputNotes != null
				&& inputNotes.matches("[A-Za-z1-9!@#$%^&*()-+'\", ]{1,200}")) {
			notes = inputNotes;
		} else {
			notes = "NO NOTES!";
		}
	}
	
	public void setSeverity(int inputSeverity) {
		if (inputSeverity > 0 && inputSeverity <= 10) {
			severity = inputSeverity;
		} else {
			severity = 0;
		}
	}
	
	public void setPrescribedMedicines(ArrayList<Medicine> inputPrescribedMedicines) throws NullPointerException{
		if (inputPrescribedMedicines != null) {
//			prescribedMedicines.add(inputPrescribedMedicines);
			for (Medicine tempM : inputPrescribedMedicines) {
				prescribedMedicines.add(tempM);
			}
			
		} else {
			throw new NullPointerException("Medicine cannot be null!");
		}
	}
	
	// bez arg konstruktors
	public PatientDiseaseHistory() {
		sethID();
		setDiseaseStartingDate(LocalDate.now());
		setIsPresent(true);
		setDisease(Disease.astma);
		setTreatingDoctor(new Doctor());
		setNotes("");
		setSeverity(0);
		setPrescribedMedicines(new ArrayList<Medicine>());
		setPatient(new Patient());
	}
	
	// arg konstruktors
	
	public PatientDiseaseHistory(LocalDate inputDate, boolean inputIsPresent, Disease inputDisease,
			Doctor inputDoctor, String inputNotes, int inputSeverity, ArrayList<Medicine> inputPrescribedMedicine, Patient patient) {
		sethID();
		setDiseaseStartingDate(inputDate);
		setIsPresent(inputIsPresent);
		setDisease(inputDisease);
		setTreatingDoctor(inputDoctor);
		setNotes(inputNotes);
		setSeverity(inputSeverity);
		setPrescribedMedicines(inputPrescribedMedicine);
		setPatient(patient);
		
	}
	
	
	public void updateMedicine(Medicine inputMedicine) {
		boolean found = false;
		if (!prescribedMedicines.isEmpty()) {
			for (Medicine tempM : prescribedMedicines) {
				if (tempM.equals(inputMedicine)) {
					prescribedMedicines.remove(tempM);
					found = true;
					break;
				}
			}
			if (found == false) {
				prescribedMedicines.add(inputMedicine);
			}
			
		}
		
	}
	
	// toString
	
	public String toString() {
		return "ID: " + hID + " | DISEASE: " + disease + " | IS PRESENT?: " + isPresent + " | SEVERITY: " + severity
				+ " | DOCTOR: " + treatingDoctor.getName().charAt(0) + ". " + treatingDoctor.getSurname();
	}
	
	
	
	
	
	
}
