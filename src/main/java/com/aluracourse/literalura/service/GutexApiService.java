package com.aluracourse.literalura.service;

import com.aluracourse.literalura.dto.ApiGutexResponseDTO;
import com.aluracourse.literalura.dto.BookResponseDTO;
import com.aluracourse.literalura.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GutexApiService {

    private final String BASE_URL = "http://gutendex.com/books";
    private ApiClientService apiClientService;
    private JsonParseService jsonParseService;

    public GutexApiService(ApiClientService apiClientService, JsonParseService jsonParseService) {
        this.apiClientService = apiClientService;
        this.jsonParseService = jsonParseService;
    }

    public BookResponseDTO getBookByName(String bookName){
        String url = BASE_URL + "/?search=" + bookName.replace(" ","+");
        String jsonResponse = apiClientService.realizarGet(url); // TODO: Cambiar nombre

        ApiGutexResponseDTO response = jsonParseService.getData(jsonResponse, ApiGutexResponseDTO.class);

        if( response != null && response.books() != null ){
            return response.books().get(0);
        }

        return null;
    }





}
