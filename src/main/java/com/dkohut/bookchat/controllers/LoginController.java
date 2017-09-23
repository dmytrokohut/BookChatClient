package com.dkohut.bookchat.controllers;

import com.dkohut.bookchat.common.entity.AccessEnum;
import com.dkohut.bookchat.common.entity.AccessInfo;
import com.dkohut.bookchat.common.entity.LoginMessage;
import com.dkohut.bookchat.common.entity.UserServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	
	// TextField's
	@FXML private TextField loginLogField;
	@FXML private TextField passwordLogField;
	
	// Button's
	@FXML private Button loginButton;
	@FXML private Button registrationFormButton;
	

	/**
	 * This method used for send info to server for login
	 * 
	 * @param actionEvent
	 */
	public void loginInSystem(ActionEvent actionEvent) {	
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
				.usePlaintext(true)
				.build();
		
		UserServiceGrpc.UserServiceStub userService = UserServiceGrpc.newStub(channel);
		
		StreamObserver<LoginMessage> outGoingLogin = userService.login(new StreamObserver<AccessInfo>() {

			@Override
			public void onNext(AccessInfo accessInfo) {
				Platform.runLater(() -> {
					if(accessInfo.getAccess().equals(AccessEnum.ACCESS_GRANTED)) {
						loginLogField.setText("SUCCESS");
						passwordLogField.setText("Your access allowed");
					} else {
						loginLogField.setText("ERROR");
						passwordLogField.setText("You don't have access");
					}
				});							
			}

			@Override
			public void onError(Throwable throwable) {}
			
			@Override
			public void onCompleted() {}
			
		});
		
		outGoingLogin.onNext(LoginMessage.newBuilder()
				.setLogin(loginLogField.getText())
				.setPassword(passwordLogField.getText())
				.build());
	}
	
	public void openRegistrationForm(ActionEvent actionEvent) {
		
	}
}
