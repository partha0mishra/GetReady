package com.algods.leetcode.strings;
/* 5537. Split Two Strings to Make Palindrome
 * You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.

Return true if it is possible to form a palindrome string, otherwise return false.

Notice that x + y denotes the concatenation of strings x and y.

 

Example 1:

Input: a = "x", b = "y"
Output: true
Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
aprefix = "", asuffix = "x"
bprefix = "", bsuffix = "y"
Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
Example 2:

Input: a = "abdef", b = "fecab"
Output: false
Example 3:

Input: a = "ulacfd", b = "jizalu"
Output: true
Explaination: Split them at index 3:
aprefix = "ula", asuffix = "cfd"
bprefix = "jiz", bsuffix = "alu"
Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 

Constraints:

1 <= a.length, b.length <= 105
a.length == b.length
a and b consist of lowercase English letters
 */
public class SplitStringsMakePalindrome {
	/* Greedily use all matching letters from suffix and prefix. Then check if the middle of either string is a palindrome. 
	 * This logic can be easily proven by a contradiction. Another way to think about this: using more characters from the 
	 * both strings reduces the size of the middle string, so it increases the chance that the middle part is a palindrome.
	 * Note that we do this twice - once for a] + [b, and once for b] + [a.
	 * With lee215's suggestions to avoid copying the string the code below achieves the fastest runtime.*/
	boolean isPalindrome(String s, int i, int j) {
	    while (i < j && s.charAt(i) == s.charAt(j)) {
	        ++i;
	        --j;
	    }
	    return i >= j;
	}
	boolean check(String a, String b) {
	    int i = 0, j = a.length() - 1;
	    while (i < j && a.charAt(i) == b.charAt(j)) {
	        ++i;
	        --j;
	    }
	    return isPalindrome(a, i, j) || isPalindrome(b, i, j);
	}    
	public boolean checkPalindromeFormation(String a, String b) {
	    return check(a, b) || check(b, a);
	}
	public static void main(String[] args) {
		SplitStringsMakePalindrome instance=new SplitStringsMakePalindrome();
		System.out.println(instance.checkPalindromeFormation("x","y"));// true
		System.out.println(instance.checkPalindromeFormation("abdef","fecab"));// true
		System.out.println(instance.checkPalindromeFormation("xbdef","xecab"));// false
		System.out.println(instance.checkPalindromeFormation("ulacfd","jizalu"));// true
		System.out.println(instance.checkPalindromeFormation("nsltrtzgkjxazdehgfbzpzorrklcaozcpdobaxobvjfyichwtehvxhspulryplkicuzyoilvrdjcysxvuroijemfjivwcfofgxawvjiychtjnznqbdqjjringklftowjchtrfaighzgynzxrvjrpmcomfvjgkuazkwibtwrtyyreynjielurqpynhtfhtujwpqpxkhaiigqlnilpqohgygetlrsgkbyjhpphqqmbndrihucqlkswhwvhhkqvvpwptlzebgnqwlhvllvwlphbfzhcrrpfcovddozmkwshbzmfnhitmhijypxiudpswilstoruocwsxxteearusqyivlforugwreewzbbsbxnacethadvgurttfzvhdddylniawhjuwazbgtxapqtciqxzmlnrtbnqcfrqpkobzqhjcashgjtoiwoyfpunukiztfuwcplidxlnztrcjvplbqglsgnzwdlbzocboehnrmyqowvujdlmucozcffpewdqmdmudescxjskngccjlvmofdv"
															,"dkqxxbtiihevpbplnbnubxosgprhshhantbgyezkgkjrbrfyrpdeplbucprkssmpxffpllslorgqnvlhnavabljjqtyzulatllctaogjafbrbnsxlpwknctxbfgvcmzhgoezcjffjniqomhubotvcokleakdtnmyzctcecmhgbdyzrkwawflkeilmudqckbmhuxsruszkqkotcikozbvttxfopmygkrvwlicicmguciiypeimxterfsbovajpfxbyrkzjkqlmvvmlqkjzkrybxfpjavobsfretxmiepyiicugmcicilwvrkgympofxttvbzokictokqkzsursxuhmbkcqdumlieklfwawkrzydbghmcectczymntdkaelkocvtobuhmoqinjffjczeoghzmcvgfbxtcnkwplxsnbrbfajgoatclltaluzytjfmejioruvxsycjdrvlioyzuciklpyrlupshxvhetwhciyfjvboxabodpczoaclkrrozpzbfghedzaxjkgztrtlsn"));// true
		System.out.println(instance.checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd"
															,"uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));// true
		System.out.println(instance.checkPalindromeFormation("pvhmupgqeltozftlmfjjde"
															,"yjgpzbezspnnpszebzmhvp"));// true
	}
}
