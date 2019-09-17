package Driver;

import adapter.*;
import exception.*;

public class driver extends Thread{
	public driver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws AutoException {
		//Assignment 1
//		FileIO myFileIO = new FileIO();
//		Automobile auto1 = myFileIO.buildAutoObject("FordWagonZTW");
//		myFileIO.serialize("FordWagonZTW.ser", auto1);
//		myFileIO.deserialize("FordWagonZTW.ser");
//		String string = myFileIO.buildAutoObject("FordWagonZTW").toString();
//		System.out.println(string);
		
		//Assignment 2
//		CreateAuto a1 = new BuildAuto();
//		a1.buildAuto("FordWagonZTW");
//		a1.printAuto("Focus Wagon ZTW");
//		UpdateAuto a2 = new BuildAuto();
//		a2.updateOptionPrice("Focus Wagon ZTW", "color", "Infra-Red Clearcoat", -1);
//		FixAuto a3 = new BuildAuto();
//		a3.fixAuto(6);
//		a2.updateOptionPrice("Focus Wagon ZTW", "color", "Infra-Red Clearcoat", 200);
//		a1.printAuto("Focus Wagon ZTW");
		
		//Assignment 3
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("FordWagonZTW");
		CreateAuto a2 = new BuildAuto();
		a2.buildAuto("NissanAltimaSV");
		a1.printAuto("Focus Wagon ZTW");
		a2.printAuto("AltimaSV");	
		UpdateAuto a3 = new BuildAuto();
		a3.updateOptionPrice("Focus Wagon ZTW", "color", "Infra-Red Clearcoat", -1);
		FixAuto a4 = new BuildAuto();
		a4.fixAuto(6);
		UpdateAuto a5 = new BuildAuto();
		a5.updateOptionPrice("AltimaSV", "color", "French Blue", 200);
		a2.printAuto("AltimaSV");
//==========================================================================================
		
		//Assignment 4	
//		CreateAuto a1 = new BuildAuto();
//		a1.buildAuto("FordWagonZTW");
//		a1.buildAuto("NissanAltimaSV");
//		a1.printAuto("AltimaSV");
			
		//synchronized test
//		String[] autostring = {"AltimaSV", "moonroof", "none", "advance"};
//		String[] autostring2 = {"AltimaSV", "brakes", "ABS", "advancedd"};
//		EditThread a2 = new BuildAuto();
//		EditThread a3 = new BuildAuto();
//		a2.startThread(1, 0, autostring);
//		a3.startThread(2, 0, autostring2);
//		a1.printAuto(autostring[0]);
//		a1.printAuto(autostring2[0]);
		
		//non-synchronized test
//		String[] autostring3 = {"AltimaSV", "moonroof", "none", "advance"};
//		String[] autostring4 = {"AltimaSV", "brakes", "ABS", "advancedd"};
//		EditThread a4 = new BuildAuto();
//		EditThread a5 = new BuildAuto();
//		a4.startThread(3, 1, autostring3);
//		a5.startThread(4, 1, autostring4);
//		a1.printAuto(autostring3[0]);
//		a1.printAuto(autostring4[0]);
	}
	
}


//Auto Make: Nissan
//Auto Model: AltimaSV
//Base Price: 14875.0
//
//  OptionSet: color
//    Option: "Gold", Price: 0.0
//    Option: "Grey", Price: 0.0
//    Option: "Red", Price: 0.0
//    Option: "Green", Price: 0.0
//    Option: "Sangria Red", Price: 0.0
//    Option: "French Blue", Price: 0.0
//    Option: "Twilight Blue", Price: 0.0
//    Option: "CD Silver", Price: 0.0
//    Option: "Pitch Black", Price: 0.0
//    Option: "Cloud 9 White", Price: 0.0
//
//  OptionSet: transmission
//    Option: automatic, Price: 0.0
//    Option: manual, Price: -1015.0
//
//  OptionSet: brakes
//    Option: standard, Price: 0.0
//    Option: ABS, Price: 300.0
//    Option: ABSadvance, Price: 1428.0
//
//  OptionSet: airbags
//    Option: none, Price: 0.0
//    Option: selected, Price: 250.0
//
//  OptionSet: moonroof
//    Option: none, Price: 0.0
//    Option: selected, Price: 395.0
//
//
//Starting thread 1...!
//Thread 1 executing operation 0
//Starting thread 2...!
//Syn Thread 1 is updating option name..
//Thread 2 executing operation 0
//Thread 1 finishing updating option name..
//Syn Thread 2 is updating option name..
//Thread 1 finishing operation 0...
//Thread 2 finishing updating option name..
//Thread 2 finishing operation 0...
//Stopping thread 2...!
//Stopping thread 1...!
//Auto Make: Nissan
//Auto Model: AltimaSV
//Base Price: 14875.0
//
//  OptionSet: color
//    Option: "Gold", Price: 0.0
//    Option: "Grey", Price: 0.0
//    Option: "Red", Price: 0.0
//    Option: "Green", Price: 0.0
//    Option: "Sangria Red", Price: 0.0
//    Option: "French Blue", Price: 0.0
//    Option: "Twilight Blue", Price: 0.0
//    Option: "CD Silver", Price: 0.0
//    Option: "Pitch Black", Price: 0.0
//    Option: "Cloud 9 White", Price: 0.0
//
//  OptionSet: transmission
//    Option: automatic, Price: 0.0
//    Option: manual, Price: -1015.0
//
//  OptionSet: brakes
//    Option: standard, Price: 0.0
//    Option: advancedd, Price: 300.0
//    Option: ABSadvance, Price: 1428.0
//
//  OptionSet: airbags
//    Option: none, Price: 0.0
//    Option: selected, Price: 250.0
//
//  OptionSet: moonroof
//    Option: advance, Price: 0.0
//    Option: selected, Price: 395.0
//

