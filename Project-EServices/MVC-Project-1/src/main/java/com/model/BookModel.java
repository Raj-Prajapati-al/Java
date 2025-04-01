package com.model;

public class BookModel 
{
	private int bookid,subserviceid,customerid;
	private String orderdate,ordertime,bstatus,pstatus,price;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSubserviceid() {
		return subserviceid;
	}
	public void setSubserviceid(int subserviceid) {
		this.subserviceid = subserviceid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getBstatus() {
		return bstatus;
	}
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}

