package com.kh.practice.poly.model.vo;

public abstract class Book {

	private String title;
	private String author;
	private String publisher;
	
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public abstract boolean containTitle(String title);
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher="
				+ publisher + "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}