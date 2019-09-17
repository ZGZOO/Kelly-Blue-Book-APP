package model;

import java.io.Serializable;

public class Option implements Serializable{
	
	private String optionName;
	private float optionPrice;
	
	public Option(){
		optionName = "";
		optionPrice = 0;
	}
	
	public Option(String optionName, float optionPrice) {
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}
	
	protected String getOptionName() {
		return optionName;
	}
	
	protected float getOptionPrice() {
		return optionPrice;
	}
	
	protected void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	protected void setOptionPrice(float optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	protected void setOptionNameAndPrice(String optionName, float optionPrice) {
		this.optionName = optionName;
		this.optionPrice = optionPrice;		
	}
	
	protected void updateOptionName(String newOptionName) {
		setOptionName(newOptionName);
	}
	
	protected void updateOptionPrice(float newOptionPrice) {
		setOptionPrice(newOptionPrice);
	}
	
	protected void updateOptionNameAndPrice(String newOptionName, float newOptionPrice) {
		setOptionName(newOptionName);
		setOptionPrice(newOptionPrice);
	}
	
	public String toString() {
		return "    Option: " + optionName
				+ ", Price: " + optionPrice
				+ "\n";
	}

}
