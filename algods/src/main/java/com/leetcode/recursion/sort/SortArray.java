package com.leetcode.recursion.sort;
/* Sort an Array
 * Given an array of integers nums, sort the array in ascending order.
Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Constraints:
1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
 */
public class SortArray {
	/* MergeSort - O(nLogn) O(n)*/
	public int[] sortArray(int[] nums) {
        int[] aux=new int[nums.length];
        System.arraycopy(nums,0,aux,0,nums.length);
        mergeSort(nums, aux, 0, nums.length-1);
        return nums;
    }
    private void mergeSort(int[] n, int[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid=lo+(hi-lo)/2;
        mergeSort(a,n,lo,mid);
        mergeSort(a,n,mid+1,hi);
        merge(n,a,lo,mid,hi);
    }
    private void merge(int[] n, int[] a, int lo, int mid, int hi){
        int i=lo, j=mid+1;
        for(int k=lo; k<=hi; k++){
                 if(i > mid)         n[k]=a[j++];
            else if(j > hi)          n[k]=a[i++];
            else if(a[j] < a[i])     n[k]=a[j++];
            else                     n[k]=a[i++];
        }
    }
}
