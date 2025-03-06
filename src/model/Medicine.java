package model;


import java.time.LocalDate;

public class Medicine {

	
	private long mID;
	private String name;
	private int dosage;
	private String usageInstructions;
	private String manufacturer;
	private LocalDate expiryDate;
	
	
	
	private long counter = 0;

	
	// getter
	
	public long getmID() {
		return mID;
	}
	public String getName() {
		return name;
	}
	public int getDosage() {
		return dosage;
	}
	public String getUsageInstructions() {
		return usageInstructions;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	
	// setter
	
	public void setmID() {
		mID = counter++;
	}
	

	public void setName(String inputName) {
		if (inputName != null
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			inputName = name;
		} else {
			name = "unknown";
		}
	}
	
	public void setDosage(int inputDosage) {
		if (inputDosage > 0) {
			dosage = inputDosage;
		} else {
			dosage = 0;
		}
	}
	
	public void setUsageInstructions(String inputUsageInstructions) {
		if (inputUsageInstructions != null
				&& inputUsageInstructions.matches("[A-Za-z1-9!. '\"]{5,100}")) {
			usageInstructions = inputUsageInstructions;
		} else {
			usageInstructions = "NO INSTRUCTION!";
		}
	}
	
	public void setManufacturer(String inputManufacturer) {
		if (inputManufacturer != null
				&& inputManufacturer.matches("[A-Za-z1-9!. '\"]{5,100}")) {
			manufacturer = inputManufacturer;
		} else {
			manufacturer = "UNKNOWN";
		}
	}
	public void setExpiryDate(LocalDate inputDate) {
		if (inputDate != null) {
			expiryDate = inputDate;
		}
	}
	
	// bez arg konstruktors
	
	public Medicine() {
		setmID();
		setName("Test medicine");
		setDosage(200);
		setUsageInstructions("1 200 mg pill every day");
		setManufacturer("Test manufacturer");
	}
	
	// arg konstruktors
	
	public Medicine(String inputName, int inputDosage, String inputUsageInstructions, String inputManufacturer) {
		setmID();
		setName(inputName);
		setDosage(inputDosage);
		setUsageInstructions(inputUsageInstructions);
		setManufacturer(inputManufacturer);
	}
	
	
	// toString
	
	public String toString() {
		return "ID: " + mID + " | MEDICINE: " + name + " | DOSAGE: " + dosage +
				" | INSTRUCTIONS: " + usageInstructions + " | MANUFACTURER" + manufacturer;
	}
	
	
	
}
