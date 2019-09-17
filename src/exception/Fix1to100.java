package exception;

import exception.AutoException.Errors;

//exception helpers class
//contains each error handling method
public class Fix1to100 {

	public Fix1to100() {}
	
	protected void fix1(int errorno) {
		System.out.println("Error No#" + errorno + ": " + Errors.WRONG_BASEPRICE.getErrorMessage());
	}
	protected void fix2(int errorno) {
		System.out.println("Error No#" + errorno + ": " + Errors.MISSING_OPTIONNAME.getErrorMessage());
	}
	protected void fix3(int errorno) {
		System.out.println("Error No#" + errorno + ": " + Errors.MISSING_OPTIONPRICE.getErrorMessage());
	}
	protected void fix4(int errorno) {
		System.out.println("Error No#" + errorno + ": " + Errors.MISSING_OPSETNAME.getErrorMessage());
	}
	protected void fix5(int errorno) {
		System.out.println("Error No#" + errorno + ": " + Errors.MISSING_FILENAME.getErrorMessage());
	}
	protected void fix6(int errorno) {
		System.out.println("Error No#" + errorno + ": " + Errors.WRONG_OPTIONPRICE.getErrorMessage());
	}
}
