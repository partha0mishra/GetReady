package com.algods.leetcode.backtracking;
//TODO Anki
/* 401. Binary Watch
 * 
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * 
 * Given a non-negative integer n which represents the number of LEDs that are currently on, 
 * return all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * */
import java.util.*;
public class BinaryWatch {
	int[] leds=new int[] {8,4,2,1,32,16,8,4,2,1};// All the values
	int maxMin=59, maxHour=11;
	public List<String> readBinaryWatch(int num) {
		List<String> result= new ArrayList<String>();
		backtrack(num, result, new ArrayList<Integer>(),0);// total minutes=0, starting pos=0, ledCount=0
		return result;
    }
	private void backtrack(int num, List<String> result, ArrayList<Integer> temp,int start) {
		if(temp.size()==num) {// we have required number of lights on
			int hours=0;
			int mins=0;
			for(int t: temp) {
				if(t< 4) hours+=leds[t];
				else mins+=leds[t];
			}
			if(hours > maxHour || mins > maxMin) return;// invalid case
			
			String hh=String.valueOf(hours);
			String mm=String.valueOf(mins);
			if(mm.length() < 2) mm="0".concat(mm);
			result.add(hh+":"+mm);
			return;
		}
		for(int i=start; i< 10; i++) {
			temp.add(i);
			backtrack(num, result, temp,i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(new BinaryWatch().readBinaryWatch(0));
		System.out.println(new BinaryWatch().readBinaryWatch(1));
		System.out.println(new BinaryWatch().readBinaryWatch(2));
		System.out.println(new BinaryWatch().readBinaryWatch(3));
		System.out.println(new BinaryWatch().readBinaryWatch(4));
		System.out.println(new BinaryWatch().readBinaryWatch(5));
		System.out.println(new BinaryWatch().readBinaryWatch(6));
		System.out.println(new BinaryWatch().readBinaryWatch(7));
		System.out.println(new BinaryWatch().readBinaryWatch(8));
		System.out.println(new BinaryWatch().readBinaryWatch(9));
		System.out.println(new BinaryWatch().readBinaryWatch(10));
	}
}
