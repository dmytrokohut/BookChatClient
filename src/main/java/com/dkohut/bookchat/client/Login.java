package com.dkohut.bookchat.client;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Login extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/Login.fxml"));
			Scene scene = new Scene(root,275,160);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
