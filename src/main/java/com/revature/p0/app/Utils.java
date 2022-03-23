package com.revature.p0.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.javalin.http.Handler;

import com.revature.p0.app.Client;

public class Utils {
	public static Connection createConnection() {
        String url = System.getenv("MY_CONN");
        try {
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
