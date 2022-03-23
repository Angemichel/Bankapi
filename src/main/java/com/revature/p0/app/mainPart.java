package com.revature.p0.app;

import com.revature.p0.controllers.BankController;

import io.javalin.Javalin;

public class mainPart {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start();
		app.get("/", ctx->{ctx.result("Hello World");});
		app.get("/clients", BankController.getAllClients);
		app.get("/clients/{client_id}", BankController.getOneClient);
		
		app.post("/clients", BankController.postClient);
		app.put("/clients/{client_id}", BankController.postClient);
		app.delete("/clients/{client_id}", BankController.deleteOneClient);
	
	}

}
