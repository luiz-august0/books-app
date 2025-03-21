package com.books.core.infrastructure;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpTemplate<RETURN> {

    private final Class<RETURN> clazz;

    public HttpTemplate(Class<RETURN> clazz) {
        this.clazz = clazz;
    }

    public RETURN get(String uri) {
        HttpClient httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), clazz);
    }

}
