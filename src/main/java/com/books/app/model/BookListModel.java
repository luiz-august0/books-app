package com.books.app.model;

import com.books.app.model.enums.EnumBookColumn;
import com.books.core.dto.BookDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookListModel extends AbstractTableModel {

    private final List<BookDTO> books;

    public BookListModel(List<BookDTO> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return EnumBookColumn.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BookDTO book = books.get(rowIndex);

        return EnumBookColumn.getByColumn(columnIndex).getValueGetter().getValue(book);
    }

    @Override
    public String getColumnName(int column) {
        return EnumBookColumn.getByColumn(column).getHeaderName();
    }

}
