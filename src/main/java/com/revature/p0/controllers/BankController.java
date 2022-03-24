package com.revature.p0.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.javalin.http.Handler;

import com.revature.p0.app.Client;
import com.revature.p0.app.Utils;


public class BankController {
	
	public static Handler getAllClients = ctx -> {
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		String selectAllClient = "select * from bank";

		try { pstmt = conn.prepareStatement(selectAllClient);
				rs = pstmt.executeQuery();
				ArrayList<Client> cList = new ArrayList<Client>();
				Client c;
				while(rs.next()) {
					int id = rs.getInt("client_id");
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
		
	};

	public static Handler getOneClient = ctx -> {
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		//Client client = ctx.bodyAsClass(Client.class);
		String selectOneClient = "select * from bank where client_id=?";
		
		try { 
			int client_id =Integer.parseInt(ctx.pathParam("client_id"));
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
	};
	
	public static Handler postClient = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("insert into bank values(?,?,?,?)");
		
		try { 
			pstmt.setInt(1,c1.getId());
			pstmt.setString(2, c1.getName());
			pstmt.setInt(3, c1.getAccount());
			pstmt.setInt(4, c1.getBalance());
			pstmt.execute();
			ctx.status(201);
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
	};
	
	public static Handler postClientAccount = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		PreparedStatement pstmt;
		ResultSet rs;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("insert into bank values(?)");
		
		try { 
			int client_id =Integer.parseInt(ctx.pathParam("client_id"));
			pstmt.setInt(1,client_id);
			pstmt.execute();
			ctx.status(201);
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
			}
	};
	
	public static Handler updateClient = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
		int client_id = Integer.parseInt(ctx.pathParam("client_id"));
		PreparedStatement pstmt;
		//ResultSet rs;
		Connection conn = Utils.createConnection();
		pstmt = conn.prepareStatement("update bank set client_name=?, account_number=?,balance=? where client_id=?");
		
		try { 
			pstmt.setInt(4,client_id);
			pstmt.setString(1, c1.getName());
			pstmt.setInt(2, c1.getAccount());
			pstmt.setInt(3, c1.getBalance());
			pstmt.execute();
			pstmt.close();
				} catch (SQLException e) 
			{
					e.printStackTrace();
					ctx.status(404);
			}
	};
	public static Handler deleteOneClient = ctx -> {
		Client c1 = ctx.bodyAsClass(Client.class);
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
	};
	
	
	
}
