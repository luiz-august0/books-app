package com.books.app.model;

import com.books.app.model.enums.EnumBookColumn;
import com.books.core.dto.BookDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookImportCSVListModel extends AbstractTableModel {

    private final List<BookDTO> books;

    public BookImportCSVListModel(List<BookDTO> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return EnumBookColumn.values().length - 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BookDTO book = books.get(rowIndex);

        return EnumBookColumn.getByColumn(columnIndex + 1).getValueGetter().getValue(book);
    }

    @Override
    public String getColumnName(int column) {
        return EnumBookColumn.getByColumn(column + 1).getHeaderName();
    }

}
