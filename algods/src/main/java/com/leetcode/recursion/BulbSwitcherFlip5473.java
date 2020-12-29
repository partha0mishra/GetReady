package com.leetcode.recursion;
/*
 * There is a room with n bulbs, numbered from 0 to n-1, arranged in a row from left to right. Initially all the bulbs are turned off.

Your task is to obtain the configuration represented by target where target[i] is '1' if the i-th bulb is turned on and is '0' if it is turned off.

You have a switch to flip the state of the bulb, a flip operation is defined as follows:

Choose any bulb (index i) of your current configuration.
Flip each bulb from index i to n-1.
When any bulb is flipped it means that if it is 0 it changes to 1 and if it is 1 it changes to 0.

Return the minimum number of flips required to form target.
 *
 *Input: target = "10111"
Output: 3
Explanation: Initial configuration "00000".
flip from the third bulb:  "00000" -> "00111"
flip from the first bulb:  "00111" -> "11000"
flip from the second bulb:  "11000" -> "10111"
We need at least 3 flip operations to form target.

Input: target = "101"
Output: 3
Explanation: "000" -> "111" -> "100" -> "101".

Input: target = "00000"
Output: 0

Input: target = "001011101"
Output: 5

Constraints:
1 <= target.length <= 10^5
target[i] == '0' or target[i] == '1'
 */
public class BulbSwitcherFlip5473 {
    public int minFlips(String target) {
        int flips=0;
        char targetChar='0';
        for(int i=0; i< target.length(); i++) {
        	if(target.charAt(i) != targetChar) {
        		flips++;
        		if (targetChar == '0') {
        			targetChar='1';
        		}else {
        			targetChar='0';
        		}
        	}
        }
        return flips;
    }
	public static void main(String[] args) {
		BulbSwitcherFlip5473 instance= new BulbSwitcherFlip5473();
		System.out.println(instance.minFlips("10111"));//3
		System.out.println(instance.minFlips("101"));//3
		System.out.println(instance.minFlips("00000"));//0
		System.out.println(instance.minFlips("001011101"));//5
	}

}
