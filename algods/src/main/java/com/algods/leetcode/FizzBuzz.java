package com.algods.leetcode;
/*
 * Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output �Fizz� instead of the number and for the multiples of five output �Buzz�. For numbers which are multiples of both three and five output �FizzBuzz�.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 */
import java.util.*;
public class FizzBuzz {
	/* Approach 02: without if-else */
	public List<String> fizzBuzz(int n){
		String[] result=new String[n];
		for(int i=1; i<=n; i++)    result[i-1]=String.valueOf(i);
		for(int i=3; i<=n; i+=3)   result[i-1]="Fizz";
		for(int i=5; i<=n; i+=5)   result[i-1]="Buzz";
		for(int i=15; i<=n; i+=15) result[i-1]="FizzBuzz";
		
		return Arrays.asList(result);
	}
	/* Approach 01: Super-easy if-else*/
//    public List<String> fizzBuzz(int n) {
//    	List<String> result= new ArrayList<String>();
//        for(int i=1; i<=n; i++) {
//        	if(i%15 ==0) result.add("FizzBuzz"); 
//        	else if(i%3  ==0) result.add("Fizz");
//        	else if (i%5 ==0) result.add("Buzz");
//        	else result.add(String.valueOf(i));
//        }
//        return result;
//    }
	public static void main(String[] args) {
		FizzBuzz instance= new FizzBuzz();
		System.out.println(instance.fizzBuzz(0));
		System.out.println(instance.fizzBuzz(1));
		System.out.println(instance.fizzBuzz(3));
		System.out.println(instance.fizzBuzz(5));
		System.out.println(instance.fizzBuzz(15));
	}

}
