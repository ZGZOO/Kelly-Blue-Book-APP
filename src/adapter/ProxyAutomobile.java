package adapter;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import exception.*;
import model.*;
import scale.*;
import util.*;

public abstract class ProxyAutomobile {

	public ProxyAutomobile() {
		// TODO Auto-generated constructor stub
	}
		
	protected static Automobile myAuto;
	protected static LHMTemplate<String, Automobile> autoMap = new LHMTemplate<>();
	private FileIO myFileIO = new FileIO();
	private AutoException e = new AutoException();
	
	
	//Given a text file name, a method called BuildAuto can be written to build an instance of
	//Automobile. This method does not have to return the Auto instance.
	public void buildAuto(String filename) {
		try {
			myAuto = myFileIO.buildAutoObject(filename);
			autoMap.addAuto(myAuto.getModel(), myAuto);
		}catch(AutoException e_random) {
//			this.fixAuto(e_random.getErrorNumber());
			e_random.printStackTrace();
		}
	}
	
	//This function searches and prints the properties of a given Automodel.
		public void printAuto(String modelName) {
			autoMap.print(modelName);
//				if(myAuto != null) {
//					if(myAuto.getModel().equals(modelName)) {
//						System.out.println(myAuto);
//					}
//				}
//			}	
		}
		
		
	//This method will go fix the error by giving it an error number
	public void fixAuto(int errorno) {
		e.fix(errorno);
	}

	
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to
	//newName.
	public void updateOptionName(String autoName, String OptionSetName, String optionOldName, String optionNewName) {
		try {
			autoMap.updateAnOptionName(autoName, OptionSetName, optionOldName, optionNewName);	
//			Collection c = (Collection) autoMap;
//			Iterator iterator = c.iterator();
//			while(iterator.hasNext()) {
//				autoMap.updateOptionSet(modelName, OptionSetname, newName);
//				if(myAuto != null) {
//					if(myAuto.getModel().equals(modelName)) {
//						myAuto.updateOptionSetName(OptionSetname, newName);	
//					}
//				}
//			}	
		}catch(NullPointerException e) {
			this.fixAuto(5);
		}	
	}
		
	//This function searches the Model for a given OptionSet and Option name, and sets the price to
	//newPrice.
	public void updateOptionPrice(String autoName, String OptionSetName, String OptionName, float optionNewPrice) {
		try {
			autoMap.updateAnOptionPrice(autoName, OptionSetName, OptionName, optionNewPrice);
//			Collection c = (Collection) autoMap;
//			Iterator iterator = c.iterator();
//			while(iterator.hasNext()) {
//				autoMap.updateOption(modelName, OptionSetName, OptionName, newprice);
//				if(myAuto != null) {
//						if(myAuto.getModel().equals(modelName)) {
//						myAuto.updateAPriceOfAnOption(OptionSetName, OptionName, newprice);
//					}
//				}
//			}	
		}catch(NullPointerException e) {
			this.fixAuto(6);
		}
	}
	
	public void startThread(int threadno, int opnum, String[] autochange) {
		EditOptions editThread = new EditOptions(opnum, threadno, autochange);
		editThread.start();
	}

	public Set<String> getAllModels() {
		// TODO Auto-generated method stub
		Set<String> models = autoMap.getAllModels();
		return models;
	}

	public void addAuto(Automobile a) {
		System.out.println("adding auto");
		autoMap.addAuto(a.getModel(), a);
	}
	
	public String listAuto() {
		Set<String> models = autoMap.getAllModels();
		return models.toString();
	}
	
    public Automobile getAuto(String name) {
    	 	 Collection<Automobile> vals = (Collection<Automobile>) autoMap.getValues();
         Iterator<Automobile> iter = vals.iterator();
         while(iter.hasNext())
         {
             Automobile temp = iter.next();
             if(temp.getModel().equals(name))
                 return temp;
         }
         return null;
    }
}
