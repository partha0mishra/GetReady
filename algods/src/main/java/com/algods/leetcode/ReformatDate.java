package com.algods.leetcode;

import java.util.HashMap;

public class ReformatDate {

	@SuppressWarnings("serial")
	private final HashMap<String, String> months= new HashMap<String,String>(){{
		put("Jan","01");put("Feb","02");put("Mar","03");put("Apr","04");put("May","05");put("Jun","06");put("Jul","07");
		put("Aug","08");put("Sep","09");put("Oct","10");put("Nov","11");put("Dec","12");
	}};
	
	public String reformatDate(String date) {
        String tokens[]=date.split(" ");
        String strDay=tokens[0];
        String strMon=tokens[1];
        String strYear=tokens[2];
        
        int dayLen = strDay.length();
        if(dayLen == 3) {
        	strDay="0".concat(strDay);
//        	System.out.println(strDay);
        }
        String dayDigits=strDay.substring(0,2);
        String monDigits=months.get(strMon);
        
        return strYear.concat("-")
        		.concat(monDigits).concat("-")
        		.concat(dayDigits);
    }
	public static void main(String[] args) {
		String input="20th Oct 2052";
		System.out.println(new ReformatDate().reformatDate(input));
	}

}
