package com.algods.learn.algotheory;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class ComparatorStudy {
	int val;
	public ComparatorStudy(int v) {this.val=v;}
	private static final Comparator<ComparatorStudy> cmp=
			new Comparator<ComparatorStudy>(){
		@Override
		public int compare(ComparatorStudy a, ComparatorStudy b) {
			return Integer.compare(a.val, b.val);
		}
	};
	public static void main(String[] args) {
		Random random=ThreadLocalRandom.current();
		ArrayList<ComparatorStudy> list= new ArrayList<ComparatorStudy>();
		int size=10;
		for(int i=0; i< size; i++) {
			list.add(new ComparatorStudy(random.nextInt(size)));
			size+=size;
			list.add(new ComparatorStudy(random.nextInt(size)));
			size+=size;
			list.add(new ComparatorStudy(random.nextInt(size)));
			size+=size;
			list.add(new ComparatorStudy(random.nextInt(size)));
			size+=size;
			list.add(new ComparatorStudy(random.nextInt(size)));
			size/=16;
		}
		Collections.sort(list,cmp);
		for(ComparatorStudy cs: list) {
			System.out.println(cs.val);
		}
	}
}
