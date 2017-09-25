package com.dkohut.bookchat;
	
import com.dkohut.bookchat.controllers.LoginController;

import javafx.application.Application;
import javafx.stage.Stage;


public class Start extends Application {

	public static void main(String[] args) {
		launch(args);
	}		
	
	@Override
	public void start(Stage primaryStage) {
		
		LoginController loginController = new LoginController();
		loginController.showDialog();
	}
	
}
