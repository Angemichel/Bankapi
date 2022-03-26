package com.revature.p0.app;

public class Client {
	private int id;
	private String name;
	private int account;
	private int balance;
	//private int real_id;
	
	
	
	public int getId() {
		return id;
	}
	public Client() {
		super();
	}
	public Client(int id, String name, int account, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
