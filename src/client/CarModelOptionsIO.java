package client;

import java.io.*;
import java.net.*;
import java.util.*;

import model.Automobile;

public class CarModelOptionsIO {

	public CarModelOptionsIO() {
		Socket clientSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        
        try
        {
            clientSocket = new Socket("153.18.172.78", 4444);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } 
        catch (UnknownHostException e)
        {
            System.err.println("Host unknown");
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println("Couldn't find server");
            System.exit(1);
        }

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String serverSide;
        String userSide;

        System.out.println("Let's start our KBB!");
        try
        {
            do
            {
                System.out.println("\n1. Enter a Properties file to upload your car"
                		+ "\n2. Configure a car from the server"
                		+ "\nOr enter exit to quit");
                
                userSide = buffReader.readLine();
                try
                {
                    switch(Integer.parseInt(userSide))
                    {
                        case 1:
                        {
                            System.out.println("\n\nPlease enter the name of the file:");
                            String fileName = buffReader.readLine();
                            Properties temp = this.loadPropsFile(fileName);
                            out.writeObject(temp);
                            System.out.println(in.readObject());
                        }break;
                        
                        case 2:
                        {
                            System.out.println("\n\nHere is a list of the cars:");
                            out.writeObject(new String("listrequest"));
                            System.out.println(in.readObject());
                            System.out.println("Please enter the model of car you want:");
                            String modelName = buffReader.readLine();
                            System.out.println(modelName);
                            out.writeObject(modelName);
                            System.out.println("1");
                            Object auto = in.readObject();
                            System.out.println(auto.toString());
                            if(auto != null)
                            {
                                System.out.println("?");
                                SelectCarOptions user = new SelectCarOptions((Automobile)auto);
                                user.configureAuto();
                                System.out.println("??");
                            }
                        }
                    }
                }
                catch(NumberFormatException e)
                { 
                    if(userSide.compareToIgnoreCase("exit") != 0)
                        System.out.println("Invalid Input");
                }
                catch(ClassNotFoundException e) { System.err.println(e); }
            } while (!userSide.equals("exit"));
            out.close();
            in.close();
            buffReader.close();
            clientSocket.close();
        }
        catch(IOException e){System.err.println(e);}
	}

	////////// INSTANCE METHODS //////////

	public Properties loadPropsFile(String myFile) {
		Properties props = new Properties();
		try {
			FileInputStream in = new FileInputStream(myFile);
            props.load(in);
		}
		catch (FileNotFoundException e) {
			System.err.println("Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}
		return props;
	}

//	public Object loadTextFile(String fname) {
//		StringBuffer sbuff = new StringBuffer();
//		try {
//			BufferedReader buff = new BufferedReader(new FileReader(fname));
//			boolean eof = false;
//			int counter = 0;
//			while (!eof) {
//				String line = buff.readLine();
//				if (line == null)
//					eof = true;
//				else {
//					if (counter == 0)
//						sbuff.append(line);
//					else
//						sbuff.append("\n" + line);
//				}
//				counter++;
//			}
//			buff.close();
//		}
//		catch (FileNotFoundException e) {
//			System.err.println("Error in file directory ... ");
//			System.exit(1);
//		}
//		catch (IOException e) {
//			System.err.println("Error reading file from directory ... ");
//			System.exit(1);
//		}
//
//		return sbuff;
//	}

}
