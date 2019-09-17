package scale;

import adapter.ProxyAutomobile;

public class EditOptions extends ProxyAutomobile implements Runnable {
	private int opnum;
	private int threadno;
	private Helper helper;
	private Thread t;

	public EditOptions(int opnum, int threadno, String[] autochange) {
		t = new Thread(this);
		this.opnum = opnum;
		this.threadno = threadno;
		this.helper = new Helper(this.opnum, this.threadno, autochange);
	}

	public void run() {
		
		System.out.println("Starting thread " + this.threadno + "...!" );
		System.out.println("Thread " + this.threadno + " executing operation " + this.opnum);
		helper.help();
		System.out.println("Thread " + this.threadno + " finishing operation " + this.opnum + "...");
		System.out.println("Stopping thread " + this.threadno + "...!" );
		
		return;
	}
	
	public void start() {
		t.start();
	}

}














