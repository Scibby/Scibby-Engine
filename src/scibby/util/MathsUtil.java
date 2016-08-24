package scibby.util;

public class MathsUtil{

	private MathsUtil(){}
	
	public static int clamp(int min, int max, int value){
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
}
