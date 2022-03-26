package com.revature.p0.app;

import com.revature.p0.controllers.BankController;

import io.javalin.Javalin;

public class mainPart {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start();
		
		app.get("/", ctx->{ctx.result("Hello World");});
		app.get("/clients", BankController.getAllClients);
		app.get("/clients/{client_id}", BankController.getOneClient);
		app.get("/clients/{real_id}/accounts", BankController.getClientsAccount);
		
		app.post("/clients", BankController.postClient);
		app.post("/clients/{client_id}/accounts", BankController.postClientAccount);
		
		app.put("/clients/{client_id}", BankController.updateClient);
		app.delete("/clients/{client_id}", BankController.deleteOneClient);
		
	}

}
