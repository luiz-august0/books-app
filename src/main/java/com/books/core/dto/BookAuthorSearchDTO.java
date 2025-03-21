package com.books.core.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BookAuthorSearchDTO {

    @Expose
    @SerializedName("name")
    private String name;

}
