package com.revature.p0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.app.Client;
import com.revature.p0.app.Utils;

public class BankDao implements BankDaoInt {

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		String selectAllClient = "select * from bank";
		ArrayList<Client> cList = new ArrayList<Client>();

		try { pstmt = conn.prepareStatement(selectAllClient);
				rs = pstmt.executeQuery();
				
				Client c;
				while(rs.next()) {
					int id = rs.getInt("real_id");
					String name = rs.getString("Client_Name");
					int account = rs.getInt("account_number");
					int balance = rs.getInt("balance");
					c = new Client(id, name,account,balance);
					cList.add(c);
				}
				rs.close();
				pstmt.close();
				//ctx.json(cList);
				//ctx.status(200);
		
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
		

		return cList;
	}

	@Override
	public ArrayList<Client> getOneClient(int real_id) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		//Client client = ctx.bodyAsClass(Client.class);
		String selectOneClient = "select * from bank where client_id=?";
		ArrayList<Client> cList = new ArrayList<Client>();
		Client c;
		try { 
			pstmt = conn.prepareStatement(selectOneClient);
			pstmt.setInt(1,real_id);
			rs = pstmt.executeQuery();
				
				while(rs.next()) {
					real_id= rs.getInt("client_id");
					String name = rs.getString("Client_Name");
					int account = rs.getInt("account_number");
					int balance = rs.getInt("balance");
					c = new Client(real_id, name,account,balance);
					cList.add(c);
				}
				
				rs.close();
				pstmt.close();
				
		
				} catch (SQLException e) 
			{
					e.printStackTrace();
					
			}
		
		
		
		return cList;
	}

	@Override
	public Client postClient(Client c1) {
		// TODO Auto-generated method stub
		//Client c1 = new Client(Client.class);
		PreparedStatement pstmt;
		//ResultSet rs;
		Connection conn = Utils.createConnection();
		
		try { 
			pstmt = conn.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstmt.setInt(1,c1.getId());
			//pstmt.setInt(1,100);
			pstmt.setString(2, c1.getName());
			pstmt.setInt(3, c1.getAccount());
			pstmt.setInt(4, c1.getBalance());
			pstmt.setInt(5,c1.getId());
			pstmt.execute();
			//ctx.status(201);
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
		return null;
	}


	@Override
	public Client updateClient(int client_id, Client c1) {
		// TODO Auto-generated method stub
		Connection conn = Utils.createConnection();
		
		
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement("update bank set client_name=?, account_number=?,balance=?, real_id=? where client_id=?");
			pstmt.setInt(5,client_id);
			pstmt.setString(1, c1.getName());
			pstmt.setInt(2, c1.getAccount());
			pstmt.setInt(3, c1.getBalance());
			pstmt.setInt(4,client_id);
			
			pstmt.execute();
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
					//ctx.status(404);
			}
		return null;
	}

	@Override
	public Client deleteOneClient(int client_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		Connection conn = Utils.createConnection();
		
		
		try { 
			pstmt = conn.prepareStatement("delete from bank where client_id=?");
			pstmt.setInt(1,client_id);
			pstmt.execute();
			pstmt.close();
			
				} catch (SQLException e) 
			{
					e.printStackTrace();
					
			}
		return null;
	}

	@Override
	public Client postClientAccount(int client_id, Client c1) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		
		
		try { 
			pstmt = conn.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstmt.setInt(1,client_id);
			pstmt.setString(2, c1.getName());
			pstmt.setInt(3, c1.getAccount());
			pstmt.setInt(4, c1.getBalance());
			pstmt.setInt(5,client_id);
			pstmt.execute();
			//ctx.status(201);
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
		return null;
	}

	@Override
	public ArrayList<Client> getClientsAccount(int real_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		
		String selectOneClient = "select * from bank where real_id=?";
		ArrayList<Client> cList = new ArrayList<Client>();
		Client c;
		try { 
			pstmt = conn.prepareStatement(selectOneClient);
			pstmt.setInt(1,real_id);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					real_id= rs.getInt("real_id");
					String name = rs.getString("Client_Name");
					int account = rs.getInt("account_number");
					int balance = rs.getInt("balance");
					c = new Client(real_id, name,account,balance);
					cList.add(c);
				}
				
				rs.close();
				pstmt.close();
				//ctx.json(cList);
				//ctx.status(200);
		
				} catch (SQLException e) 
			{
					e.printStackTrace();
					//ctx.status(404);
			}
		return cList;
	}

}
