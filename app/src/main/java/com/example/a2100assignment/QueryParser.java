package com.example.a2100assignment;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class QueryParser {
    // Grammer : "Brand" = "String"|"Color" = "String"|("seat" ">" "digit" |"seat" "<" "digit" | "seat" "=" "digit")|("Price" ">" "digit" |"Price" "<" "digit" | "Price" "=" "digit")



    public static BrandExp parseBrand(QueryTokenizer q){
        BrandExp b = new BrandExp("");
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("brand")){
                q.nextToken();
                if(q.currentToken().toString().equals("=") && q.hasNext()){
                    q.nextToken();
                    b.brandName = (String)q.currentToken();
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

    public static ColorExp parseColor(QueryTokenizer q){
        ColorExp c = new ColorExp("");
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("color")){
                q.nextToken();
                if(q.currentToken().toString().equals("=") && q.hasNext()){
                    q.nextToken();
                    c.colorName = (String)q.currentToken();
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

    public static SeatExp parseSeat(QueryTokenizer q){
        SeatExp s = new SeatExp(0, true);
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("seat")){
                q.nextToken();
                if((q.currentToken().toString().equals("=")||q.currentToken().toString().equals(">")||q.currentToken().toString().equals("<")) && q.hasNext()){
                    q.nextToken();
                    if((q.currentToken().toString().equals("<"))){
                        s.compare = false;
                    }
                    s.seatNo = Integer.parseInt((String)q.currentToken());
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




    @Test
    public void testParseBrand(){
        QueryTokenizer n = new QueryTokenizer("Brand = BMW");
        assertEquals("BMW",parseBrand(n).brandName);
    }



}
