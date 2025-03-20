package com.books.app.view;

import com.books.app.constants.FormTitleConstants;
import com.books.app.controller.MainController;

import javax.swing.JFrame;

public class MainView extends javax.swing.JFrame {
	
	private final MainController mainController;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuBooks;
    private javax.swing.JMenuItem jMenuItemCreateBooks;
	
    public MainView() {
        initComponents();
        this.mainController = new MainController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        jMenuBooks = new javax.swing.JMenu();
        jMenuItemCreateBooks = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Books");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jMenuBooks.setText("Livros");

        jMenuItemCreateBooks.setText("Criar um novo");
        jMenuItemCreateBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreateBooksActionPerformed(evt);
            }
        });
        jMenuBooks.add(jMenuItemCreateBooks);

        jMenuBar.add(jMenuBooks);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        pack();
    }

    private void jMenuItemCreateBooksActionPerformed(java.awt.event.ActionEvent evt) {
    	mainController.openBookView();
    }
    
}
