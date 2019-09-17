package util;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import exception.AutoException;
import exception.AutoException.Errors;
import model.Automobile;

public class FileIO implements Serializable{
	public FileIO() {}
	
	//build the Auto Object
	//will catch the exceptions and fix them
	public Automobile buildAutoObject(String filename) throws AutoException{
		Automobile auto = new Automobile();
		String autoModel = "";
		String autoMake = "";
		float baseprice = 0;
		
		int lineNum = 1;
		int opsetTracker = -1;
		int optionStartAt = -10;
		
		int numOfOptions = 0;	
		int numOfOptionSets = 0;
		
		Logger logger = Logger.getLogger("MyLog"); 
		
		try {
			try {
				if(filename.equals("")) {
					throw new AutoException(Errors.MISSING_FILENAME);
				}
			}catch(AutoException e) {
				e.fix(e.getErrorNumber());
			}
//			logger.info("Exception checked1");
			Properties props= new Properties(); //
			FileInputStream in = new FileInputStream(filename);
			props.load(in); //This loads the entire file in memory.
			
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				
				if (line == null) {
					eof = true;
					break;
				}
				//set auto make
				if (lineNum == 1) {
					autoMake = line;
				}
				//set auto model
				if (lineNum == 2) {
					autoModel = line;
				}
				//set auto base price
				//will catch exception and fix it
				if (lineNum == 3) {
					try{
						if(line.equals("") || Float.parseFloat(line) <= 0.0) {
							throw new AutoException(Errors.WRONG_BASEPRICE);
						}
					}catch(AutoException e) {
						e.fix(e.getErrorNumber());
						boolean yes = false;
						Scanner inscan = new Scanner(System.in);
						do {
							System.out.println("Re-enter the base price(must be a number larger than 0.0):");
							line = inscan.nextLine();
							if(!line.isEmpty() && Float.parseFloat(line) > 0) {
								yes = true;
							}
						}while(!yes);
					}
//					logger.info("Exception checked2");
					baseprice = Float.parseFloat(line);	
				}
				//set the array of option sets
				//create the auto with constructor
				if (lineNum == 4) {
					numOfOptionSets = Integer.parseInt(line);
					auto = new Automobile(autoMake,autoModel, baseprice);
					optionStartAt = lineNum;		
				}
				
				//generic, when want to set OpSet Name!
				if(lineNum == optionStartAt + numOfOptions + 1) {
					try {
						if(line.equals("")) {
							throw new AutoException(Errors.MISSING_OPSETNAME);
						}
					}catch(AutoException e) {
						e.fix(e.getErrorNumber());
					}
//					logger.info("Exception checked3");
					++opsetTracker;
					auto.setOptionSetName(line);
//					System.out.println(opsetTracker + auto.getOptionSetName(opsetTracker));
				}
				
//				create option array in one OptionSet
				if(lineNum == optionStartAt + numOfOptions + 2) {
					numOfOptions = Integer.parseInt(line);
//					auto.createOptionsArrayInTheOpsetObject(opsetTracker, numOfOptions);
					optionStartAt = lineNum;
				}
				
//				//set an option set's name
//				//option set array index: opsetTracker
//				//??need to check the condition!!
//				if (lineNum == 4) {
//					opsetTracker++;
//					auto.setOptionSetName(opsetTracker, line);	
//				}				
//				//set the array of options, each option is default
//				if(lineNum == 5) {
//					numOfOptions = Integer.parseInt(line);
//					auto.setOptionsArray(opsetTracker, numOfOptions);
//				}
				
				//parsing the options' values(option name, and option price)
				if(lineNum <= optionStartAt + numOfOptions && lineNum > optionStartAt) {
					this.parseOptionArray(line, auto, opsetTracker, lineNum);
				}
				
				lineNum++;
			}
			buff.close();
		}catch (IOException e) {
			System.out.println("Error ­­ " + e.toString());
		}
		return auto;
	}
	
	//parsing the line of the option element into two parts:
	//option name & option value
	public void parseOptionArray(String line, Automobile auto, int opsetTracker, int lineNum) throws AutoException{
//		(parameter before)String line, Automobile autoM, int opsetTracker, int lineNum, int optionStartAt
		String[] tokens = line.split(",");
		Logger logger = Logger.getLogger("MyLog"); 
		try {
			if(tokens[0].equals("")) {
				throw new AutoException(Errors.MISSING_OPTIONNAME);
			}
			if(tokens.length == 1) {
				throw new AutoException(Errors.MISSING_OPTIONPRICE);
			}
		}catch(AutoException e) {
			e.fix(e.getErrorNumber());
		}
//		logger.info("Exception thrown4");
		
		String optionSetName = auto.getAnOptionSetNameByIndex(opsetTracker);
		String optionName = tokens[0];
		float optionPrice = Float.parseFloat(tokens[1]);
		auto.setOption(optionSetName, optionName, optionPrice);
//		autoM.setOptionsArrayListNameAndPrice(opsetTracker, lineNum-optionStartAt-1, optionName, optionPrice);
	}

	//serialize the file
	public void serialize(String filename, Automobile auto1) {
		try
		{
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(auto1);
			out.close();
			System.out.println("been serialized.\n");
		}
		catch(Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
	
	// de-serialize the file
	public void deserialize(String filename) {
		try
		{
			System.out.println("here");
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			Automobile auto2 = (Automobile)in.readObject();
			in.close();
			System.out.println(auto2);
		}
		catch(Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
}