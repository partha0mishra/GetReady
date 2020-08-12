package com.algods.msproblem;

import java.io.*;
import java.util.*;
public class CandidateCodePowerPuff {
	
   public static void main(String args[] ) throws Exception {
	String[] lines=new String[3];
	Scanner scanner = new Scanner(System.in);
	lines[0]=scanner.nextLine();
	lines[1]=scanner.nextLine();
	lines[2]=scanner.nextLine();
	//String tokens[] = scanner.nextLine().split(" ");
	
		/*
		 * for(String line: lines) { System.out.println(line); }
		 */
	scanner.close();
	   
	   
	Integer numIngredients=Integer.valueOf(lines[0]);
	String quantityOfEach=lines[1];
	String[] quantityOfEachToken=quantityOfEach.split(" ");
	
	String totalQuantities=lines[2];
	String[] totalQuantitiesToken=totalQuantities.split(" ");
	
	long totalOutput=Long.MAX_VALUE;
	int thisOutput=0;
//	System.out.println("numIngredients"+numIngredients);
	for(int i=0; i< numIngredients; i++) {
		int qoEach=Integer.valueOf(quantityOfEachToken[i]);
		long tqEach=Long.valueOf(totalQuantitiesToken[i]);
		
		thisOutput=(int) (tqEach/qoEach);
		if (thisOutput < totalOutput) {
			totalOutput=thisOutput;
		}
//		System.out.println("qo: "+qoEach+" tq: "+tqEach+" to: "+thisOutput+" total: "+totalOutput);
	}
	
	System.out.println(totalOutput);
   }
}
