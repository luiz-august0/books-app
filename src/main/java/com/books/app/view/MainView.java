package com.books.app.view;

import com.books.app.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends javax.swing.JFrame {

    private final MainController mainController;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuBooks;
    private javax.swing.JMenuItem jMenuItemCreateBooks;
    private JMenuItem jMenuItemListBooks;
    private JMenuItem jMenuImportCSV;

    public MainView() {
        initComponents();
        this.mainController = new MainController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        jMenuBooks = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livros App");
        setMinimumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));

        jMenuBooks.setText("Livros");
        jMenuItemCreateBooks = new javax.swing.JMenuItem();

        jMenuItemCreateBooks.setText("Criar um novo");
        jMenuItemCreateBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreateBooksActionPerformed(evt);
            }
        });
        jMenuBooks.add(jMenuItemCreateBooks);

        jMenuItemListBooks = new JMenuItem();
        jMenuItemListBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItemListBooksActionPerformed(e);
            }
        });
        jMenuItemListBooks.setText("Visualizar Livros");
        jMenuBooks.add(jMenuItemListBooks);

        jMenuImportCSV = new JMenuItem();
        jMenuImportCSV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuImportCSVActionPerformed(e);
            }
        });
        jMenuImportCSV.setText("Importar CSV");
        jMenuBooks.add(jMenuImportCSV);

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

    private void jMenuItemListBooksActionPerformed(java.awt.event.ActionEvent evt) {
        mainController.openListView();
    }

    private void jMenuImportCSVActionPerformed(java.awt.event.ActionEvent evt) {
        mainController.openImportCSVView();
    }

}
