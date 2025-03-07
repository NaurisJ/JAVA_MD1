package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Address;
import model.City;
import model.Disease;
import model.Doctor;
import model.DoctorType;
import model.MedicalAppointment;
import model.Medicine;
import model.Patient;
import model.PatientDiseaseHistory;
import model.Person;

public class MainService {

	private static ArrayList<Doctor> allDoctors = new ArrayList<Doctor>();
	private static ArrayList<Patient> allPatients = new ArrayList<Patient>();
	private static ArrayList<Medicine> allMedicines = new ArrayList<Medicine>();
	private static ArrayList<MedicalAppointment> allAppointments = new ArrayList<MedicalAppointment>();
	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	private static ArrayList<PatientDiseaseHistory> allPatientDiseaseHistory = new ArrayList<PatientDiseaseHistory>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Doctor d1 = new Doctor();
		Doctor d2 = new Doctor("Gudrais","Arsts","231069-12345","AF23532",15,DoctorType.kirurgs);
		
		allDoctors.add(d1);
		
		Patient p1 = new Patient();
		Patient p2 = new Patient("Barry","Smith","200387-12345",new Address(City.Liepaja,"Lielais Prospekts","23B"),"21458375");
		
		
		MedicalAppointment ma1 = new MedicalAppointment();
		MedicalAppointment ma2 = new MedicalAppointment(p2,d2,LocalDateTime.now(),"C106");
		MedicalAppointment ma3 = new MedicalAppointment(p2,d1,LocalDateTime.now().plusDays(10),"A305");
		
		allAppointments.add(ma1);
		allAppointments.add(ma2);
		allAppointments.add(ma3);
		
		ArrayList<Medicine> m1 = new ArrayList<Medicine>();
		Medicine med1 = new Medicine("ASTMAHELPER", 200, "USE WITH RISK", "CRAZYCOMPANY");
		m1.add(med1);
		
		
		PatientDiseaseHistory pdh1 = new PatientDiseaseHistory();
		PatientDiseaseHistory pdh2 = new PatientDiseaseHistory(LocalDate.now().minusDays(10),true,Disease.astma,d2,
				"MILD SYMPTOMS",5,m1,p2);
		
		pdh1.setPatient(p2);
		pdh2.setPatient(p2);
	
