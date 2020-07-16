package algods.msproblem;

import java.io.*;
import java.util.*;
public class CandidateCodeMaxWinsTwoTeams {
   public static void main(String args[] ) throws Exception {
	   Scanner scanner = new Scanner(System.in);
	   try {
		   String strNumTestCases=scanner.nextLine();
		   int intNumTestCases=Integer.valueOf(strNumTestCases);
		   //System.out.println("ntc: "+intNumTestCases);
		   String strGRevNums= null;
		   String strAStarzNums=null;
		   String strMembers=null;
		   for (int i=0; i< intNumTestCases; i++) {
			   strMembers=scanner.nextLine();
			   strGRevNums=scanner.nextLine();
			   strAStarzNums=scanner.nextLine();
//			   System.out.println("maxwin: "+predictMax(strMembers,strGRevNums, strAStarzNums));
			   System.out.println(predictMax(strMembers,strGRevNums, strAStarzNums));
		   }
	   }finally {
		   scanner.close();
	   }
   }

	private static int predictMax(String strMembers,String strGRevNums, String strAStarzNums) {
		int maxWins=0;
		int numMembers=Integer.valueOf(strMembers);
		String[] tokensGRevNums=strGRevNums.split(" ");
		String[] tokensAStarzNums=strAStarzNums.split(" ");
		
		long[] longGRevNums=new long[(tokensGRevNums.length)];
		long[] longAStarzNums=new long[(tokensAStarzNums.length)];
		
		sortedInsert(tokensGRevNums,longGRevNums);
		sortedInsert(tokensAStarzNums,longAStarzNums);
		
//		System.out.println();
//		printArray(longGRevNums);
//		printArray(longAStarzNums);
//		System.out.println();
		
		int grIndex=0;
		int asIndex=0;
		while(grIndex < longGRevNums.length && asIndex < longAStarzNums.length) {
			long grNum=longGRevNums[grIndex];
			long asNum=longAStarzNums[asIndex];
			
			if(grNum > asNum) {
				maxWins+=1;
				grIndex++;
				asIndex++;
			}else {
				asIndex++;
			}
		}
		
		return maxWins;
	}

	private static void sortedInsert(String[] tokens, long[] longNums) {
		long l=0l;
		for(int i=0; i< tokens.length; i++) {
			l=Long.valueOf(tokens[i]);
			longNums[i]=l;			
		}
		long[] temp=new long[(longNums.length)];
//		System.out.println();
		mergeSortDesc(longNums, temp, 0, longNums.length -1);
	}

	private static void mergeSortDesc(long[] array, long[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		
		int leftEnd=(leftStart+rightEnd)/2;
		int rightStart=leftEnd+1;
		mergeSortDesc(array, temp, leftStart, leftEnd);
		mergeSortDesc(array, temp, rightStart, rightEnd);
		mergeHalves(array, temp, leftStart, leftEnd, rightStart, rightEnd);
	}

	private static void mergeHalves(long[] array, long[] temp, int leftStart, int leftEnd, int rightStart,
			int rightEnd) {
		int left=leftStart;
		int right=rightStart;
		int index=leftStart;
		while(left <= leftEnd && right <= rightEnd) {
//			printArray(array);
			if(array[left] > array[right]) {
				temp[index] = array[left];
				left++;
			}else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		System.arraycopy(array, left, temp, index, leftEnd-left+1);
		System.arraycopy(array, right, temp, index, rightEnd-right+1);
		//printArray(temp);
		System.arraycopy(temp, leftStart, array, leftStart, rightEnd-leftStart+1);		
	}

	private static void printArray(long[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
