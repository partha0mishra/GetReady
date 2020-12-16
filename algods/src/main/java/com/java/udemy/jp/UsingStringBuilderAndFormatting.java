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
	}

}
