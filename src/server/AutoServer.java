package server;

import model.Automobile;

public interface AutoServer {
	public void addAuto(Automobile a);
	public String listAuto();
    public Automobile getAuto(String name);
}
