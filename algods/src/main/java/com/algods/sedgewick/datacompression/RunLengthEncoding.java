package com.algods.sedgewick.datacompression;
/**
 * TODO to implement if found necessary
 * @author Partha.X.Mishra
 *
 */
public class RunLengthEncoding {
	private static final int R    = 256;
    private static final int LG_R = 8; // we're going to use 8 bits to keep counts
    public void compress(String data) {
    	byte[] byteData=data.getBytes();
    	boolean bit=false;
    	for(byte b: byteData) {
    		System.out.println(b);
    	}
    }
    
	public static void main(String[] args) {
		String input01="this is a sample sentence";
		RunLengthEncoding instance= new RunLengthEncoding();
		instance.compress(input01);
	}

}
