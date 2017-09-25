package com.dkohut.bookchat.controllers;

import java.io.IOException;
import java.util.logging.Logger;

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
	
	// TextField's
	@FXML private TextField newTitleField;
	@FXML private TextField newGenreField;
	@FXML private TextField newAuthorField;
	@FXML private TextField newPubDateField;
	@FXML private TextField newPriceField;
	
	// Button's
	@FXML private Button addBookButton;
	@FXML private Button cancelAddBookButton;
	
	private static final Logger LOGGER = Logger.getLogger(AddBookController.class.getName());
	
	
	private static ManagedChannel CHANNEL = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
			.usePlaintext(true)
			.build();
	
	
	/**
	 * This method open AddBook form
	 */
	public void showDialog() {
		Stage stage = new Stage();
		BorderPane root;
		
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/AddBook.fxml"));
			Scene scene = new Scene(root,275,275);
			stage.setScene(scene);
			stage.setTitle("BookChat Client");
			stage.show();
			
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	
	/**
	 * This method sent message to server to create new book in database
	 * 
	 * @param actionEvent
	 */
	public void addBook(ActionEvent actionEvent) {		
		
		BookServiceGrpc.BookServiceBlockingStub serverStub = BookServiceGrpc.newBlockingStub(CHANNEL);
		
		try {			
			ResponseMessage response = serverStub.createBook(Book.newBuilder()
					.setTitle(newTitleField.getText())
					.setGenre(newGenreField.getText())
					.setAuthor(newAuthorField.getText())
					.setPublicationDate(newPubDateField.getText())
					.setPrice(new Float(newPriceField.getText()))
					.build());
			
			if(response.getResponse().equals(ResponseEnum.SUCCESS)) {
				Stage stage = (Stage)cancelAddBookButton.getScene().getWindow();
				stage.close();
			}			
			
		} catch(RuntimeException e) {
			newTitleField.setText("");
			newGenreField.setText("");
			newAuthorField.setText("");
			newPubDateField.setText("");
			newPriceField.setText("");
		}
		
	}
	
	/**
	 * This method close current form
	 * 
	 * @param actionEvent
	 */
	public void cancelAddBook(ActionEvent actionEvent) {
		Stage stage = (Stage)cancelAddBookButton.getScene().getWindow();
		stage.close();
	}
	
}
