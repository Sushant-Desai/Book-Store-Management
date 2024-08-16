package com.bean;

public class DeleteBookBean 
{
	private int bid;

	public DeleteBookBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteBookBean(int bid) {
		super();
		this.bid = bid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "DeleteBookBean [bid=" + bid + "]";
	}
	
	

}
