package com.algods.leetcode;
/**
 * 605. Can Place Flowers
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class PlantingFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n ==0) return true;
        for(int i=0; i< flowerbed.length; i++) {
        	if(flowerbed[i] ==0 && emptyPrev(flowerbed, i) && emptyNext(flowerbed,i)) {
        		flowerbed[i] =1;
        		n--;
        	}
        	if(n ==0) return true;
        }
        return n==0;
    }
	private boolean emptyPrev(int[] flowerbed, int i) {
		if(i==0) return true;
		return flowerbed[i-1]==0;
	}
	private boolean emptyNext(int[] flowerbed, int i) {
		if(i == flowerbed.length-1) return true;
		return flowerbed[i+1]==0;
	}
	public static void main(String[] args) {
		PlantingFlowers instance= new PlantingFlowers();
		assertTrue(instance.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
		assertFalse(instance.canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
		assertTrue(instance.canPlaceFlowers(new int[] {1,0,0,0,0}, 2));
		assertFalse(instance.canPlaceFlowers(new int[] {1,0,0,0,0}, 3));
		assertTrue(instance.canPlaceFlowers(new int[] {0,0,0,0,0}, 1));
		assertTrue(instance.canPlaceFlowers(new int[] {0,0,0,0,0}, 2));
		assertTrue(instance.canPlaceFlowers(new int[] {0,0,0,0,0}, 3));
		assertFalse(instance.canPlaceFlowers(new int[] {0,0,0,0,0}, 4));
		assertFalse(instance.canPlaceFlowers(new int[] {0,0,0,0,0}, 5));
		assertTrue(instance.canPlaceFlowers(new int[] {0,0,0,0,0}, 0));
	}

}
