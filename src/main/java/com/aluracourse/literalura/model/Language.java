package com.aluracourse.literalura.model;

public enum Language {
    US("Ingles"),
    ES("Español");

    private String categoriaOmdb;

    Language(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Language fromString(String text) {

        for (Language categoria : Language.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ningún lenguaje encontrada: " + text);
    }
}