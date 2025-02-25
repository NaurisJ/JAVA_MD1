package model;

public class Person {
	
	// Mainigie
	private long pID;
	private String name;
	private String surname;
	private String personCode;
	
	private static long counter = 0;
	
	
	// getter
	public long getpID() {
		return pID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonCode() {
		return personCode;
	}
	
	// setter
	
	public void setpID() {
		pID = counter++;
	}
	
	public void setName(String inputName) {
		if (inputName != null
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			inputName = name;
		} else {
			name = "unknown";
		}
	}
	
	public void setSurname(String inputSurname) {
		if (inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
		surname = inputSurname;
		} else {
			surname = "unknown";
		}
	}
	
	
	public void setPersonCode(String inputPersonCode) {
		if (inputPersonCode.length() == 12) {
			inputPersonCode = personCode;
		} else {
			personCode = "000000-00000";
		}
	}
	
	// bez argumenta konstruktors
	
	public Person() {
		setpID();
		setName("Janis");
		setSurname("Berzins");
		setPersonCode("120302-12345");
	}
	
	// argumentu konstruktors
	
	public Person(String inputName, String inputSurname, String inputPersonCode) {
		setpID();
		setName(inputName);
		setSurname(inputSurname);
		setPersonCode(inputPersonCode);
	}
	
	
	//toString funkcija
	
	@Override
	public String toString() {
		return "ID:" + pID + " | Pacients: " + name + " " + surname + " | Personas kods: " + personCode;
	}
	
	
	
}
