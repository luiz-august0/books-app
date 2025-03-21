package com.books.app.view;

import com.books.app.controller.BookListController;
import lombok.Getter;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;

@Getter
public class BookListView extends javax.swing.JInternalFrame {

    private final BookListController bookListController;
    private javax.swing.JTextField jAuthorsField;
    private javax.swing.JLabel jAuthorsLabel;
    private javax.swing.JLabel jISBNLabel;
    private javax.swing.JFormattedTextField jPublishDateField;
    private javax.swing.JLabel jPublishDateLabel;
    private javax.swing.JTextField jPublisherField;
    private javax.swing.JLabel jPublisherLabel;
    private javax.swing.JTextArea jSimilarBooksField;
    private javax.swing.JLabel jSimilarBooksLabel;
    private javax.swing.JScrollPane jSimilarBooksScrollPane;
    private javax.swing.JButton jSearchButton;
    private javax.swing.JTextField jTitleField;
    private javax.swing.JLabel jTitleLabel;
    private JFormattedTextField jISBNField;
    private JButton jCleanButton;
    private JTable jListTable;

    public BookListView() {
    	setTitle("Visualizar Livros");
    	setMinimumSize(new Dimension(1000, 700));
        initComponents();
        this.bookListController = new BookListController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jTitleField = new javax.swing.JTextField();
        jTitleLabel = new javax.swing.JLabel();
        jAuthorsField = new javax.swing.JTextField();
        jAuthorsLabel = new javax.swing.JLabel();
        jPublishDateLabel = new javax.swing.JLabel();
        jPublishDateField = new javax.swing.JFormattedTextField();
        jISBNLabel = new javax.swing.JLabel();
        jPublisherLabel = new javax.swing.JLabel();
        jPublisherField = new javax.swing.JTextField();
        jSimilarBooksLabel = new javax.swing.JLabel();
        jSimilarBooksScrollPane = new javax.swing.JScrollPane();
        jSimilarBooksField = new javax.swing.JTextArea();
        jSearchButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);

        jTitleField.setName(""); // NOI18N

        jTitleLabel.setText("Título");

        jAuthorsField.setName(""); // NOI18N

        jAuthorsLabel.setText("Autores");

        jPublishDateLabel.setText("Data da publicação");

        try {
            jPublishDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jISBNLabel.setText("ISBN");

        jPublisherLabel.setText("Editora");

        jPublisherField.setName(""); // NOI18N

        jSimilarBooksLabel.setText("Livros semelhantes");

        jSimilarBooksField.setColumns(20);
        jSimilarBooksField.setRows(5);
        jSimilarBooksScrollPane.setViewportView(jSimilarBooksField);

        jSearchButton.setText("Pesquisar");

        jISBNField = new JFormattedTextField();

        try {
            jISBNField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-#####-##-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCleanButton = new JButton();
        jCleanButton.setText("Limpar Filtros");

        JPanel jListPanel = new JPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(jSimilarBooksLabel)
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jTitleLabel)
        							.addComponent(jTitleField))
        						.addGap(18)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jAuthorsLabel)
        							.addComponent(jAuthorsField)))
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(jPublishDateField)
        							.addComponent(jPublishDateLabel))
        						.addGap(18)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jISBNLabel)
        							.addComponent(jISBNField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jPublisherLabel)
        							.addComponent(jPublisherField)))
        					.addComponent(jSimilarBooksScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        					.addComponent(jListPanel, GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jCleanButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jSearchButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(31)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jAuthorsLabel)
        				.addComponent(jTitleLabel))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jAuthorsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTitleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jPublishDateLabel)
        						.addComponent(jISBNLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPublishDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPublisherLabel)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jPublisherField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jISBNField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addGap(20)
        			.addComponent(jSimilarBooksLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSimilarBooksScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jSearchButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jCleanButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
        			.addComponent(jListPanel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
        			.addGap(37))
        );

        jListTable = new JTable();
        jListPanel.add(jListTable);
        getContentPane().setLayout(layout);

        jTitleField.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("");

        pack();
    }
}
