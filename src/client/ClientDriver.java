package client;

public class ClientDriver {

	static DefaultSocketClient socketClient;
	public ClientDriver() {
		// TODO Auto-generated constructor stub
	}
	public static void main (String[] args) {
		socketClient = new DefaultSocketClient("153.18.172.78", 4444);
		socketClient.start();
	}
}
