package com.kh.practice.poly.model.vo;

public interface RentBookInterface {
	public static final int FAILE = -1;
	public static final int SUCCESS = 0;
	public static final int AGE_LIMIT = 1;
	public static final int SUCCESS_COUPON = 2;
	
	public abstract int[] rentBook();
	public abstract int[] rentBook(int age);
}
