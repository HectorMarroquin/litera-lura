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
        //book.setAuthor(dto.authors().get(0));
        return book;
    }

    // Método para convertir Book a BookDTO (Entidad -> DTO)
 /*   public static BookResponseDTO toDTO(Book book) {
        return new BookResponseDTO(
                book.getTitle(),
                book.getMediaType(),
                Integer.parseInt(book.getDownloadCount()),
                book.getLanguage(),
                book.getAuthor()
        );

    }*/


}