//Auto Make: Nissan
//Auto Model: AltimaSV
//Base Price: 14875.0
//
//  OptionSet: color
//    Option: "Gold", Price: 0.0
//    Option: "Grey", Price: 0.0
//    Option: "Red", Price: 0.0
//    Option: "Green", Price: 0.0
//    Option: "Sangria Red", Price: 0.0
//    Option: "French Blue", Price: 0.0
//    Option: "Twilight Blue", Price: 0.0
//    Option: "CD Silver", Price: 0.0
//    Option: "Pitch Black", Price: 0.0
//    Option: "Cloud 9 White", Price: 0.0
//
//  OptionSet: transmission
//    Option: automatic, Price: 0.0
//    Option: manual, Price: -1015.0
//
//  OptionSet: brakes
//    Option: standard, Price: 0.0
//    Option: advancedd, Price: 300.0
//    Option: ABSadvance, Price: 1428.0
//
//  OptionSet: airbags
//    Option: none, Price: 0.0
//    Option: selected, Price: 250.0
//
//  OptionSet: moonroof
//    Option: advance, Price: 0.0
//    Option: selected, Price: 395.0


//Auto Make: Ford
//Auto Model: Focus Wagon ZTW
//Base Price: 18445.0
//
//  OptionSet: color
//    Option: "Fort Knox Gold Clearcoat Metallic", Price: 0.0
//    Option: "Liquid Grey Clearcoat Metallic", Price: 0.0
//    Option: "Infra-Red Clearcoat", Price: 0.0
//    Option: "Grabber Green Clearcoat Metallic", Price: 0.0
//    Option: "Sangria Red Clearcoat Metallic", Price: 0.0
//    Option: "French Blue Clearcoat Metallic", Price: 0.0
//    Option: "Twilight Blue Clearcoat Metallic", Price: 0.0
//    Option: "CD Silver Clearcoat Metallic", Price: 0.0
//    Option: "Pitch Black Clearcoat", Price: 0.0
//    Option: "Cloud 9 White Clearcoat", Price: 0.0
//
//  OptionSet: transmission
//    Option: automatic, Price: 0.0
//    Option: manual, Price: -815.0
//
//  OptionSet: brakes
//    Option: standard, Price: 0.0
//    Option: ABS, Price: 400.0
//    Option: ABSadvance, Price: 1625.0
//
//  OptionSet: airbags
//    Option: none, Price: 0.0
//    Option: selected, Price: 350.0
//
//  OptionSet: moonroof
//    Option: none, Price: 0.0
//    Option: selected, Price: 595.0
//
//
//Auto Make: Nissan
//Auto Model: AltimaSV
//Base Price: 14875.0
//
//  OptionSet: color
//    Option: "Gold", Price: 0.0
//    Option: "Grey", Price: 0.0
//    Option: "Red", Price: 0.0
//    Option: "Green", Price: 0.0
//    Option: "Sangria Red", Price: 0.0
//    Option: "French Blue", Price: 0.0
//    Option: "Twilight Blue", Price: 0.0
//    Option: "CD Silver", Price: 0.0
//    Option: "Pitch Black", Price: 0.0
//    Option: "Cloud 9 White", Price: 0.0
//
//  OptionSet: transmission
//    Option: automatic, Price: 0.0
//    Option: manual, Price: -1015.0
//
//  OptionSet: brakes
//    Option: standard, Price: 0.0
//    Option: ABS, Price: 300.0
//    Option: ABSadvance, Price: 1428.0
//
//  OptionSet: airbags
//    Option: none, Price: 0.0
//    Option: selected, Price: 250.0
//
//  OptionSet: moonroof
//    Option: none, Price: 0.0
//    Option: selected, Price: 395.0
//
//
//Error No#6: The car's option price is wrong.
//Auto Make: Nissan
//Auto Model: AltimaSV
//Base Price: 14875.0
//
//  OptionSet: color
//    Option: "Gold", Price: 0.0
//    Option: "Grey", Price: 0.0
//    Option: "Red", Price: 0.0
//    Option: "Green", Price: 0.0
//    Option: "Sangria Red", Price: 0.0
//    Option: "French Blue", Price: 0.0
//    Option: "Twilight Blue", Price: 0.0
//    Option: "CD Silver", Price: 0.0
//    Option: "Pitch Black", Price: 0.0
//    Option: "Cloud 9 White", Price: 0.0
//
//  OptionSet: transmission
//    Option: automatic, Price: 0.0
//    Option: manual, Price: -1015.0
//
//  OptionSet: brakes
//    Option: standard, Price: 0.0
//    Option: ABS, Price: 300.0
//    Option: ABSadvance, Price: 1428.0
//
//  OptionSet: airbags
//    Option: none, Price: 0.0
//    Option: selected, Price: 250.0
//
//  OptionSet: moonroof
//    Option: none, Price: 0.0
//    Option: selected, Price: 395.0


