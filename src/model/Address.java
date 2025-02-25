package model;

public class Address {
	private City city;
	private String streetOrHouseTitle;
	private String houseNo;
	
	
	// getters
	public City getCity() {
		return city;
	}
	public String getStreetOrHouseTitle() {
		return streetOrHouseTitle;
	}
	public String getHouseNo() {
		return houseNo;
	}
	
	
	// setters
	
	public void setCity(City inputCity) {
		if (inputCity != null) {
			city = inputCity;
		} else {
			city = City.cita;
		}
	}
	
	public void setStreetOrHouseTitle(String inputStreetOrHouseTitle) {
		if (inputStreetOrHouseTitle != null && 
				inputStreetOrHouseTitle.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			streetOrHouseTitle = inputStreetOrHouseTitle;
		} else {
			streetOrHouseTitle = "unknown";
		}
	}
	public void setHouseNo(String inputHouseNo) {
		if (inputHouseNo.matches("[1-9]{1,3}([A-Za-z]{1})?")) {
			houseNo = inputHouseNo;
		} else {
			houseNo = "unknown";
		}
	}
	
	
	// bez argumenta konstruktors
	
	public Address() {
		setCity(City.Ventspils);
		setStreetOrHouseTitle("Lielais Prospekts");
		setHouseNo("13A");
	}
	public Address(City inputCity, String inputStreetOrHouseTitle, String inputHouseNo) {
		setCity(inputCity);
		setStreetOrHouseTitle(inputStreetOrHouseTitle);
		setHouseNo(inputHouseNo);
	}
	
	// toString funkcija
	
	@Override
	public String toString() {
		return "Pilseta -  " + city + " | " + streetOrHouseTitle + " " + houseNo;
	}
	
}
