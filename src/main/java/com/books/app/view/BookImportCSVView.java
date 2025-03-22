package com.books.app.view;

import com.books.app.controller.BookImportCSVController;
import lombok.Getter;

@Getter
public class BookImportCSVView extends javax.swing.JInternalFrame {

    private final BookImportCSVController csvController;
    private javax.swing.JTable jListTable;
    private javax.swing.JButton jOpenExampleButton;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JButton jSelectFileButton;

    public BookImportCSVView() {
        initComponents();
        this.csvController = new BookImportCSVController(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jOpenExampleButton = new javax.swing.JButton();
        jSelectFileButton = new javax.swing.JButton();
        jScrollPanel = new javax.swing.JScrollPane();
        jListTable = new javax.swing.JTable();
        jSaveButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Importar CSV");

        jOpenExampleButton.setText("Abrir CSV de exemplo");
        jOpenExampleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpenExampleButtonActionPerformed(evt);
            }
        });

        jSelectFileButton.setText("Selecionar arquivo para importação");
        jSelectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSelectFileButtonActionPerformed(evt);
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

        jSaveButton.setText("Salvar Livros");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSaveButton)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSelectFileButton)
                                                .addComponent(jOpenExampleButton)
                                                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jOpenExampleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSelectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
        );

        pack();
    }

    private void jOpenExampleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        csvController.openExample();
    }

    private void jSelectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        csvController.selectCSV();
    }

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        csvController.saveAll();
    }

}
