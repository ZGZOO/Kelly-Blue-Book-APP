package scale;

//import java.util.Scanner;
import adapter.ProxyAutomobile;

public class Helper extends ProxyAutomobile{

	private int opnum;
	private int threadno;
	private String[] autochange;
//	private Scanner input = new Scanner(System.in);
	
	public Helper(int opnum, int threadno, String[] autochange){
		this.opnum = opnum;
		this.threadno = threadno;
		this.autochange = autochange;	
	}
	
	public synchronized void updateOptionNameSyn() {
//		System.out.println("Thread " + this.threadno + " waiting..");
//		System.out.println("Thread " + this.threadno + " interrupted!");
		int i = 0;
		String autoName = this.autochange[i];
		String OptionSetName = this.autochange[i+1];
		String optionOldName = this.autochange[i+2];
		String optionNewName =this.autochange[i+3];
		System.out.println("Syn Thread " + this.threadno + " is updating option name..");
		super.autoMap.updateAnOptionName(autoName, OptionSetName, optionOldName, optionNewName);
		System.out.println("Thread " + this.threadno + " finishing updating option name..");
	}
	
	public void updateOptionNameNoSyn() {
		int i = 0;
		String autoName = this.autochange[i];
		String OptionSetName = this.autochange[i+1];
		String optionOldName = this.autochange[i+2];
		String optionNewName =this.autochange[i+3];
		System.out.println("No-Syn Thread " + this.threadno + " is updating option name..");
		super.autoMap.updateAnOptionName(autoName, OptionSetName, optionOldName, optionNewName);
		System.out.println("Thread " + this.threadno + " finishing updating option name..");
	}

	public void help() {
		switch (opnum) {
		case 0:	
			this.updateOptionNameSyn();
			break;	
		case 1:
			this.updateOptionNameNoSyn();
			break;
		}
	}

//	public String askAutoName() {
//		System.out.println("Enter auto name : ");
//		String autoname = input.next();
//		return autoname;
//	}
//	
//	public String askOptionSetName() {
//		System.out.println("Enter option set name : ");
//		String opsetname = input.next();
//		return opsetname;
//	}
//	
//	public String askNewName() {
//		System.out.println("Enter new name : ");
//		String newname = input.next();
//		return newname;
//	}
	
//	public String askOldName() {
//		System.out.println("Enter old name : ");
//		String oldname = input.next();
//		return oldname;
//	}

}
