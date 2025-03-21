package com.books.core.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BookISBNSearchDTO {

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("authors")
    private List<Map<String, String>> authors;

    @Expose
    @SerializedName("publish_date")
    private String publishDate;

    @Expose
    @SerializedName("publishers")
    private List<String> publishers;

}
