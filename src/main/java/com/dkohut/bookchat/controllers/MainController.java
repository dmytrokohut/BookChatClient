package com.dkohut.bookchat.controllers;

import java.io.IOException;

import com.dkohut.bookchat.common.entity.Book;
import com.dkohut.bookchat.common.entity.BookServiceGrpc;
import com.dkohut.bookchat.common.entity.ChatMessage;
import com.dkohut.bookchat.common.entity.ChatMessageFromServer;
import com.dkohut.bookchat.common.entity.ChatServiceGrpc;
import com.dkohut.bookchat.common.entity.DeleteBookMessage;
import com.dkohut.bookchat.common.entity.ResponseEnum;
import com.dkohut.bookchat.common.entity.ResponseMessage;
import com.dkohut.bookchat.common.entity.SearchBookMessage;

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
	
	// List for TableView
	private ObservableList<Book> bookList = FXCollections.observableArrayList();
	
	// List for ListView tool
	private ObservableList<String> messages = FXCollections.observableArrayList();
	
	// ListView
	@FXML private ListView listViewMessages;
	
	// Button
	@FXML private Button sendButton;
	
	// TextField
	@FXML private TextField messageField;
	@FXML private TextField bookSearchField;
	@FXML private TextField bookSearchButton;
	
	// TableView
	@FXML private TableView<Book> tableViewBooks;
	
	// TableColumns
	@FXML private TableColumn<Book, String> titleColumn;
	@FXML private TableColumn<Book, String> genreColumn;
	@FXML private TableColumn<Book, String> authorColumn;
	@FXML private TableColumn<Book, String> dateColumn;
	@FXML private TableColumn<Book, Float> priceColumn;
	
	
	// Creating channel to server
	private static ManagedChannel CHANNEL = ManagedChannelBuilder.forAddress("127.0.0.1", 8081)
						.usePlaintext(true)
						.build();	
	
	ChatServiceGrpc.ChatServiceStub chatService = ChatServiceGrpc.newStub(CHANNEL);
	
	BookServiceGrpc.BookServiceBlockingStub bookService = BookServiceGrpc.newBlockingStub(CHANNEL);
	
	// Method that send message to server
	public void sendMail() {
		listViewMessages.setItems(messages);		
		
		StreamObserver<ChatMessage> server = chatService.chat(new StreamObserver<ChatMessageFromServer>() {

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
		
		server.onNext(ChatMessage.newBuilder()
				.setName("")
				.setMessage(messageField.getText())
				.build());
	}
	
	
	// Method that open form for adding new book
	public void addBook() {
		Stage stage = new Stage();
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/AddBook.fxml"));
			Scene scene = new Scene(root,275,275);
			stage.setScene(scene);
			stage.setTitle("BookChat Client");
			stage.setResizable(false);
			stage.show();
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	
	// Method that display Main form
	public void showMainDialog() {
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
			e.printStackTrace();
		}
	}
	
	// Method for book searching
	public void bookSearch() {
		Book book = bookService.searchBook(SearchBookMessage.newBuilder()
				.setTitle(bookSearchField.getText())
				.build());
		
		if(book.getId() == 0 && book.getTitle().equals("Not Found")) {
			bookSearchField.setText("Book with such title doesn't exists");
		} else {
			bookList.add(book);
			setRecordsTable();
		}
	}
	
	private void setRecordsTable() {		
		titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publicationDate"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Book, Float>("price"));
		
		tableViewBooks.setItems(bookList);
	}
	
	public void delete(ActionEvent actionEvent) {
		Book selectedBook = (Book) tableViewBooks.getSelectionModel().getSelectedItem();
		
		ResponseMessage response = bookService.deleteBook(DeleteBookMessage.newBuilder()
				.setId(selectedBook.getId())
				.build());
		if(response.getResponse().equals(ResponseEnum.SUCCESS)) {
			bookList.remove(selectedBook);
		}
		
	}
	
}
