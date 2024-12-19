package com.aluracourse.literalura.interfaces;

public interface DataConverterInterface {
    public <T> T getData(String json, Class<T> className);
}