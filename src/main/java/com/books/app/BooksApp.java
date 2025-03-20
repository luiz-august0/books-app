package com.books.app;

import com.books.app.view.MainView;
import javax.swing.SwingUtilities;

public class BooksApp {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }
    
}
