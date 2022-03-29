package com.revature.p0.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.p0.app.Client;

public interface BankDaoInt {
	
	List<Client>getAllClients();
	
	ArrayList<Client>getOneClient(int real_id);
	
	Client postClient(Client c1);
	
	Client updateClient(int real_id, Client c1);
	
	Client deleteOneClient(int real_id);
	
	Client postClientAccount(int real_id, Client c1);
	
	ArrayList<Client>getClientsAccount(int real_id);

}
