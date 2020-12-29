package com.leetcode.recursion.recursion;
/* 779. K-th Symbol in Grammar
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:

N will be an integer in the range [1, 30].
K will be an integer in the range [1, 2^(N-1)].
* Hint: Try to represent the current (N, K) in terms of some (N-1, prevK). What is prevK ?
 */
public class KthSymbolInGrammar {
	/* Approach 02: N doesn't even matter 
	 * K depends on (K+1)/2. It flips depending on even/ odd position
	 * O(logK) O(logK) */
	public int kthGrammar(int N, int k) {
        if(k == 1 ) return 0;
        if(k%2 ==0 ) return 1- kthGrammar(0, k/2);
        else return kthGrammar(0,(k+1)/2);
    }
	/* Approach 01: brute force. Stack overflow O(2^N) O(2^N) */
//	public int kthGrammar(int N, int K) {
//        int[] elements=new int[(int)Math.pow(2,N-1)];
//        int numElements=1;
//        for(int i=1; i<N ; i++){// number of rows
//            for(int start=0, e=numElements; start< numElements; start++){
//                elements[e++]= elements[start]==0? 1:0;
//            }
//            numElements*=2;
//        }
//        return elements[K-1];
//    }
}
