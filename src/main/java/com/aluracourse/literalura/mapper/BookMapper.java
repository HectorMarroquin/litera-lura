package com.aluracourse.literalura.mapper;

import com.aluracourse.literalura.dto.BookResponseDTO;
import com.aluracourse.literalura.model.Book;

public class BookMapper {

    public static Book toEntity(BookResponseDTO dto){

        Book book  = new Book();
        book.setTitle(dto.title());
        book.setMediaType(dto.mediaType());
        book.setLanguage(dto.language());
        book.setDownloadCount(String.valueOf(dto.downloadCount()));
//        book.setAuthor( AuthorMapper.toEntity(dto.authors().get(0)));
        return book;
    }


}
