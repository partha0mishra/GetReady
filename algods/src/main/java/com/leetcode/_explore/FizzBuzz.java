package com.leetcode._explore;
/*
 * Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

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
	/* Approach 03: Composite Design Pattern - more extensible */
	interface Rule{
	     boolean apply(int i);
	}
	private Map<Rule, String> ruleContainers = new HashMap<Rule,String>();
	private ArrayList<Rule> rules  = new ArrayList<Rule>();
	public FizzBuzz() {
		addRule(i -> i % 15 == 0, "FizzBuzz");
		addRule(i -> i % 3 == 0, "Fizz");
		addRule(i -> i % 5 == 0, "Buzz");
	}
	public void addRule(Rule rule, String res) {
		rules.add(rule);
		ruleContainers.put(rule, res);
	}
	public String getValue(int i) {
        for (Rule rule : rules) {
            if (rule.apply(i)) {
                return ruleContainers.get(rule);
            }
        }
        return String.valueOf(i);
    }
	public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            res.add(getValue(i));
        }
        return res;
    }
	/* Approach 02: without if-else */
//	public List<String> fizzBuzz(int n){
//		String[] result=new String[n];
//		for(int i=1; i<=n; i++)    result[i-1]=String.valueOf(i);
//		for(int i=3; i<=n; i+=3)   result[i-1]="Fizz";
//		for(int i=5; i<=n; i+=5)   result[i-1]="Buzz";
//		for(int i=15; i<=n; i+=15) result[i-1]="FizzBuzz";
//		
//		return Arrays.asList(result);
//	}
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
