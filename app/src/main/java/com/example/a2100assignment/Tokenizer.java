package com.example.a2100assignment;


//strategy pattern implementation

public interface Tokenizer {

    public Object currentToken();
    public void nextToken();
    public boolean hasNext();
    public void consumeWhite();



}
