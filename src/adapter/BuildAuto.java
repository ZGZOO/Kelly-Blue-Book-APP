package adapter;

import server.AutoServer;

//We want proxyAutomobile to be “hidden” containing all the functionality and expose an
//empty class, for usage with Interfaces. In other words, we will add a new class called BuildAuto in
//adapter package that will have no lines of code, but will always look like this.
public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, FixAuto, EditThread, AutoServer{
	
}
