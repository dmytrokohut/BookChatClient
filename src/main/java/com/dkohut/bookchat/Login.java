package com.dkohut.bookchat;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Login extends Application {

	public static void main(String[] args) {
		launch(args);
	}		
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/Login.fxml"));
			Scene scene = new Scene(root,275,160);
			primaryStage.setScene(scene);
			primaryStage.setTitle("BookChat Client");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
