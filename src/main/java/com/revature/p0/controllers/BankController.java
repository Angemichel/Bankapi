package com.revature.p0.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.javalin.http.Handler;

import com.revature.p0.app.Client;
import com.revature.p0.app.Utils;
import com.revature.p0.dao.BankDao;
import com.revature.p0.dao.BankDaoInt;
import com.revature.p0.service.BankService;
import com.revature.p0.service.BankServiceInt;


public class BankController {
	
	static BankServiceInt service = new BankService();
	//static BankDaoInt dao = new BankDao();
	public static Handler getAllClients = ctx -> {
		/*
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		String selectAllClient = "select * from bank";

		try { pstmt = conn.prepareStatement(selectAllClient);
				rs = pstmt.executeQuery();
				ArrayList<Client> cList = new ArrayList<Client>();
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
				ctx.json(cList);
				ctx.status(200);
		
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
			*/
		List<Client> cList = service.getAllClients();
		ctx.json(cList);
		ctx.status(200);
	};

	public static Handler getClientsAccount = ctx -> {
		//int real_id =Integer.parseInt(ctx.pathParam("real_id"));
		
		int real_id =Integer.parseInt(ctx.pathParam("real_id"));
		ArrayList<Client> cList = new ArrayList<Client>();
		
		cList = service.getClientsAccount(real_id);
		
		/*
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		Client client = ctx.bodyAsClass(Client.class);
		String selectOneClient = "select * from bank where real_id=?";
		
		try { 
			int real_id =Integer.parseInt(ctx.pathParam("real_id"));
			pstmt = conn.prepareStatement(selectOneClient);
			pstmt.setInt(1,real_id);
			rs = pstmt.executeQuery();
				ArrayList<Client> cList = new ArrayList<Client>();
				Client c;
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
				ctx.json(cList);
				ctx.status(200);
		
				} catch (SQLException e) 
			{
					e.printStackTrace();
					ctx.status(404);
			}
			*/
		ctx.json(cList);
		ctx.status(200);
			
	};
	
	public static Handler getOneClient = ctx -> {
		
		
		int client_id =Integer.parseInt(ctx.pathParam("client_id"));
		ArrayList<Client> cList = new ArrayList<Client>();
		
		cList = service.getOneClient(client_id);
		
		/*PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		//Client client = ctx.bodyAsClass(Client.class);
		String selectOneClient = "select * from bank where client_id=?";
		
		
		try { 
			//int client_id =Integer.parseInt(ctx.pathParam("client_id"));
			pstmt = conn.prepareStatement(selectOneClient);
			pstmt.setInt(1,client_id);
			rs = pstmt.executeQuery();
				ArrayList<Client> cList = new ArrayList<Client>();
				Client c;
				while(rs.next()) {
					client_id= rs.getInt("client_id");
					String name = rs.getString("Client_Name");
					int account = rs.getInt("account_number");
					int balance = rs.getInt("balance");
					c = new Client(client_id, name,account,balance);
					cList.add(c);
				}
				
				rs.close();
				pstmt.close();
				ctx.json(cList);
				ctx.status(200);
		
				} catch (SQLException e) 
			{
					e.printStackTrace();
					ctx.status(404);
			}
		*/
		
		ctx.json(cList);
		ctx.status(200);
	};
	
	public static Handler postClient = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		service.postClient(c1);
		/*
		PreparedStatement pstmt;
		//ResultSet rs;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("insert into bank values(?,?,?,?,?)");
		
		try { 
			pstmt.setInt(1,c1.getId());
			pstmt.setString(2, c1.getName());
			pstmt.setInt(3, c1.getAccount());
			pstmt.setInt(4, c1.getBalance());
			pstmt.setInt(5,c1.getId());
			pstmt.execute();
			ctx.status(201);
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
			*/
		ctx.status(201);
	};
	
	public static Handler postClientAccount = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		int client_id =Integer.parseInt(ctx.pathParam("client_id"));
		service.postClientAccount(client_id, c1);
		/*
		try { 
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("insert into bank values(?,?,?,?,?)");
			int client_id =Integer.parseInt(ctx.pathParam("client_id"));
			pstmt.setInt(1,client_id);
			pstmt.setString(2, c1.getName());
			pstmt.setInt(3, c1.getAccount());
			pstmt.setInt(4, c1.getBalance());
			pstmt.setInt(5,client_id);
			pstmt.execute();
			ctx.status(201);
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
		*/
		ctx.status(201);
	};
	
	public static Handler updateClient = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		int client_id = Integer.parseInt(ctx.pathParam("client_id"));
		service.updateClient(client_id, c1);
		/*
		 int client_id = Integer.parseInt(ctx.pathParam("client_id"));
		 
		PreparedStatement pstmt;
		//ResultSet rs;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("update bank set client_name=?, account_number=?,balance=?, real_id=? where client_id=?");
		
		try { 
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
					ctx.status(404);
			}
			*/
	};
	public static Handler deleteOneClient = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		int client_id = Integer.parseInt(ctx.pathParam("client_id"));
		service.deleteOneClient(client_id);
		
		/*
		PreparedStatement pstmt;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("delete from bank where client_id=?");
		
		try { 
			int client_id =Integer.parseInt(ctx.pathParam("client_id"));
			pstmt.setInt(1,client_id);
			pstmt.execute();
			pstmt.close();
			ctx.status(205);
				} catch (SQLException e) 
			{
					e.printStackTrace();
					ctx.status(404);
			}
		*/
		ctx.status(205);
	};
	
}
