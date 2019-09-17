package adapter;

public interface UpdateAuto {
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to
	//newName.
	public void updateOptionName(String autoName, String OptionSetName, String optionOldName, String optionNewName);
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to
	//newPrice.
	public void updateOptionPrice(String autoName, String OptionSetName, String OptionName, float optionNewPrice);
}
