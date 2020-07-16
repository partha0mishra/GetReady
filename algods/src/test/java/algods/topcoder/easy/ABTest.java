package algods.topcoder.easy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ABTest {
	
	@Test
	void testAB01() {
		int n=3;
		int k=2;
		assertTrue(validate(new AB().createString(n, k),n,k));
//		assertTrue(validate(result,n,k));
	}

	@Test
	void testAB02() {
		int n=2;
		int k=0;
		assertTrue(validate(new AB().createString(n, k),n,k));
//		assertTrue(validate(result,n,k));
	}
	
	@Test
	void testAB03() {
		int n=5;
		int k=8;
		assertTrue(validate(new AB().createString(n, k),n,k));
//		assertTrue(validate(result,n,k));
	}
	
	@Test
	void testAB04() {
		int n=10;
		int k=12;
		assertTrue(validate(new AB().createString(n, k),n,k));
//		assertTrue(validate(result,n,k));
	}
	
	@Test
	void testAB05() {
		for(int n=2;n<=50; n++) {
			int maxK = n*(n-1)/2;
//			System.out.println(maxK);
			for(int k=0; k <= maxK; k++) {
				String result=new AB().createString(n, k);
				if(validate(result,n,k) == false) {
					System.out.println("["+n+","+k+"] : "+result);
				}
			}
		}
//		assertTrue(validate(result,n,k));
	}

	private boolean validate(String result, int n, int k) {
//		System.out.println("["+n+","+k+"] result: "+result);
		if(result.length() ==0) return true; // not writing this case
		
		if(result.length() != n) return false;
		final char CHAR_A= 'A';
		final char CHAR_B= 'B';
		char[] strArray= result.toCharArray();
		int pairsFound=0;
		
		for(int i=0; i<n; i++) {
			if(strArray[i] == CHAR_A) {
				for(int j=i+1; j<n; j++) {
					if (strArray[j] == CHAR_B) {
						pairsFound++;
						if(pairsFound > k) {
//							System.out.println("pairs found: "+pairsFound);
							return false;
						}
					}
				}
			}
		}
//		System.out.println("pairs found: "+pairsFound);
		if(pairsFound == k) return true;
		
		return false;
	}
}
