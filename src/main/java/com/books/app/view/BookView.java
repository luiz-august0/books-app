package com.books.app.view;

import com.books.app.controller.BookController;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BookView extends javax.swing.JInternalFrame {
    
    private final BookController bookController;
    private javax.swing.JTextField jAuthorsField;
    private javax.swing.JLabel jAuthorsLabel;
    private javax.swing.JTextField jISBNField;
    private javax.swing.JLabel jISBNLabel;
    private javax.swing.JFormattedTextField jPublishDateField;
    private javax.swing.JLabel jPublishDateLabel;
    private javax.swing.JTextField jPublisherField;
    private javax.swing.JLabel jPublisherLabel;
    private javax.swing.JTextArea jSimilarBooksField;
    private javax.swing.JLabel jSimilarBooksLabel;
    private javax.swing.JScrollPane jSimilarBooksScrollPane;
    private javax.swing.JButton jSubmitButton;
    private javax.swing.JTextField jTitleField;
    private javax.swing.JLabel jTitleLabel;

    public BookView() {
        initComponents();
        this.bookController = new BookController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTitleField = new javax.swing.JTextField();
        jTitleLabel = new javax.swing.JLabel();
        jAuthorsField = new javax.swing.JTextField();
        jAuthorsLabel = new javax.swing.JLabel();
        jPublishDateLabel = new javax.swing.JLabel();
        jPublishDateField = new javax.swing.JFormattedTextField();
        jISBNField = new javax.swing.JTextField();
        jISBNLabel = new javax.swing.JLabel();
        jPublisherLabel = new javax.swing.JLabel();
        jPublisherField = new javax.swing.JTextField();
        jSimilarBooksLabel = new javax.swing.JLabel();
        jSimilarBooksScrollPane = new javax.swing.JScrollPane();
        jSimilarBooksField = new javax.swing.JTextArea();
        jSubmitButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);

        jTitleField.setName(""); // NOI18N

        jTitleLabel.setText("Título *");

        jAuthorsField.setName(""); // NOI18N

        jAuthorsLabel.setText("Autores *");

        jPublishDateLabel.setText("Data da publicação *");

        try {
            jPublishDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jISBNField.setName(""); // NOI18N

        jISBNLabel.setText("ISBN");

        jPublisherLabel.setText("Editora *");

        jPublisherField.setName(""); // NOI18N

        jSimilarBooksLabel.setText("Livros semelhantes");

        jSimilarBooksField.setColumns(20);
        jSimilarBooksField.setRows(5);
        jSimilarBooksScrollPane.setViewportView(jSimilarBooksField);

        jSubmitButton.setText("Salvar");
        jSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSimilarBooksLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitleLabel)
                            .addComponent(jTitleField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAuthorsLabel)
                            .addComponent(jAuthorsField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPublishDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPublishDateField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jISBNLabel)
                            .addComponent(jISBNField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPublisherField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPublisherLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSimilarBooksScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAuthorsLabel)
                    .addComponent(jTitleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAuthorsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPublishDateLabel)
                                .addComponent(jISBNLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPublishDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jISBNField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPublisherLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPublisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jSimilarBooksLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSimilarBooksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTitleField.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("");

        pack();
    }

    private void jSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	bookController.onSave();
    }
    
}
