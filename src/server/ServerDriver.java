package server;

public class ServerDriver {
	
	static DefaultServerSocket socketServer;
	
	public ServerDriver() {
		// TODO Auto-generated constructor stub
	}
	public static void main (String[] args) {
		socketServer = new DefaultServerSocket(4444);
		socketServer.start();
	}   
}
