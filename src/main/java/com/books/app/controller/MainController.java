package com.books.app.controller;

import com.books.app.constants.FormTitleConstants;
import com.books.app.view.BookListView;
import com.books.app.view.BookView;
import com.books.app.view.MainView;

public class MainController {
	
	private final MainView mainView;

	public MainController(MainView mainView) {
		this.mainView = mainView;
	}
	
	public void openBookView() {
		BookView createBookView = new BookView();
        mainView.add(createBookView);
        createBookView.setTitle(FormTitleConstants.CREATE_FORM_TITLE);
        createBookView.setVisible(true);
	}
	
	public void openListView() {
		BookListView bookListView = new BookListView();
        mainView.add(bookListView);
        bookListView.setVisible(true);
	}
	

}
