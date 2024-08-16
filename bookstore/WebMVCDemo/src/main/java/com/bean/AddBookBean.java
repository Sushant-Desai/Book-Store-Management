package com.bean;

public class AddBookBean 
{
	private int bid;
	private String bname;
	private String author;
	private int year;
	private int price;
	
	
	public AddBookBean() 
	{
		super();
	}

	public AddBookBean(int bid, String bname, String author, int year, int price)
	{
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.year = year;
		this.price = price;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "AddBookBean [bid=" + bid +",bname=" + bname + ", author=" + author + ", year=" + year + ", price=" + price + "]";
	}
	
	
	
	
	

}
