package com.kh.practice.poly.model.vo;

public class AniBook extends RentBook {
	private int accessAge;
	
	public AniBook(String title, String author, String publisher
			, int accessAge) {
		super(title, author, publisher, 3);
		this.accessAge = accessAge;
	}
	
	public int getAccessAge() {
		return this.accessAge;
	}
	
	@Override
	public boolean containTitle(String title) {
		return this.getTitle().contains(title);
	}
	
	@Override
	public String toString() {
		return "AniBook [" + super.toString() + ", accessAge=" + accessAge
				+ "]";
	}

	@Override
	public int[] rentBook() {
		return new int[] {AniBook.FAILE, 0};
	}

	@Override
	public int[] rentBook(int age) {
		if(this.accessAge <= age) {
			return new int[] {AniBook.SUCCESS, this.getRentDay()};
		}
		return new int[] {AniBook.AGE_LIMIT, 0};
	}

}