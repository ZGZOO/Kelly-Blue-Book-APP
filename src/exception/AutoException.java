package exception;

import java.util.logging.Logger;

public class AutoException extends Exception{
	public AutoException() {}
	
	//create my own enumeration called Errors
	//contains all the errors that may occur
	//each has an error number and an error message
	public enum Errors {
		WRONG_BASEPRICE(1,"The car's baseprice is wrong."), 
		MISSING_OPTIONNAME(2,"One option doesn't have a name."), 
		MISSING_OPTIONPRICE(3,"One option doesn't have a price."), 
		MISSING_OPSETNAME(4,"One option set doesn't have a name."),
		MISSING_FILENAME(5,"The file's name is missing."),
		WRONG_OPTIONPRICE(6,"The car's option price is wrong.");
		private int errorNo;
		private String errorMessage;
		Errors (int errno, String errmsg) {
			this.errorNo = errno;
			this.errorMessage = errmsg;
		}
		
		//getters
		protected int getErrorNumber() {
			return this.errorNo;
		}
		protected String getErrorMessage() {
			return this.errorMessage;
		}
	}
	
	private int errorNo;
	private String errorMessage;
	
	//constructor for AutoException
	public AutoException(Errors error) {
		Logger logger = Logger.getLogger("MyLog");  
		this.errorNo = error.getErrorNumber();
		this.errorMessage = error.getErrorMessage();
		logger.info("Exception thrown"); 
	}
	//getters
	public int getErrorNumber() {
		return errorNo;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	
	//a method to fix the errors
	public void fix(int errorno) {
		Fix1to100 fixtools = new Fix1to100();
		
		switch(errorno) {
		case 1: fixtools.fix1(errorno);break;
		case 2: fixtools.fix2(errorno);break;
		case 3: fixtools.fix3(errorno);break;
		case 4: fixtools.fix4(errorno);break;
		case 5: fixtools.fix5(errorno);break;
		case 6: fixtools.fix6(errorno);break;
		default: System.out.println("No errors yet.");break;
		}
	}
}
