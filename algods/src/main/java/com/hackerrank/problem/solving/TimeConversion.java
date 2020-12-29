package com.hackerrank.problem.solving;
/**
 * Time Conversion
 * 
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example


Return '12:01:00'.


Return '00:01:00'.

Function Description

Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):

string s: a time in  hour format
Returns

string: the time in  hour format
Input Format

A single string  that represents a time in -hour clock format (i.e.:  or ).

Constraints

All input times are valid
Sample Input 0

07:05:45PM
Sample Output 0

19:05:45
 */
public class TimeConversion {
	static String timeConversion(String s) {
        char ap=s.charAt(8);
        s=s.substring(0,8);
        Integer hh=Integer.valueOf(s.substring(0,2));
        if(ap == 'P'){
            if(hh < 12) hh+=12;
        }else{
            hh=hh%12;
        }
        s=hh.toString().concat(s.substring(2));
        if(s.length() < 8) s="0".concat(s);
        return s;
    }
}
