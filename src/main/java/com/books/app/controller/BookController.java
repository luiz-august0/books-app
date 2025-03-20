package com.books.app.controller;

import com.books.app.controller.validation.ValidationError;
import com.books.app.controller.validation.interfaces.IFieldValidation;
import com.books.app.view.BookView;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryResource;
import com.books.core.resource.BookResource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class BookController {

	private static final Map<String, IFieldValidation> validationsMap = new HashMap<>();
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");
	private final BookView bookView;
	private final BookResource bookResource;

	static {
		validationsMap.put("title", (value) -> {
			if (value.toString().isEmpty()) {
				return new ValidationError("Título é obrigatório", 0);
			}

			return null;
		});

		validationsMap.put("authors", (value) -> {
			if (value.toString().isEmpty()) {
				return new ValidationError("Autores é obrigatório", 1);
			}

			return null;
		});

		validationsMap.put("publishDate", (value) -> {
			if (value.toString().replaceAll("/", "").trim().isEmpty()) {
				return new ValidationError("Data de publicação é obrigatório", 2);
			}

			return null;
		});

		validationsMap.put("publisher", (value) -> {
			if (value.toString().isEmpty()) {
				return new ValidationError("Editora é obrigatório", 3);
			}

			return null;
		});
	}
	
	public BookController(BookView bookView) {
		this.bookView = bookView;
		this.bookResource = (BookResource) FactoryResource.getInstance(BookResource.class);
	}
	
	public void onSave() {
        Map<String, Object> values = new HashMap<>();
        
        values.put("title", bookView.getJTitleField().getText());
        values.put("authors", bookView.getJAuthorsField().getText());
        values.put("publishDate", bookView.getJPublishDateField().getText());
        values.put("isbn", bookView.getJISBNField().getText());
        values.put("publisher", bookView.getJPublisherField().getText());        
        values.put("similarBooks", bookView.getJSimilarBooksField().getText());
        
        save(values);
	}

	private void save(Map<String, Object> values) {
		if (validate(values)) {
			bookResource.createBook(BookDTO.builder()
					.title(values.get("title").toString())
					.authors(values.get("authors").toString())
					.publishDate(.parse(values.get("publishDate").toString()))
					)
		}
	}
	
	private boolean validate(Map<String, Object> values) {
		List<ValidationError> errors = new ArrayList();

		values.forEach((field, value) -> {
			IFieldValidation fieldValidation = validationsMap.get(field);

			if (fieldValidation != null) {
				ValidationError validationError = fieldValidation.validate(value);

				if (validationError != null)
					errors.add(validationError);
			}
		});

		errors.sort(Comparator.comparing(ValidationError::getOrder));

		if (!errors.isEmpty()) {			
			JOptionPane.showMessageDialog(bookView, String.join("\n", errors.stream().map(ValidationError::getError).toList()));
			return false;
		}
		
		return true;
	}

}
