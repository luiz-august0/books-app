package com.books.app.view;

import com.books.app.controller.BookListController;
import lombok.Getter;

@Getter
public class BookListView extends javax.swing.JInternalFrame {

    private final BookListController bookListController;
    private javax.swing.JTextField jAuthorsField;
    private javax.swing.JLabel jAuthorsLabel;
    private javax.swing.JButton jCleanButton;
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JButton jEditButton;
    private javax.swing.JFormattedTextField jISBNField;
    private javax.swing.JLabel jISBNLabel;
    private javax.swing.JTable jListTable;
    private javax.swing.JButton jNewBookButton;
    private javax.swing.JFormattedTextField jPublishDateField;
    private javax.swing.JLabel jPublishDateLabel;
    private javax.swing.JTextField jPublisherField;
    private javax.swing.JLabel jPublisherLabel;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JButton jSearchButton;
    private javax.swing.JTextArea jSimilarBooksField;
    private javax.swing.JLabel jSimilarBooksLabel;
    private javax.swing.JScrollPane jSimilarBooksScrollPane;
    private javax.swing.JTextField jTitleField;
    private javax.swing.JLabel jTitleLabel;

    public BookListView() {
        initComponents();
        this.bookListController = new BookListController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jTitleLabel = new javax.swing.JLabel();
        jTitleField = new javax.swing.JTextField();
        jAuthorsLabel = new javax.swing.JLabel();
        jAuthorsField = new javax.swing.JTextField();
        jPublishDateLabel = new javax.swing.JLabel();
        jPublishDateField = new javax.swing.JFormattedTextField();
        jPublisherLabel = new javax.swing.JLabel();
        jPublisherField = new javax.swing.JTextField();
        jSimilarBooksLabel = new javax.swing.JLabel();
        jSimilarBooksScrollPane = new javax.swing.JScrollPane();
        jSimilarBooksField = new javax.swing.JTextArea();
        jSearchButton = new javax.swing.JButton();
        jCleanButton = new javax.swing.JButton();
        jScrollPanel = new javax.swing.JScrollPane();
        jListTable = new javax.swing.JTable();
        jEditButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();
        jISBNField = new javax.swing.JFormattedTextField();
        jISBNLabel = new javax.swing.JLabel();
        jNewBookButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Visualizar Livros");

        jTitleLabel.setText("Título");

        jTitleField.setName(""); // NOI18N

        jAuthorsLabel.setText("Autores");

        jAuthorsField.setName(""); // NOI18N

        jPublishDateLabel.setText("Data da publicação");

        try {
            jPublishDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPublisherLabel.setText("Editora");

        jPublisherField.setName(""); // NOI18N

        jSimilarBooksLabel.setText("Livros semelhantes");

        jSimilarBooksField.setColumns(20);
        jSimilarBooksField.setRows(5);
        jSimilarBooksScrollPane.setViewportView(jSimilarBooksField);

        jSearchButton.setText("Pesquisar");
        jSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchButtonActionPerformed(evt);
            }
        });

        jCleanButton.setText("Limpar Filtros");
        jCleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCleanButtonActionPerformed(evt);
            }
        });

        jListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPanel.setViewportView(jListTable);

        jEditButton.setText("Editar");
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonActionPerformed(evt);
            }
        });

        jDeleteButton.setText("Deletar");
        jDeleteButton.setActionCommand("");
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonActionPerformed(evt);
            }
        });

        try {
            jISBNField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-####-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jISBNLabel.setText("ISBN");

        jNewBookButton.setText("Criar novo livro");
        jNewBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewBookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTitleLabel)
                                                        .addComponent(jTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jAuthorsField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jAuthorsLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPublisherField)
                                                                .addGap(211, 211, 211))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPublisherLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPublishDateField)
                                                        .addComponent(jPublishDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jISBNLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jISBNField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addComponent(jScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSimilarBooksLabel)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jCleanButton)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jSearchButton))
                                                                .addComponent(jSimilarBooksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jDeleteButton)
                                                        .addComponent(jEditButton)
                                                        .addComponent(jNewBookButton))))
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTitleLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPublisherLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPublisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jAuthorsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jAuthorsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPublishDateLabel)
                                        .addComponent(jISBNLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jPublishDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jISBNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addComponent(jSimilarBooksLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSimilarBooksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jNewBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSearchButton)
                                        .addComponent(jCleanButton))
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }

    private void jDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        bookListController.delete();
    }

    private void jSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        bookListController.search();
    }

    private void jCleanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        bookListController.clean();
    }

    private void jEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        bookListController.edit();
    }

    private void jNewBookButtonActionPerformed(java.awt.event.ActionEvent evt) {
        bookListController.createNewBook();
    }

}
