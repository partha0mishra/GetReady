package com.algods.leetcode.contest;
/* 1622. Fancy Sequence
 * Write an API that generates fancy sequences using the append, addAll, and multAll operations.

Implement the Fancy class:

Fancy() Initializes the object with an empty sequence.
void append(val) Appends an integer val to the end of the sequence.
void addAll(inc) Increments all existing values in the sequence by an integer inc.
void multAll(m) Multiplies all existing values in the sequence by an integer m.
int getIndex(idx) Gets the current value at index idx (0-indexed) of the sequence modulo 109 + 7. If the index is greater or equal than the length of the sequence, return -1.
 

Example 1:

Input
["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
Output
[null, null, null, null, null, 10, null, null, null, 26, 34, 20]

Explanation
Fancy fancy = new Fancy();
fancy.append(2);   // fancy sequence: [2]
fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
fancy.append(7);   // fancy sequence: [5, 7]
fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
fancy.getIndex(0); // return 10
fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
fancy.append(10);  // fancy sequence: [13, 17, 10]
fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
fancy.getIndex(0); // return 26
fancy.getIndex(1); // return 34
fancy.getIndex(2); // return 20
 

Constraints:

1 <= val, inc, m <= 100
0 <= idx <= 105
At most 105 calls total will be made to append, addAll, multAll, and getIndex.
 */
import java.util.*;
/* Approach 01: TLE - Need to keep the total quotient of Ops */
class Fancy {
	int time=0;
	class Num{
		int n,t;
		public Num(int num, int time) {this.n=num; this.t=time;}
	}
	class Ops{
		char operation;int num;
		public Ops(char o, int i) {this.operation=o; this.num=i;}
	}
	
	ArrayList<Num> nums; HashMap<Integer,Ops> ops;
    public Fancy() {
        nums=new ArrayList<Num>();	
        ops=new HashMap<Integer,Ops>();
    }
    
    public void append(int val) {
        nums.add(new Num(val,time));
    }
    
    public void addAll(int inc) {
        ops.put(time++, new Ops('a',inc));
    }
    
    public void multAll(int m) {
    	ops.put(time++, new Ops('m',m));
    }
    
    public int getIndex(int idx) {
        if(idx >= nums.size()) return -1;
        Num n=nums.get(idx);
        long result=n.n;
        for(int i=n.t; i< time; i++) {
        	Ops op=ops.get(i);
        	if(op.operation == 'a') {result+=op.num;}
        	else if(op.operation == 'm') {result*=op.num;}
        	result%=1000000007;
        }
        return (int)result;
    }
    public static void main(String[] args) {
    	Fancy fancy = new Fancy();
    	fancy.append(2);   // fancy sequence: [2]
    	fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
    	fancy.append(7);   // fancy sequence: [5, 7]
    	fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
    	fancy.getIndex(0); // return 10
    	fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
    	fancy.append(10);  // fancy sequence: [13, 17, 10]
    	fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
    	fancy.getIndex(0); // return 26
    	fancy.getIndex(1); // return 34
    	fancy.getIndex(2); // return 20
    }
}
