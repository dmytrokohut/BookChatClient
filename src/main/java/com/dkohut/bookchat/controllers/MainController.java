package com.dkohut.bookchat.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import com.dkohut.bookchat.common.entity.Book;
import com.dkohut.bookchat.common.entity.BookServiceGrpc;
import com.dkohut.bookchat.common.entity.ChatMessage;
import com.dkohut.bookchat.common.entity.ChatMessageFromServer;
import com.dkohut.bookchat.common.entity.ChatServiceGrpc;
import com.dkohut.bookchat.common.entity.DeleteBookMessage;
import com.dkohut.bookchat.common.entity.ResponseEnum;
import com.dkohut.bookchat.common.entity.ResponseMessage;
import com.dkohut.bookchat.common.entity.SearchBookMessage;

import com.dkohut.bookchat.controllers.LoginController;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {
	
	// List for TableView and ListView
	private ObservableList<Book> bookList = FXCollections.observableArrayList();
	private ObservableList<String> messages = FXCollections.observableArrayList();
	
	// ListView
	@FXML private ListView<String> listViewMessages;
	
	// Button
	@FXML private Button sentMessageButton;
	@FXML private Button bookSearch;
	
	// TextField
	@FXML private TextField messageField;
	@FXML private TextField bookSearchField;
	
	// TableView
	@FXML private TableView<Book> tableViewBooks;
	
	// TableColumns
	@FXML private TableColumn<Book, String> titleColumn;
	@FXML private TableColumn<Book, String> genreColumn;
	@FXML private TableColumn<Book, String> authorColumn;
	@FXML private TableColumn<Book, String> dateColumn;
	@FXML private TableColumn<Book, Float> priceColumn;
	
	
	private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
	
	
	// Creating channel to server
	private static ManagedChannel CHANNEL = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
						.usePlaintext(true)
						.build();
	
	// Service connection's
	ChatServiceGrpc.ChatServiceStub chatService = ChatServiceGrpc.newStub(CHANNEL);	
	BookServiceGrpc.BookServiceBlockingStub bookService = BookServiceGrpc.newBlockingStub(CHANNEL);	
	
	private StreamObserver<ChatMessage> serverChat = chatService.chat(new StreamObserver<ChatMessageFromServer>() {

		@Override
		public void onCompleted() {}

		@Override
		public void onError(Throwable throwable) {}

		@Override
		public void onNext(ChatMessageFromServer chatMessageFromServer) {
			Platform.runLater(() -> {
				messages.add(chatMessageFromServer.getName() + ": " + chatMessageFromServer.getMessage());
			});			
		}
		
	});
	
	
	private void setRecordsTable() {		
		titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publicationDate"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Book, Float>("price"));
		
		tableViewBooks.setItems(bookList);
	}
	
	/**
	 * This method send message to server
	 * 
	 * @param actionEvent
	 */
	public void sendMail(ActionEvent actionEvent) {	
		
		listViewMessages.setItems(messages);
		
		serverChat.onNext(ChatMessage.newBuilder()
				.setName(LoginController.getUserName())
				.setMessage(messageField.getText())
				.build());		
		
	}
	
	
	/**
	 * This method sent request to open AddBook form
	 */
	public void addBook(ActionEvent actionEvent) {
		AddBookController addBookController = new AddBookController();
		
		addBookController.showDialog();
	}
	
	
	/**
	 * This method open Main form
	 */
	public void showDialog() {		
		Stage stage = new Stage();
		BorderPane pane;
		try {			
			pane = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/Main.fxml"));
			Scene scene = new Scene(pane,516,437);
			stage.setScene(scene);
			stage.setTitle("BookChat Client");
			stage.setResizable(false);
			stage.show();				
			
		} catch (IOException | NullPointerException e) {
			LOGGER.info(e.getMessage());
		}			
	}
	

	/**
	 * This method sent message to server for searching of book by given title
	 * 
	 * @param actionEvent
	 */
	public void search(ActionEvent actionEvent) {
		
		try {
			Book book = bookService.searchBook(SearchBookMessage.newBuilder()
				.setTitle(bookSearchField.getText())
				.build());
		
			bookList.add(book);
			setRecordsTable();
			
		} catch(RuntimeException e) {
			LOGGER.info(e.getMessage());
			
			bookSearchField.setText("");
			bookSearchField.setPromptText("Book was not found");
		}
	}
	
	/**
	 * This method sent info to server to delete book with given title
	 * 
	 * @param actionEvent
	 * @throws NullPointerException
	 */
	public void delete(ActionEvent actionEvent) throws NullPointerException {
		
		try {
			Book selectedBook = (Book) tableViewBooks.getSelectionModel().getSelectedItem();
		
			ResponseMessage response = bookService.deleteBook(DeleteBookMessage.newBuilder()
				.setId(selectedBook.getId())
				.build());
		
			if(response.equals(ResponseEnum.SUCCESS))
				bookList.remove(selectedBook);
			
		} catch(RuntimeException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
}
