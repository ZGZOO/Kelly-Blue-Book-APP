package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable{
	//private Option[] optionsArray;
	private String OptionSetName;
	private ArrayList<Option> options;

	public OptionSet() {
		//optionsArray = null;
		OptionSetName = "";
		options = new ArrayList<Option>();
	}
	
	public OptionSet(String OptionSetName) {
		this.OptionSetName = OptionSetName;
		//optionsArray = new Option[sizeOfOptionsArray];
//		for(int i = 0; i < sizeOfOptionsArray; i++)
//			optionsArray[i] = new Option();
		options = new ArrayList<Option>();
	}
	
	protected void setOptionSetName(String OptionSetName) {
		this.OptionSetName = OptionSetName;
	}
	
	protected void setOptionNameAndPrice(String optionName, float optionPrice) {
		Option option = new Option();
		option.setOptionNameAndPrice(optionName, optionPrice);
		options.add(option);
	}
	
	protected void setOptionName(String optionName) {
		Option option = new Option();
		option.setOptionName(optionName);;
		options.add(option);
	}
	
//	protected void setOption(String optionSetName, String optionName, float optionPrice) {
//		this.setOptionSetName(optionSetName);
//		this.setOptionNameAndPrice(optionName, optionPrice);
//	}
	
	protected void updateOptionSetName(String newOptionSetName) {
		this.setOptionSetName(newOptionSetName);
	}
	
	protected void updateOptionNameByIndex(int optionIndex, String optionNewName) {
		options.get(optionIndex).updateOptionName(optionNewName);;
	}
	protected void updateOptionNameByName(String optionOldName, String optionNewName) {
		for(int i = 0; i < options.size(); i++) {
			if(options.get(i).getOptionName().equals(optionOldName)) {
				options.get(i).updateOptionName(optionNewName);
			}
		}	
	}
	
	protected void updateOptionPriceByIndex(int index, float optionNewPrice) {
		options.get(index).updateOptionPrice(optionNewPrice);
	}
	protected void updateOptionPriceByName(String optionName, float optionNewPrice) {
		for(int i = 0; i < options.size(); i++) {
			if(options.get(i).getOptionName().equals(optionName)) {
				options.get(i).updateOptionPrice(optionNewPrice);
			}
		}	
	}
	
	
	//get the ArrayList of options, otherwise it should return null.
	protected ArrayList<Option> getOptions() {
		if(this.options != null)
			return this.options;
		return null;	
	}
	
	protected int getOptionsSize() {
		return this.options.size();
	}
	
	//get an option object by the name of option
	protected Option getAnOptionClassByName(String optionName) {
		for(int i = 0; i < options.size(); i++) {
			if(options.get(i).getOptionName().equals(optionName)) {
				return options.get(i);
			}
		}
		return null;
	}
	
	//get an option object by the index of ArrayList
	protected Option getAnOptionClassByIndex(int optionIndex) {
		if(options.get(optionIndex) != null) {
			return options.get(optionIndex);
		}
		return null;
	}
	
	protected String getAnOptionNameByIndex(int optionIndex) {
		return this.getAnOptionClassByIndex(optionIndex).getOptionName();
	}
	
	protected float getAnOptionPriceByIndex(int optionIndex) {
		return this.getAnOptionClassByIndex(optionIndex).getOptionPrice();
	}
	
	protected float getAChoicePriceByName(String optionName) {
		return this.getAnOptionClassByName(optionName).getOptionPrice();
	}
	
	//get option set name
	protected String getOptionSetName() {
		return this.OptionSetName;
	}
	
	public String toString() {
		String string1 = "  OptionSet: " + OptionSetName + "\n";
		String string2 = "";
		for(int i = 0; i < options.size(); i++) {			
			string2 += options.get(i).toString();
		}
		return string1 + string2 + "\n";
	}

	
//	protected Option getAnOptionObjectByIndex(int index) {
//		return optionsArray[index];
//	}
//	
//	protected Option getAnOptionObjectByName(String optionName) {
//		int arraylength = optionsArray.length;
//		for(int i = 0; i < arraylength; i++) {
//			if(optionsArray[i].getOptionName().equals(optionName)) {
//				return optionsArray[i];
//			}
//		}
//		return null;
//	}
	
//	protected String getAnOptionNameByIndex(int index) {
//		return getAnOptionObjectByIndex(index).getOptionName();
//	}
//	
//	protected float getAnOptionPriceByName(String optionName) {
//		return getAnOptionObjectByName(optionName).getOptionPrice();
//	}
	
	
//	protected void setANameToAnOptionObjectByIndex(int index, String name) {
//		this.getAnOptionObjectByIndex(index).setOptionName(name);
//	}
//	
//	protected void setAPriceToAnOptionObjectByIndex(int index, float price) {
//		this.getAnOptionObjectByIndex(index).setOptionPrice(price);
//	}
//	
//	protected void setAPriceToAnOptionObjectByName(String name, float price) {
//		this.getAnOptionObjectByName(name).setOptionPrice(price);
//	}

//	protected void deleteAnOptionObjectInTheArrayByIndex(int index) {
//		Option option = this.getOptionChoiceByIndex(index);
//		if (option != null) {
//			option = null;
//		}
//	}
//	
//	protected void deleteAnOptionObjectInTheArrayByName(String name) {
//		Option anOption = this.getOptionChoiceByName(name);
//		if(anOption != null) {
//			anOption = null;
//		}
//	}
//	
//	protected void updateAnOldOptionNameWithANewName(String oldname, String newname) {
//		this.getAnOptionObjectByName(oldname).setOptionName(newname);
//	}
//	
//	protected void updateAnOldOptionPriceWithANewPrice(String name, float newprice) {
//		this.getAnOptionObjectByName(name).setOptionPrice(newprice);
//	}
		
//================================================================
	//inner class
//	public class Option implements Serializable{
//		private String optionName;
//		private float optionPrice;
//		
//		public Option(){
//			optionName = "";
//			optionPrice = 0;
//		}
//		
//		public Option(String optionName, float optionPrice) {
//			this.optionName = optionName;
//			this.optionPrice = optionPrice;
//		}
//		
//		protected String getOptionName() {
//			return optionName;
//		}
//		
//		protected float getOptionPrice() {
//			return optionPrice;
//		}
//		
//		protected void setOptionName(String optionName) {
//			this.optionName = optionName;
//		}
//		
//		protected void setOptionPrice(float optionPrice) {
//			this.optionPrice = optionPrice;
//		}
//		
//		protected void updateOptionName(String newOptionName) {
//			setOptionName(newOptionName);
//		}
//		
//		protected void updateOptionPrice(float newOptionPrice) {
//			setOptionPrice(newOptionPrice);
//		}
//		
//		public String toString() {
//			return getClass().getName()
//					+ " -> Option name: " + optionName
//					+ ", Option price: " + optionPrice
//					+ "\n";
//		}
//	}
}
