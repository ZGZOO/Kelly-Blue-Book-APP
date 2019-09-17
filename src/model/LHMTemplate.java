package model;

import java.util.LinkedHashMap;
import java.util.Set;

public class LHMTemplate<K, T extends Automobile> {
		private LinkedHashMap<K, T> autoData;
		
		public LHMTemplate()
		{
			autoData = new LinkedHashMap<K, T>();
		}
		
		public void addAuto(K autoName, T anAuto)
		{
			if(!autoData.containsKey(autoName))
				this.autoData.put(autoName, anAuto);
		}
		
		public LinkedHashMap<K, T> getValues(){
			return (LinkedHashMap<K, T>) this.autoData.values();
		}
		
		public void addAutoOption(K autoName, String optionSetName, String optionName, float optionPrice)
		{
			if(autoData.containsKey(autoName))
			{
				this.autoData.get(autoName).setOptionSetName(optionSetName);
				this.autoData.get(autoName).setOption(optionSetName, optionName, optionPrice);
			}
		}
		
		public int updateAnOptionName(K autoName, String optionSetName, String oldName, String newName)
		{
			if(autoData.containsKey(autoName))
				return this.autoData.get(autoName).updateAnOptionName(optionSetName, oldName, newName);
			return 0;
		}
		
		public int updateAnOptionPrice(K autoName, String optionSetName, String optionName, float newPrice)
		{
			if(autoData.containsKey(autoName))
				return this.autoData.get(autoName).updateAnOptionPrice(optionSetName, optionName, newPrice);
			return 0;
		}

		public int updateOptionSetName(K autoName, String oldOpsetName, String newOpsetName)
		{
			if(autoData.containsKey(autoName))
				return this.autoData.get(autoName).updateOptionSetName(oldOpsetName, newOpsetName);
			return 0;
		}
		
		public void print(K autoName)
		{
			if(autoData.containsKey(autoName))
			{
				System.out.println(this.autoData.get(autoName).toString());
			}
		}
		
		public Set<K> getAllModels() {
			return this.autoData.keySet();
		}
		
//		public int removeOptionName(K autoName, String optionSetName, String optionName)
//		{
//			if(dataAuto.containsKey(autoName))
//				return this.dataAuto.get(autoName).removeOptionName(optionSetName, optionName);
//			return 0;
//		}
//		public int removeOptionPrice(K autoName, String optionSetName, String optionName)
//		{
//			if(dataAuto.containsKey(autoName))
//				return this.dataAuto.get(autoName).removeOptionPrice(optionSetName, optionName);
//			return 0;
//		}
//		public int removeOptionSetName(K autoName, String optionSetName)
//		{
//			if(dataAuto.containsKey(autoName))
//				return this.dataAuto.get(autoName).removeOptionSetName(optionSetName);
//			return 0;
//		}
}
