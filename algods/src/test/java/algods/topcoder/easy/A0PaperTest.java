package algods.topcoder.easy;

import static org.junit.jupiter.api.Assertions.*;
import algods.topcoder.easy.A0Paper;

import org.junit.jupiter.api.Test;

class A0PaperTest {
	public static final String POSSIBLE="Possible";
	public static final String IMPOSSIBLE = "Impossible";
	
	@Test
	void test01() {
		int[] numbers={0,3};
		String expected=POSSIBLE;
		
		assertEquals(new A0Paper().canBuild(numbers), expected);
	}
	
	@Test
	void test02() {
		int[] numbers={0,1,2};
		String expected=POSSIBLE;
		
		assertEquals(new A0Paper().canBuild(numbers), expected);
	}
	@Test
	void test03() {
		int[] numbers={0,0,0,0,15};
		String expected=IMPOSSIBLE;
		
		assertEquals(new A0Paper().canBuild(numbers), expected);
	}
	@Test
	void test04() {
		int[] numbers={2,0,0,0,0,0,0,3,2,0,0,5,0,3,0,0,1,0,0,0,5};
		String expected=POSSIBLE;
		
		assertEquals(new A0Paper().canBuild(numbers), expected);
	}

}
