package com.algods.learn.substring;
/* Copied from Tushar Roy's codebase
 * 
 */
import static org.junit.Assert.assertEquals;
public class SimplerRabinKarp {
	private int prime = 101;
	private long primePowerLenMinusOne;
    
    public int patternSearch(char[] text, char[] pattern){
        int m = pattern.length;
        int n = text.length;
        long patternHash = createHash(pattern, m - 1);
        long textHash = createHash(text, m - 1);
        primePowerLenMinusOne=(long) Math.pow(prime, m-1);// precomputed
        for (int i = 1; i <= n - m + 1; i++) {// matching has for i-1. The loop therefore needs to go till n-m+1
            if(patternHash == textHash && checkEqual(text, i - 1, i + m - 2, pattern, 0, m - 1)) {
                return i - 1;
            }
            if(i < n - m + 1) {
                textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
            }
        }
        return n;
    }
    
    private long recalculateHash(char[] str,int oldIndex, int newIndex,long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/prime;
        newHash += str[newIndex]*primePowerLenMinusOne;//Math.pow(prime, patternLen - 1);
        return newHash;
    }
    
    private long createHash(char[] str, int end){
        long hash = 0;
        for (int i = 0 ; i <= end; i++) {
            hash += str[i]*Math.pow(prime,i);
        }
        return hash;
    }
    
    private boolean checkEqual(char str1[],int start1,int end1, char str2[],int start2,int end2){
        if(end1 - start1 != end2 - start2) return false;
        while(start1 <= end1 && start2 <= end2){
            if(str1[start1++] != str2[start2++]) return false;
        }
        return true;
    }
    
    public static void main(String args[]){
        SimplerRabinKarp instance = new SimplerRabinKarp();
        assertEquals(2,instance.patternSearch("TusharRoy".toCharArray(), "sharRoy".toCharArray()));
        assertEquals(6,instance.patternSearch("TusharRoy".toCharArray(), "Roy".toCharArray()));
        assertEquals(9,instance.patternSearch("TusharRoy".toCharArray(), "shas".toCharArray()));
        assertEquals(1,instance.patternSearch("TusharRoy".toCharArray(), "usha".toCharArray()));
        assertEquals(0,instance.patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));
    }
}
