package com.kh.practice.poly.model.vo;

public abstract class RentBook extends Book implements RentBookInterface {

	private int rentDay;
	
	public RentBook(String title, String author, String publisher
			, int rentDay) {
		super(title, author, publisher);
		this.rentDay = rentDay;
	}
	
	@Override
	public boolean containTitle(String title) {
		return this.getTitle().contains(title);
	}
	
	public void setRentDay(int day) {
		this.rentDay = day;
	}
	
	public int getRentDay() {
		return this.rentDay;
	}

	@Override
	public String toString() {
		return "RentBook [rentDay=" + rentDay + "]";
	}

}
