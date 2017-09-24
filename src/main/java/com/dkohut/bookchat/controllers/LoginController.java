package com.dkohut.bookchat.controllers;

import java.io.IOException;

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
						Stage stage = (Stage)registrationFormButton.getScene().getWindow();
						stage.close();
						
						MainController controller = new MainController();
						controller.showMainDialog();
					} else {
						loginLogField.setText("");
						passwordLogField.setText("");
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
		Stage stage = (Stage)registrationFormButton.getScene().getWindow();
		stage.close();
		
		RegistrationController regController = new RegistrationController();
		regController.showDialog(actionEvent);
	}
	

	public void initDialog() {
		Stage stage = new Stage();
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/Start.fxml"));
			Scene scene = new Scene(root,275,160);
			stage.setScene(scene);
			stage.setTitle("BookChat Client");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
