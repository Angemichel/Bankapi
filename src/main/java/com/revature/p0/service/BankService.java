package com.revature.p0.service;

import java.util.List;

import com.revature.p0.app.Client;
import com.revature.p0.dao.BankDao;
import com.revature.p0.dao.BankDaoInt;

public class BankService implements BankServiceInt{
	
	BankDaoInt dao = new BankDao();
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return dao.getAllClients();
	}

}
