package model;


public class Doctor extends Person{
	private long dID;
	private String certificateNumber;
	private float experienceInYears;
	private DoctorType doctortype;

	
	private static long counter = 0;
	
	
	// getter
	public long getdID() {
		return dID;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public float getExperienceInYears() {
		return experienceInYears;
	}
	public DoctorType getDoctortype() {
		return doctortype;
	}

	
	// setter
	
	
	public void setdID() {
		dID = counter++;
	}
	
	public void setCertificateNumber(String inputCertificateNumber) {
		if (inputCertificateNumber != null
				&& inputCertificateNumber.matches("[A-Za-z1-9]{3,20}")) {
			certificateNumber = inputCertificateNumber;
		} else {
			certificateNumber = "unknown";
		}
	}
	
	public void setExperienceInYears(float inputExperienceInYears) {
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
	

	
	
	// bez argumenta konstruktors
	
	public Doctor() {
		super();
		setdID();
		setCertificateNumber("AF17375");
		setExperienceInYears(5);
		setDoctorType(DoctorType.kirurgs);
	
	}
	
	// argumenta konstruktors
	
	public Doctor(String name, String surname, String personCode, String inputCertificateNumber, float inputExperienceInYears, DoctorType inputDoctorType) {
		super(name,surname,personCode);
		setdID();
		setCertificateNumber(inputCertificateNumber);
		setExperienceInYears(inputExperienceInYears);
		setDoctorType(inputDoctorType);

	}
	
	// toString funkcija
	
	@Override
	
	public String toString() {
		return "ID: " + dID + " | " + super.getName().charAt(0) + " " + super.getSurname() + " | Person Code -  " + super.getPersonCode() + "| Type -  " + doctortype + " | Expereince - "
				+ experienceInYears + " years" + " | Certification number - " + certificateNumber;
	}
}
