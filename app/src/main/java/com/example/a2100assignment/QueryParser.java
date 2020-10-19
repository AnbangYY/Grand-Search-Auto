package com.example.a2100assignment;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class QueryParser {
    // Grammer : "Brand" = "String"|"Color" = "String"|("seat" ">" "digit" |"seat" "<" "digit" | "seat" "=" "digit")|("Price" ">" "digit" |"Price" "<" "digit" | "Price" "=" "digit")



    public static ManufacturerExp parseBrand(QueryTokenizer q){
        ManufacturerExp b = new ManufacturerExp("");
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("manufacturer")){
                q.nextToken();
                if(q.currentToken().toString().equals("=") && q.hasNext()){
                    q.nextToken();
                    b.manufacturerName = (String)q.currentToken();
                    break;
                }
                else {
                    break;
                    //TODO return a toast indicating invalid input
                }
            }else{
                q.nextToken();
            }
        }
        return b;
    }

    public static ModelExp parseColor(QueryTokenizer q){
        ModelExp c = new ModelExp("");
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("model")){
                q.nextToken();
                if(q.currentToken().toString().equals("=") && q.hasNext()){
                    q.nextToken();
                    c.model= (String)q.currentToken();
                    break;
                }
                else {
                    //TODO return a toast indicating invalid input
                }
            }else{
                q.nextToken();
            }
        }
        return c;
    }

    public static SpeedExp parseSeat(QueryTokenizer q){
        SpeedExp s = new SpeedExp(0, true);
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("seat")){
                q.nextToken();
                if((q.currentToken().toString().equals("=")||q.currentToken().toString().equals(">")||q.currentToken().toString().equals("<")) && q.hasNext()){
                    q.nextToken();
                    if((q.currentToken().toString().equals("<"))){
                        s.compare = false;
                    }
                    s.speed = Integer.parseInt((String)q.currentToken());
                    break;
                }
                else {

                    //TODO return a toast indicating invalid input
                }
            }
            else{
                q.nextToken();
            }
        }
        return s;
    }

    public static PriceExp parsePrice(QueryTokenizer q){
        PriceExp p = new PriceExp(0, true);
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("price")){
                q.nextToken();
                if((q.currentToken().toString().equals("=")||q.currentToken().toString().equals(">")||q.currentToken().toString().equals("<")) && q.hasNext()){
                    q.nextToken();
                    if((q.currentToken().toString().equals("<"))){
                        p.compare = false;
                    }
                    p.price = Integer.parseInt((String)q.currentToken());
                    break;
                }
                else {

                    //TODO return a toast indicating invalid input
                }
            }
            else{
                q.nextToken();
            }
        }
        return p;
    }





}
