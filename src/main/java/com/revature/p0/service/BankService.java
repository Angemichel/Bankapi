package com.revature.p0.service;

import java.util.ArrayList;
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
	@Override
	public ArrayList<Client> getOneClient(int real_id) {
		// TODO Auto-generated method stub
		
		return dao.getOneClient(real_id);
	}
	@Override
	public Client postClient(Client c1) {
		// TODO Auto-generated method stub
		return dao.postClient(c1);
	}
	
	@Override
	public Client updateClient(int real_id, Client c1) {
		// TODO Auto-generated method stub
		return dao.updateClient(real_id, c1);
	}
	@Override
	public Client deleteOneClient(int real_id) {
		// TODO Auto-generated method stub
		return dao.deleteOneClient(real_id);
	}
	@Override
	public Client postClientAccount(int real_id, Client c1) {
		// TODO Auto-generated method stub
		return dao.postClientAccount(real_id, c1);
	}
	
	@Override
	public ArrayList<Client> getClientsAccount(int real_id) {
		// TODO Auto-generated method stub
		return dao.getClientsAccount(real_id);
	}
	
	
	
	

}
