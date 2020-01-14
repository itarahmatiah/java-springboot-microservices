package com.in28minutes.rest.webservices.restfulwebservices.helloword;

public class HelloWordBean {

	private String pesan;

	public HelloWordBean(String message) {
		this.pesan = message;
	}

	public String getPesan() {
		return pesan;
	}

	public void setPesan(String pesan) {
		this.pesan = pesan;
	}

	@Override
	public String toString() {
		return "HelloWordBean [pesan=" + pesan + "]";
	}
	
}
