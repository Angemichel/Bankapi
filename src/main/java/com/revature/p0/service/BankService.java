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
	public Client postOneClient(Client c1) {
		// TODO Auto-generated method stub
		return dao.postOneClient(c1);
	}
	
	@Override
	public Client updateClient(int client_id, Client c1) {
		// TODO Auto-generated method stub
		return dao.updateClient(client_id, c1);
	}
	@Override
	public Client deleteOneClient(int client_id) {
		// TODO Auto-generated method stub
		return dao.deleteOneClient(client_id);
	}
	
	
	
	

}
