package com.dkohut.bookchat.controllers;

import java.io.IOException;

import com.dkohut.bookchat.common.entity.ResponseEnum;
import com.dkohut.bookchat.common.entity.ResponseMessage;
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

public class RegistrationController {
	
	@FXML private TextField loginRegField;
	@FXML private TextField passwordRegField;
	@FXML private TextField nameRegField;
	@FXML private TextField emaiRegField;
	
	@FXML private Button registrationButton;
	@FXML private Button cancelRegButton;
	
	
	
	public void showDialog(ActionEvent actionEvent) {		
		try {
			Stage primaryStage = new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/Registration.fxml"));
			Scene scene = new Scene(root,275,245);
			primaryStage.setScene(scene);
			primaryStage.setTitle("BookChat Client");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void registerUser(ActionEvent actionEvent) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
				.usePlaintext(true)
				.build();
		
		UserServiceGrpc.UserServiceBlockingStub serverStub = UserServiceGrpc.newBlockingStub(channel);
		
		ResponseMessage response = serverStub.registration(User.newBuilder()
				.setLogin(loginRegField.getText())
				.setPassword(passwordRegField.getText())
				.setName(nameRegField.getText())
				.setEmail(emaiRegField.getText())
				.build());
		
		if(response.getResponse().equals(ResponseEnum.SUCCESS)) {
			loginRegField.setText("Success");
		} else {
			loginRegField.setText("");
			passwordRegField.setText("");
			nameRegField.setText("");
			emaiRegField.setText("");
		}
	}
	
	public void cancelRegister(ActionEvent actionEvent) {
		Stage stage = (Stage)cancelRegButton.getScene().getWindow();
		stage.close();
		
		LoginController controller = new LoginController();
		controller.initDialog();
	}
	
}
