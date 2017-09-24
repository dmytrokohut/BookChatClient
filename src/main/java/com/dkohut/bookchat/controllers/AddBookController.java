package com.dkohut.bookchat.controllers;

import java.io.IOException;

import com.dkohut.bookchat.common.entity.Book;
import com.dkohut.bookchat.common.entity.BookServiceGrpc;
import com.dkohut.bookchat.common.entity.ResponseEnum;
import com.dkohut.bookchat.common.entity.ResponseMessage;

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

public class AddBookController {
	
	@FXML private TextField newTitleField;
	@FXML private TextField newGenreField;
	@FXML private TextField newAuthorField;
	@FXML private TextField newPubDateField;
	@FXML private TextField newPriceField;
	
	@FXML private Button addBookButton;
	@FXML private Button cancelAddBookButton;
	
	
	private MainController controller = new MainController();

	public void showDialog() {
		Stage stage = new Stage();
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/AddBook.fxml"));
			Scene scene = new Scene(root,275,245);
			stage.setScene(scene);
			stage.setTitle("BookChat Client");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addBook(ActionEvent actionEvent) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
				.usePlaintext(true)
				.build();
		
		BookServiceGrpc.BookServiceBlockingStub serverStub = BookServiceGrpc.newBlockingStub(channel);
		
		ResponseMessage response = serverStub.createBook(Book.newBuilder()
				.setId(0)
				.setTitle(newTitleField.getText())
				.setGenre(newGenreField.getText())
				.setAuthor(newAuthorField.getText())
				.setPublicationDate(newPubDateField.getText())
				.setPrice(new Float(newPriceField.getText()))
				.build());
		
		if(response.getResponse().equals(ResponseEnum.SUCCESS)) {
			Stage stage = (Stage)cancelAddBookButton.getScene().getWindow();
			stage.close();

			controller.showMainDialog();
		} else {
			newTitleField.setText("");
			newGenreField.setText("");
			newAuthorField.setText("");
			newPubDateField.setText("");
			newPriceField.setText("");
		}
		
	}
	
	public void cancelAddBook(ActionEvent actionEvent) {
		Stage stage = (Stage)cancelAddBookButton.getScene().getWindow();
		stage.close();
	}
	
}
