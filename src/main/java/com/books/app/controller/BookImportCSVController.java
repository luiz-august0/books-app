package com.books.app.controller;

import com.books.app.constants.FileConstants;
import com.books.app.controller.abstracts.BookAdvisorController;
import com.books.app.controller.validation.ValidationError;
import com.books.app.model.BookImportCSVListModel;
import com.books.app.model.enums.EnumBookColumn;
import com.books.app.view.BookImportCSVView;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryResource;
import com.books.core.resource.BookResource;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookImportCSVController extends BookAdvisorController {

    private final BookImportCSVView csvView;
    private final BookResource bookResource;
    private final List<BookDTO> bookList = new ArrayList<>();

    public BookImportCSVController(BookImportCSVView csvView) {
        this.csvView = csvView;
        this.bookResource = (BookResource) FactoryResource.getInstance().get(BookResource.class);
        updateTable();
    }

    public void openExample() {
        try {
            URL url = getClass().getResource(FileConstants.CSV_EXAMPLE);

            if (url != null) {
                URI uri = url.toURI();
                File file = new File(uri);

                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();

                    desktop.open(file);
                } else {
                    throw new RuntimeException("Arquivo não suportado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(csvView, "Ocorreu um erro ao abrir o arquivo de exemplo: " + e.getMessage());
        }
    }

    public void selectCSV() {
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Selecione apenas arquivos CSV",
                "csv"
        );

        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);

        int chooserReturn = chooser.showOpenDialog(csvView);

        if (chooserReturn == JFileChooser.APPROVE_OPTION) {
            int confirmFileDialog = JOptionPane.showConfirmDialog(csvView, "Deseja realmente importar o arquivo: " + chooser.getSelectedFile().getAbsolutePath());

            if (confirmFileDialog == 0) {
                importCSVToTable(chooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    public void saveAll() {
        if (bookList.isEmpty()) {
            JOptionPane.showMessageDialog(csvView, "Não há dados para salvar");
            return;
        }

        try {
            bookList.forEach(bookResource::saveBookFromImport);
            JOptionPane.showMessageDialog(csvView, "Livros salvos com sucesso ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(csvView, "Ocorreu um erro ao salvar os livros: " + e.getMessage());
        }
    }

    private void importCSVToTable(String path) {
        try {
            bookList.clear();

            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<String> lines = bufferedReader.lines().toList();

            for (int index = 1; index < lines.size(); index++) {
                Map<String, Object> values = getMapValuesFromLine(lines.get(index));
                List<ValidationError> errors = getValidationErrors(values);

                if (errors.isEmpty()) {
                    bookList.add(getBookFromValues(values));
                }
            }

            updateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(csvView, "Ocorreu um erro ao importar o arquivo: " + e.getMessage());
        }
    }

    private void updateTable() {
        BookImportCSVListModel bookListModel = new BookImportCSVListModel(bookList);
        csvView.getJListTable().setModel(bookListModel);
    }

    private Map<String, Object> getMapValuesFromLine(String line) {
        Map<String, Object> values = new HashMap<>();

        String[] columnsValue = line.split(",");

        for (int i = 1; i < EnumBookColumn.values().length; i++) {
            EnumBookColumn bookColumn = EnumBookColumn.getByColumn(i);

            if (i > columnsValue.length) {
                values.put(bookColumn.getFieldName(), "");
            } else {
                values.put(bookColumn.getFieldName(), columnsValue[i - 1]);
            }
        }
        return values;
    }

}
