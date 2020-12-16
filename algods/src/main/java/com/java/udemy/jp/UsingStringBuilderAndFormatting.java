package com.java.udemy.jp;

public class UsingStringBuilderAndFormatting {
	public static void main(String[] args) {
		String info="";
		info+="this is";
		info+=" ";
		info+="inefficient ";
		info+=". java Strings are ";
		info+="IMMUTABLE";
		System.out.println(info);
		
		StringBuilder sb=new StringBuilder();
		sb.append("this is");
		sb.append(" ");
		sb.append("efficient");
		sb.append(" using StringBuilder.");
		System.out.println(sb);
		
		/* Formatting */
		System.out.print("some text \nsome more");// with \n
		System.out.println(" and some more on the same line.");
		System.out.printf("Quantity: %-5d Rate: %.2f Total: %-5.2f - %s \n", 10, 0.5,(10*0.5),"looks good");
		// using                      -  sign to align left
		// more on floating points printing
		System.out.printf("% .2f \n", 5.6);// 2 decimal points. adds 0 at the end
		System.out.printf("% .2f \n", 5.67);// 2 decimal points
		System.out.printf("% .2f \n", 5.6789);// 2 decimal points. rounded
		System.out.printf("% 6.2f \n", 123.5678);// 6= total width of displayed characters including '.'
		System.out.printf("% -6.2f \n", 123.5678);// - for left alignment
	}

}