		allPatientDiseaseHistory.add(pdh1);
		allPatientDiseaseHistory.add(pdh2);
		
//		System.out.println(createNewPatientDiseaseHistoryForPatientByPatientCode(null, null, null, d2, null, 0, m1));
		
		
		

		

		
		try {
			createDoctor("James","Dweller","295465-21754","AF2351",2,DoctorType.gimenes_arsts);
			System.out.println();
//			createDoctor("James","Dweller","295465-21754","AF2351",2,DoctorType.gimenes_arsts);
			System.out.println(allDoctors);
			
			
			System.out.println("RETRIEVE ALL MEDICAL APPOINTMENTS FOR PACIENT");
			System.out.println(retrieveAllMedicalAppointmentsForPatientByPatientCode("200387-12345"));
			
			System.out.println("RETRIEVE PACIENT MEDICAL HISTORY");
			System.out.println(retrieveAllPatientDiseaseHistoryForPatientByPatientCode("S_B_200387-12345"));
			
			int[] doctorStats = retrieveStatisticsOfDoctorsByType();

			DoctorType[] types = DoctorType.values();
			for (int i = 0; i < doctorStats.length; i++) {
			    System.out.println(types[i] + ": " + doctorStats[i]);
			}
			

			
			System.out.println("RETRIEVE DOCTOR APPOINTMENTS TODAY");
			System.out.println(retrieveAllMedicalAppointmentForDoctorTodayByPersonCode("123456-12345"));
			
			
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
	
	public static void updateDoctorExperienceByPersonCode(String personCode, float experienceInYears) throws Exception{
		
		Doctor foundDoctor = retrieveDoctorByPersonCode(personCode);
		
		if (experienceInYears != 0
				&& foundDoctor.getExperienceInYears() == experienceInYears) {
			foundDoctor.setExperienceInYears(experienceInYears);
		}
	}
	
	// D - delete
	
	public static void removeDoctorByPersonCode(String personCode) throws Exception{
		
		Doctor foundDoctor = retrieveDoctorByPersonCode(personCode);
		
		if (foundDoctor != null) {
			allDoctors.remove(foundDoctor);
		}
	}
	
	public static ArrayList<MedicalAppointment> retrieveAllMedicalAppointmentsForPatientByPatientCode(String patientCode) throws Exception{
		
		ArrayList<MedicalAppointment> resultArray = new ArrayList<MedicalAppointment>();
		
		for (MedicalAppointment tempMA : allAppointments) {
			if (tempMA.getPatient().getPersonCode().equals(patientCode)) {
				resultArray.add(tempMA);
			}
		}
		
		if (resultArray.size() > 0) {
			return resultArray;
		} else {
			throw new Exception("NO DATA FOUND!");
		}
	}
	
	public static ArrayList<PatientDiseaseHistory> retrieveAllPatientDiseaseHistoryForPatientByPatientCode(String patientCode) throws Exception{
		
		ArrayList<PatientDiseaseHistory> resultArray = new ArrayList<PatientDiseaseHistory>();
		
		for (PatientDiseaseHistory tempPDH : allPatientDiseaseHistory) {
			System.out.println(tempPDH.getPatient().getPatientCode());
			if (tempPDH.getPatient().getPatientCode().equals(patientCode)) {
				resultArray.add(tempPDH);
			}
		}
		
		if (resultArray.size() > 0) {
			return resultArray;
		} else {
			throw new Exception("NO DATA FOUND!");
		}
		
	}
	
	public static ArrayList<MedicalAppointment> retrieveAllMedicalAppointmentForDoctorTodayByPersonCode(String personCode) throws Exception{
		
		ArrayList<MedicalAppointment> resultArray = new ArrayList<MedicalAppointment>();
		
		for (MedicalAppointment tempMA : allAppointments) {
	        if (tempMA.getDatetime().toLocalDate().equals(LocalDate.now())
	                && tempMA.getDoctor().getPersonCode().equals(personCode)) {
				resultArray.add(tempMA);
			}
		}
		
		if (resultArray.size() > 0) {
			return resultArray;
		} else {
			throw new Exception("NO DATA FOUND!");
		}
	}
	
	public static void createNewPatientDiseaseHistoryForPatientByPatientCode(String patientCode, LocalDate diseaseStartingDate, Disease disease,
			Doctor treatingDoctor, String notes, int severity, ArrayList<Medicine> prescribedMedicines) {
		
		ArrayList<PatientDiseaseHistory> PDH = new ArrayList<PatientDiseaseHistory>();
		
		if (patientCode != null && diseaseStartingDate != null && disease != null && treatingDoctor != null
				&& notes != null && severity != 0 && prescribedMedicines != null) {
			for (Patient tempP : allPatients) {
				if (tempP.getPersonCode().equals(patientCode)) {
					PatientDiseaseHistory newPDH = new PatientDiseaseHistory(diseaseStartingDate,true,disease,treatingDoctor,notes,severity,
							prescribedMedicines,tempP);
					allPatientDiseaseHistory.add(newPDH);
					
				}
			}
		}
	}
	
//	public static void prescribeMedicationsForPatientByPatientCode(String patientCode, Disease disease, Medicine medicine) {
//		
//		if (patientCode != null && disease != null && medicine != null) {
//			for (Patient tempP : allPatients) {
//				if (tempP.getPatientCode().equals(patientCode)) {
//					
//				}
//			}
//		}
//	}
	
	public static ArrayList<MedicalAppointment> retrieveAllMedicalAppointmentByDisease(Disease disease) throws Exception{
		
		ArrayList<MedicalAppointment> resultArray = new ArrayList<MedicalAppointment>();
		
		if (disease != null) {
			for (MedicalAppointment tempMA : allAppointments) {
				Patient patient = tempMA.getPatient();
				
				for (PatientDiseaseHistory pdh : allPatientDiseaseHistory) {
					if (pdh.getPatient().equals(patient) && pdh.getDisease().equals(disease)) {
						resultArray.add(tempMA);
					}
				}
			}
		}
		
		if (resultArray.size() > 0) {
			return resultArray;
		} else {
			throw new Exception("NO DATA FOUND!");
		}
		
	}
	
	public static ArrayList<Doctor> retrieveAllDoctorsByType(DoctorType doctorType) throws Exception{
		
		ArrayList<Doctor> resultArray = new ArrayList<Doctor>();
		
		if (doctorType != null) {
			for (Doctor tempD : allDoctors) {
				if (tempD.getDoctortype().equals(doctorType)) {
					resultArray.add(tempD);
				}
				
			}
			
		}
		if (resultArray.size() > 0) {
			return resultArray;
		} else {
			throw new Exception("NO DATA FOUND!");
		}
		
	}
	
	public static ArrayList<Patient> retrieveAllPatientsByCity(City city) throws Exception{
		
		ArrayList<Patient> resultArray = new ArrayList<Patient>();
		
		if (city != null) {
			for (Patient tempP : allPatients) {
				if (tempP.getAddress().getCity().equals(city)) {
					resultArray.add(tempP);
				}
			}
		}
		if (resultArray.size() > 0) {
			return resultArray;
		} else {
			throw new Exception("NO DATA FOUND!");
		}
	}
	
	public static int[] retrieveStatisticsOfDoctorsByType() {
	 int[] result = new int[DoctorType.values().length];

	    for (Doctor tempD : allDoctors) {
	        for (int i = 0; i < DoctorType.values().length; i++) {
	            if (tempD.getDoctortype().equals(DoctorType.values()[i])) {
	            	result[i] += 1;
	            }
	        }
	    }
	    
	    return result;
	}
	
	public static void sortDoctorsByExperienceByType(DoctorType doctorType) {

		    int n = allDoctors.size();
		    for (Doctor tempDT : allDoctors) {
		    	if (tempDT.getDoctortype().equals(doctorType)) {
				    for (int i = 0; i < n - 1; i++) {
				        for (int j = 0; j < n - i - 1; j++) {
				            if (allDoctors.get(j).getExperienceInYears() < allDoctors.get(j + 1).getExperienceInYears()) {
				                // Swap doctors
				                Doctor temp = allDoctors.get(j);
				                allDoctors.set(j, allDoctors.get(j + 1));
				                allDoctors.set(j + 1, temp);
				            }
				        }
				    }
		    }
		    }
		

	}
	


}
