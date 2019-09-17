package client;

import model.*;

import java.io.*;
import java.util.*;

public class SelectCarOptions {

	private Automobile auto;

	public SelectCarOptions(Automobile auto) {
		this.auto = auto;
	}

	public void configureAuto() {
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String OptionSetChoice;
		String OptionChoice;
		try {
			do {
				System.out.println("");
				System.out.println("This is the car you chose:\n" + auto +"\n"+ "\nTotal Price: "+auto.getTotalPrice());
                System.out.println("Please choose an option set:");
                OptionSetChoice = buffReader.readLine();
                System.out.println("Please choose an option");
                OptionChoice = buffReader.readLine();
                auto.setOptionChoice(OptionSetChoice, OptionChoice);
                System.out.println("Your choice has been recorded, enter Done to quit.");
                input = buffReader.readLine();
			}while(!input.equals("Done"));
		}catch(IOException e) {
			
		}
	}

	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;
		try {
			Automobile auto = (Automobile) obj;
			isAutomobile = true;
		}
		catch (ClassCastException e) {
			isAutomobile = false;
		}
		return isAutomobile;
	}
	
}
