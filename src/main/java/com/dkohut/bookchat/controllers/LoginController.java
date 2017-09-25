package com.dkohut.bookchat.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import com.dkohut.bookchat.common.entity.LoginMessage;
import com.dkohut.bookchat.common.entity.User;
import com.dkohut.bookchat.common.entity.UserServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {
	
	// TextField's
	@FXML private TextField loginLogField;
	@FXML private TextField passwordLogField;
	
	// Button's
	@FXML private Button loginButton;
	@FXML private Button registrationFormButton;
	
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	
	
	// User type 
	private static User user;
	
	// Channel to server
	private static ManagedChannel CHANNEL = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
			.usePlaintext(true)
			.build();
	
	// Connection to UserService
	UserServiceGrpc.UserServiceBlockingStub userService = UserServiceGrpc.newBlockingStub(CHANNEL);

	
	/**
	 * This method used for send info to server for login
	 * 
	 * @param actionEvent
	 */
	public void login(ActionEvent actionEvent) {			
		
		try {
			user = userService.login(LoginMessage.newBuilder()
				.setLogin(loginLogField.getText())
				.setPassword(passwordLogField.getText())
				.build());
			
			Stage stage = (Stage)loginButton.getScene().getWindow();
			stage.close();
				
			MainController controller = new MainController();
			controller.showDialog();
			
		} catch(RuntimeException e) {
			LOGGER.info(e.getMessage());
			
			loginLogField.setText("");
			loginLogField.setPromptText("User not found");
			
			passwordLogField.setText("");
			passwordLogField.setPromptText("Try again");
		}
		
	}
	
	
	/**
	 * This method sent request to open Registration form and close current form
	 * 
	 * @param actionEvent
	 */
	public void openRegistrationForm(ActionEvent actionEvent) {
		Stage stage = (Stage)registrationFormButton.getScene().getWindow();
		stage.close();
		
		RegistrationController regController = new RegistrationController();
		regController.showDialog(actionEvent);
	}
	

	/**
	 * This method initializing the login form
	 */
	public void showDialog() {
		Stage stage = new Stage();
		BorderPane root;
		
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/Login.fxml"));
			Scene scene = new Scene(root,275,160);
			stage.setScene(scene);
			stage.setTitle("BookChat Client");
			stage.show();
			
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	
	/**
	 * This method create new User object
	 */
	public static void initUser(String login, String password, String name, String email) {
		user = User.newBuilder()
			.setLogin(login)
			.setPassword(password)
			.setName(name)
			.setEmail(email)
			.build();
	}
	
	
	/**
	 * This method return a name of user
	 * 
	 * @return name - String type data, contain name of user
	 */
	public static String getUserName() {
		return user.getName();
	}
	
}
