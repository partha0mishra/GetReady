package com.leetcode.recursion._explore;

import java.util.*;
public class SameKeyCard3TimeAlert {
	HashMap<String,Person> people;
	class Person{
		List<int[]> times;
		boolean violator=false;
		public Person() {times=new ArrayList<int[]>();}
		public void addTime(String t) {
			int hh=Integer.valueOf(t.split(":")[0]);
			int mm=Integer.valueOf(t.split(":")[1]);
			times.add(new int[] {hh,mm});
			Collections.sort(times,(t1,t2) -> timeDiff(t1,t2));
			int diff1=0,diff2=0;
			int lasthh=times.get(0)[0], lastmm=times.get(0)[1];
			for(int i=1; i< times.size(); i++) {
				
				int h=times.get(i)[0];
				int m=times.get(i)[1];
				int diff=60*(h-lasthh)+(m-lastmm);
//				System.out.println(h+":"+m+"-"+lasthh+":"+lastmm+" > "+diff);
				diff1=diff2;
				diff2=diff;
				if(diff1!=0 && (diff1+diff2) <=60) {
					violator=true;
					return;// once a violator, always
				}
				lasthh=h;lastmm=m;
			}
		}
		private int timeDiff(int[] t1, int[] t2) {
			if(t1[0] == t2[0]) return t1[1]-t2[1];
			return t1[0]-t2[0];
		}
	}
	public List<String> alertNames(String[] keyName, String[] keyTime) {
        people=new HashMap<String,Person>();
        for(int i=0; i< keyName.length; i++) {
        	if(!people.containsKey(keyName[i])) {
        		people.put(keyName[i], new Person());
        	}
        	if(!people.get(keyName[i]).violator) {
        		people.get(keyName[i]).addTime(keyTime[i]);
        	}
        }
        List<String> violators= new ArrayList<String>();
        for(String p: people.keySet()) {
        	if(people.get(p).violator) violators.add(p);
        }
        Collections.sort(violators);
        return violators;
    }
	public static void main(String[] args) {
		SameKeyCard3TimeAlert instance= new SameKeyCard3TimeAlert();
		System.out.println(instance.alertNames(new String[] {"daniel","daniel","daniel","luis","luis","luis","luis"},new String[] {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));// daniel
		System.out.println(instance.alertNames(new String[] {"alice","alice","alice","bob","bob","bob","bob"},new String[] {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}));// bob
		System.out.println(instance.alertNames(new String[] {"john","john","john"},new String[] {"23:58","23:59","00:01"}));// [] events are of the SAME day. No handling shifting to 00
		System.out.println(instance.alertNames(new String[] {"leslie","leslie","leslie","clare","clare","clare","clare"},new String[] {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"}));// clare, leslie
		System.out.println(instance.alertNames(new String[] {"a","a","a","a","a","a","b","b","b","b","b"},new String[] {"23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41"}));// [a] 
		System.out.println(instance.alertNames(new String[] {"a","a","a","a","a","b","b","b","b","b","b"},new String[] {"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"}));// [a] All events in the same day
	}
}
