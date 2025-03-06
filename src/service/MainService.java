package service;

import java.util.ArrayList;

import model.Doctor;
import model.DoctorType;
import model.MedicalAppointment;
import model.Medicine;
import model.Patient;
import model.Person;

public class MainService {

	private static ArrayList<Doctor> allDoctors = new ArrayList<Doctor>();
	private static ArrayList<Patient> allPatients = new ArrayList<Patient>();
	private static ArrayList<Medicine> allMedicines = new ArrayList<Medicine>();
	private static ArrayList<MedicalAppointment> allAppointments = new ArrayList<MedicalAppointment>();
	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Doctor d1 = new Doctor();
		
		allDoctors.add(d1);
		try {
			createDoctor("James","Dweller","295465-21754","AF2351",2,DoctorType.gimenes_arsts);
			System.out.println();
//			createDoctor("James","Dweller","295465-21754","AF2351",2,DoctorType.gimenes_arsts);
			System.out.println(allDoctors);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// CRUD
	// Pievienot jaunu dakteri
	//  C - create
	public static void createDoctor(String name, String surname, String personCode, String certificateNumber, float experienceInYears, DoctorType doctorType) throws Exception{
		
		for (Doctor tempD : allDoctors) {
			if (tempD.getName().equals(name) && tempD.getSurname().equals(surname) && tempD.getPersonCode().equals(personCode)
					&& tempD.getCertificateNumber().equals(certificateNumber) && tempD.getDoctortype().equals(doctorType) && tempD.getExperienceInYears() == experienceInYears) {
				throw new Exception("Doctor already exists");
			}
		}
		allDoctors.add(new Doctor(name,surname,personCode,certificateNumber,experienceInYears,doctorType));
	}
	
	// R - retrieve
	public static Doctor retrieveDoctorByPersonCode(String personCode) throws Exception{
		for (Doctor tempD : allDoctors) {
			if (tempD.getPersonCode().matches(personCode)) {
				return tempD;
			}
		
		}
		throw new Exception("Professor with this personCode doesn't exist");
		
	}
	
	
	// U - update
	
	public static void updateDoctorCertificateNumberNoByPersonCode(String personCode, String inputCertificateNumber) throws Exception {
		Doctor foundDoctor = retrieveDoctorByPersonCode(personCode);
		
		if (inputCertificateNumber != null && 
				!foundDoctor.getCertificateNumber().equals(inputCertificateNumber)) {
			foundDoctor.setCertificateNumber(inputCertificateNumber);
		}
	}
	
	public static void updateDoctorExperienceByPersonCode(String personCode, float experienceInYears) {
		
	}

}
