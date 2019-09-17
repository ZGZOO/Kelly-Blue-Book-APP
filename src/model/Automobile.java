package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Automobile implements Serializable {
	private String make;
	private String model;
	private float baseprice;
	private ArrayList<OptionSet> optionSets;

	public Automobile() {
		make = "";
		model = "";
		baseprice = 0;
		optionSets = null;
	}

	public Automobile(String make, String model, float price) {
		this.make = make;
		this.model = model;
		this.baseprice = price;
		this.optionSets = new ArrayList<OptionSet>();
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBasePrice(float baseprice) {
		this.baseprice = baseprice;
	}
	
	public void setOptionSetName(String OptionSetName) {
		OptionSet optionset = new OptionSet();
		optionset.setOptionSetName(OptionSetName);
		optionSets.add(optionset);
	}

	public void setOption(String OptionSetName, String optionName, float optionPrice) {
		for(int i = 0; i < optionSets.size(); i++) {
			if(optionSets.get(i).getOptionSetName().equals(OptionSetName)) {
				optionSets.get(i).setOptionNameAndPrice(optionName, optionPrice);
			}
		}
//		OptionSet optionset = new OptionSet();
//		optionset.setOptionNameAndPrice(optionName, optionPrice);
//		optionSets.add(optionset);
	}
	
	public void setOptionChoice(String OptionSetName, String OptionName) {
		for(int i = 0; i < optionSets.size(); i++) {
			if(optionSets.get(i).getOptionSetName().equals(OptionSetName)) {
				optionSets.get(i).setOptionName(OptionName);
			}
		}
	}
	
//	public void setAutoOption(String optionSetName, String optionName, float optionPrice) {
//		optionSet.setOption(optionSetName, optionName, optionPrice);
//		for(int i = 0; i < optionSets.size(); i++) {
//			if(optionSets.get(i).getOptionSetName().equals(optionSetName)) {
//				optionSets.set(i, optionSet);
//			}
//		}
//	}

//	public void removeOptionName(String optionSetName, String optionName) {
//		for(int i = 0; i < optionSets.size(); i++) {
//			if(optionSets.get(i).getOptionSetName().equals(optionSetName)) {
//				optionSets.set(i, optionSet);
//			}
//		}
//	}
	
	public int updateOptionSetName(String oldname, String newname) {
//		optionSet.updateOptionSetName(newname);   wrong code!
		for(int i = 0; i < optionSets.size(); i++) {
			if(optionSets.get(i).getOptionSetName().equals(oldname)) {
				optionSets.get(i).setOptionSetName(newname);
//				optionSets.set(i, optionSet);    wrong code!
			}
		}
		return 1;
	}

	public int updateAnOptionName(String OptionSetName, String optionOldName, String optionNewName) {
		for(int i = 0; i < optionSets.size(); i++) {
			if(optionSets.get(i).getOptionSetName().equals(OptionSetName)) {
				optionSets.get(i).updateOptionNameByName(optionOldName, optionNewName);
			}
		}
//		option.updateOptionName(optionNewName);
//		for(int i = 0; i < optionSets.size(); i++) {
//			if(optionSets.get(i).getOptionSetName().equals(OptionSetName)) {
//				for(int j = 0; j < options.size(); i++) {
//					if(options.get(j).getOptionName().equals(optionOldName)) {
//						options.set(j, option);
//					}
//				}
//			}
//		}   wrong codes!!
		return 1;
	}

	public int updateAnOptionPrice(String opsetName, String optionName, float newPrice) {
		for(int i = 0; i < optionSets.size(); i++) {
			if(optionSets.get(i).getOptionSetName().equals(opsetName)) {
				optionSets.get(i).updateOptionPriceByName(optionName, newPrice);;
			}
		}
//		option.updateOptionPrice(newPrice);
//		for(int i = 0; i < optionSets.size(); i++) {
//			if(optionSets.get(i).getOptionSetName().equals(opsetName)) {
//				for(int j = 0; j < options.size(); i++) {
//					if(options.get(j).getOptionName().equals(optionName)) {
//						options.set(j, option);
//					}
//				}
//			}
//		}
		return 1;
	}

	public int getOpsetSize() {
		return this.optionSets.size();
	}
	
	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public float getBasePrice() {
		return baseprice;
	}

	public ArrayList<OptionSet> getWholeOptionSet() {
		return optionSets;
	}

	public OptionSet getAnOptionSetByIndex(int index) {
		if (optionSets.get(index) != null) {
			return optionSets.get(index);
		}
		return null;
	}
	
	public OptionSet getAnOptionSetByName(String optionSetName) {
		for (int i = 0; i < optionSets.size(); i++) {
			if (this.getAnOptionSetByIndex(i).getOptionSetName().equals(optionSetName)) {
				return this.getAnOptionSetByIndex(i);
			}
		}
		return null;
	}
	
	public String getAnOptionSetNameByIndex(int opsetIndex) {
		String optionSetName;
		optionSetName = this.optionSets.get(opsetIndex).getOptionSetName();
		return optionSetName;
	}
	
	public ArrayList<Option> getAllChoicesByOpSetIndex(int opsetIndex) {
//		this.options = this.getAnOptionSetByIndex(opsetIndex).getOptions();
//		return this.options;   wrong codes!!
		//ArrayList<Option> is a type, i can use it even there is no ArrayList of options in this class!
		return this.getAnOptionSetByIndex(opsetIndex).getOptions();
	}

	public ArrayList<Option> getAllChoicesByOpSetName(String opsetname) {
		return this.getAnOptionSetByName(opsetname).getOptions();
	}

	public String getAnOptionNameByOpSetIndexAndOptionIndex(int opsetIndex, int optionIndex) {
		return this.getAnOptionSetByIndex(opsetIndex).getAnOptionNameByIndex(optionIndex);
	}
	
	public String getAnOptionNameByOpSetNameAndOptionIndex(String opsetName, int optionIndex) {
		return this.getAnOptionSetByName(opsetName).getAnOptionNameByIndex(optionIndex);
	}

	public float getAnOptionPriceByOpSetIndexAndOptionIndex(int opsetIndex, int optionIndex) {
		return this.getAnOptionSetByIndex(opsetIndex).getAnOptionPriceByIndex(optionIndex);
	}
	
	public float getAnOptionPriceByOpSetIndexAndOptionName(int opsetIndex, String optionName) {
		return this.getAnOptionSetByIndex(opsetIndex).getAChoicePriceByName(optionName);
	}
	
	public float getAnOptionPriceByOpSetNameAndOptionIndex(String opsetName, int optionIndex) {
		return this.getAnOptionSetByName(opsetName).getAnOptionPriceByIndex(optionIndex);
	}
	
	public float getAnOptionPriceByOpSetNameAndOptionName(String opsetName, String optionName) {
		return this.getAnOptionSetByName(opsetName).getAChoicePriceByName(optionName);
	}
	
	public float getTotalPrice()
    {
        float total = this.getBasePrice();
        for(int i = 0; i < optionSets.size(); i++)
            if(optionSets.get(i) != null)
            		for (int j = 0; j < optionSets.get(i).getOptionsSize(); j++) {
            			total += optionSets.get(i).getAnOptionPriceByIndex(j);
            		}
        return total;
    }

	public void deleteAnOptionSetByIndex(int index) {
		OptionSet anOpset = this.getAnOptionSetByIndex(index);
		if (anOpset != null) {
			anOpset = null;
		}
	}

	public void deleteAnOptionSetByName(String name) {
		OptionSet anOpset = this.getAnOptionSetByName(name);
		if (anOpset != null) {
			anOpset = null;
		}
	}

	public String toString() {
		String string1 = "Auto Make: " + make + "\nAuto Model: " + model + "\nBase Price: " + baseprice + "\n\n";
		String string2 = "";
//		System.out.println("这里2");
		for (int i = 0; i < this.optionSets.size(); i++) {
			string2 += this.optionSets.get(i).toString();
		}
//		string2 += optionSets.get(0).toString();
		return string1 + string2;
	}
}

// public void setAnOptionInstance(int opsetTracker, int i, String optionName,
// float optionPrice) {
// this.getAnOptionSetObjectByIndex(opsetTracker).getAnOptionObjectByIndex(i).setOptionName(optionName);
// this.getAnOptionSetObjectByIndex(opsetTracker).getAnOptionObjectByIndex(i).setOptionPrice(optionPrice);;
// }

// public void CreateAutoObject(String filePath) {
//
// myUtil=new Util()
// myUtil.parseAutoFile()
//
// hash result = Util.parseAutoFile()
//
// name = result.name
// baseprice = result.baseprice
// ..
//
// }

// Automotive myAuto = new Automotive();
// myAuto.CreateAutoObject("data/myAutoFile.txt")
//
// print myAuto.name

// OptionSet color = new OptionSet([new Option("red", 1000), new Option("green",
// 200), new Option("Blue", 500)])
// OptionSet transmission = new OptionSet([new Option("has", 0), new
// Option("doesnt have", 100)])
//
