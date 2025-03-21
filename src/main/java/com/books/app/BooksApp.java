package com.books.app;

import com.books.app.view.MainView;
import com.books.core.factory.FactoryRepository;

import javax.swing.*;

public class BooksApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FactoryRepository.getInstance().get(FactoryRepository.class);

                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }

}
