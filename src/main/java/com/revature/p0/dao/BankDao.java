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

}
