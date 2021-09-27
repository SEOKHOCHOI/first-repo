package com.kh.practice.poly.model.vo;

public class CookBook extends RentBook {
	private boolean coupon;
	
	public CookBook(String title, String author, String publisher,
			boolean coupon) {
		super(title, author, publisher, 7);
		this.coupon = coupon;
	}
	
	public boolean getCoupon() {
		return this.coupon;
	}
	
	@Override
	public boolean containTitle(String title) {
		return this.getTitle().contains(title);
	}
	
	@Override
	public String toString() {
		return "CookBook [" + super.toString() + ", coupon=" + coupon
				+ "]";
	}

	@Override
	public int[] rentBook() {
		if(this.coupon) {
			return new int[] {CookBook.SUCCESS_COUPON,
					this.getRentDay()};
		}
		return new int[] {CookBook.SUCCESS, this.getRentDay()};
	}

	@Override
	public int[] rentBook(int age) {
		return this.rentBook();
	}

}
