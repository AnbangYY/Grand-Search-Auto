package com.example.a2100assignment;

import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class QueryTokenizer implements Tokenizer{
    // converts search query into tokens with types indicated
    // separate the query string.
    // A string that contains following components:
    // alphabets*|digits*|symbols
    // Sample Query: BMW, 5 seats, rose, price<500000

    private String text;
    private int pos;
    private Object current;

    static final char whiteSpace[] = {' ', '\n', '\t'};
    static final char symbol[] = { ',', ';', '<', '>', '='};
    static final char alphabet[] = {'a', 'b', 'c', 'd', };
    static final char divide = ',';
    static final char teminate = ';';

    public QueryTokenizer(String text){
        this.text = text;
        pos = 0;
        nextToken();
    }


    @Override
    public Object currentToken() {
        return current;
    }

    @Override
    public void nextToken() {
        consumeWhite();
        if(pos == text.length()){
            current = null;
        } else if(isin(text.charAt(pos), symbol)){    //Tokenize symbols
            current = "" + text.charAt(pos);
            pos++;
        } else if(Character.isLetter(text.charAt(pos))){ //Tokenize string
            int start = pos;
            while(pos<text.length()&&Character.isLetter(text.charAt(pos))){
                pos++;
                current = text.substring(start, pos);
            }
        } else if(Character.isDigit(text.charAt(pos))){  //tokenize numbers
            int start = pos;
            while(pos<text.length()&&Character.isDigit(text.charAt(pos))){
                pos++;
                current = text.substring(start, pos);
            }
        } else {
            //showInvalidInputMessage();
        }


    }

    @Override
    public void consumeWhite() {
        while(pos<text.length() && isin(text.charAt(pos), whiteSpace)){
            pos++;
        }

    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    private boolean isin(char c, char charlist[]){
        for (char w : charlist){
            if (w==c){
                return true;
            }
        }
        return false;
    }


}
