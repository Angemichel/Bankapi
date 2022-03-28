package com.revature.p0.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.p0.app.Client;

public interface BankServiceInt {
	List<Client>getAllClients();
	
	ArrayList<Client>getOneClient(int real_id);
	
	//ArrayList<Client>
	
	Client postOneClient(Client c1);

	Client updateClient(int client_id, Client c1);
	
	Client deleteOneClient(int client_id);
}
