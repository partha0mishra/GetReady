package com.leetcode.design;

public class ParkingSystem {
	int bigp, mediump, smallp;
	 public ParkingSystem(int big, int medium, int small) {
	        bigp=big;
	        mediump=medium;
	        smallp=small;
	    }
	    
	    public boolean addCar(int carType) {
	        if(carType == 1) {
	        	if(bigp==0) return false;
	        	else bigp-=1;
	        	return true;
	        }
	        if(carType==2) {
	        	if(mediump==0) return false;
	        	else mediump-=1;
	        	return true;
	        }
	        if(smallp==0) return false;
	        else smallp-=1;
	        return true;
	    }
}
