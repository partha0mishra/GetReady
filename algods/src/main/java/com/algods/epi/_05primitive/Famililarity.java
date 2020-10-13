package com.algods.epi._05primitive;

import java.util.Random;

public class Famililarity {
	public static void main(String[] args) {
		System.out.println(6&4);// 4
		System.out.println(1|2);// 3
		System.out.println(8>>1);// 4
		System.out.println(-16 >>> 2);// 4
		System.out.println(-16 >> 2);// 4
		System.out.println(Integer.toBinaryString(-16));
		System.out.println(Integer.toBinaryString(-16 >>> 2));
		System.out.println(Integer.toBinaryString(-16 >> 2));
		System.out.println(1<<10);
		System.out.println(~0);
		System.out.println(Integer.toBinaryString(~0));
		System.out.println(15^5); // 1111 ^ 0101 => 1010 => 10
		System.out.println(Integer.toBinaryString(15)+" "+Integer.toBinaryString(17)
		+" "+Integer.toBinaryString(15^17));// 1111 ^ 10001 => 11110 => 30
		System.out.println(Double.valueOf("1.23"));// takes double or String
		System.out.println(Boolean.valueOf("True"));// takes boolean or String
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("101",2));
		System.out.println(Float.toString((float)-1.23));
		// Maths methods
		System.out.println(Math.abs(-1.23)
				+" "+Math.ceil(3.14)
				+" "+Math.floor(3.14)
				+" "+Math.min(2,-4)
				+" "+Math.max(-2, 2)
				+" "+Math.pow(2.13,4.15)
				+" "+Math.sqrt(225)
				+" "+Math.E
				+" "+Math.PI);
		// Random methods
		Random r=new Random();
		System.out.println(r.nextInt(16)
				+" "+r.nextInt()
				+" "+r.nextBoolean()
				+" "+r.nextDouble());
		// Interconversions
		System.out.println(Character.getNumericValue('x')
				+" "+('x'-0)+" "+('x'-'a')
				+" "+String.valueOf(123));
	}
}
