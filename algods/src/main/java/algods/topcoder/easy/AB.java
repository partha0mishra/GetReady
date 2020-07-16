package algods.topcoder.easy;

public class AB {
	private static final String EMPTY="";
	private static final String STR_A="A";
	private static final String STR_B="B";
	
	public String createString (int n, int k) {
//		System.out.println(n+":"+k);
		if (n <=0 || k<0) return EMPTY;
		
		StringBuilder result=new StringBuilder();

		int numA = 0;
		int numB = 0;
		int totalNums = Integer.MAX_VALUE;
		int prependB = 0;
		boolean odd=false;
		if (k%2 ==1) {
			k -=1;
			odd=true;
		}
		if(k > 0) {
			int tempNumA = 0;
			int tempNumB = 0;
			int tempTotalNums = 0;
			for(int i=1; i<= k/2; i++) {
				if ((k % i) ==0) {
					tempNumA = i;
					tempNumB = k/i;
					tempTotalNums = tempNumA + tempNumB;
					
					if(tempTotalNums < totalNums) {
						numA = tempNumA;
						numB = tempNumB;
						totalNums = tempTotalNums;
					}
				}
			}// getting the biggest numA
		}
		prependB = n - (numA + numB);
		if (odd) {
			prependB -=1;
		}
		
		if(prependB <0) return EMPTY;

		// creating result- prepend B's
		for(int i=0; i< prependB; i++) {
			result.append(STR_B);
		}
		// creating result- append A's
		for(int i=0; i< numA; i++) {
			result.append(STR_A);
		}
		// creating result - append B's
		for(int i=0; i< numB; i++) {
			result.append(STR_B);
		}
		// adding an A if it's odd
		if(odd) {
//			System.out.println(numA+" "+numB);
			return result.substring(0, result.length()-1).concat("AB");
		}
		
		return result.toString();
	}
}
/*
 * Problem Statement
You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:

The string has exactly N characters, each of which is either 'A' or 'B'.
The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.

Definition
Class: AB
Method: createString
Parameters: int, int
Returns: String
Method signature: String createString(int N, int K)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- N will be between 2 and 50, inclusive.
- K will be between 0 and N(N-1)/2, inclusive.
Examples
0)
3
2
Returns: "ABB"
This string has exactly two pairs (i, j) mentioned in the statement: (0, 1) and (0, 2).
1)
2
0
Returns: "BA"
Please note that there are valid test cases with K = 0.
2)
5
8
Returns: ""
Five characters is too short for this value of K.
3)
10
12
Returns: "BAABBABAAB"
Please note that this is an example of a solution; other valid solutions will also be accepted.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */