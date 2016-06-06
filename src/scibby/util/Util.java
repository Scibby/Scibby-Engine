package scibby.util;

import scibby.core.GameContainer;

public class Util{

	public enum Severity{
		MESSAGE, DEBUG, WARNING, SEVERE
	}

	public static void LOG(String message, Severity severity){
		if(true){
			switch(severity){
				case MESSAGE:
					if(true){
						System.out.println("[MESSAGE] " + message);
					}
					break;
				case DEBUG:
					if(true){
						System.out.println("[DEBUG] " + message);
					}
					break;
				case WARNING:
					if(true){
						System.out.println("[WARNING] " + message);
					}
					break;
				case SEVERE:
					break;
			}
		}
	}

	public static void LOG(String message, Severity severity, GameContainer gc){
		switch(severity){
			case MESSAGE:
				break;
			case DEBUG:
				break;
			case WARNING:
				break;
			case SEVERE:
				System.out.println("[Severe] " + message);
				gc.stop();
				break;
		}
	}

}
