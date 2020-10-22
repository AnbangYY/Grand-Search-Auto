package com.example.a2100assignment;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class QueryParser {
    // Grammer : "Brand" = "String"|"Color" = "String"|("seat" ">" "digit" |"seat" "<" "digit" | "seat" "=" "digit")|("Price" ">" "digit" |"Price" "<" "digit" | "Price" "=" "digit")


    String query;
    QueryTokenizer queryTokenizer;

    public QueryParser(String query){
        this.query = query;
        queryTokenizer = new QueryTokenizer(query);
    }

    public ManufacturerExp parseManufacturer(){
        return parseManufacturer(queryTokenizer);
    }

    public static ManufacturerExp parseManufacturer(QueryTokenizer q){
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

    public TypeExp parseType(){
        return parseType(queryTokenizer);
    }


    public static TypeExp parseType(QueryTokenizer q){
        TypeExp c = new TypeExp("");
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("type")){
                q.nextToken();
                if(q.currentToken().toString().equals("=") && q.hasNext()){
                    q.nextToken();
                    c.type= (String)q.currentToken();
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


    public SpeedExp parseSpeed(){
        return parseSpeed(queryTokenizer);
    }


    public static SpeedExp parseSpeed(QueryTokenizer q){
        SpeedExp s = new SpeedExp(0, true);
        while(q.hasNext()){
            if(q.currentToken().toString().toLowerCase().equals("speed")){
                q.nextToken();
                if((q.currentToken().toString().equals("=")||q.currentToken().toString().equals(">")||q.currentToken().toString().equals("<")) && q.hasNext()){
                    if((q.currentToken().toString().equals("<"))){
                        s.compare = false;
                    }
                    q.nextToken();
                    s.speed = Double.parseDouble((String)q.currentToken());
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
                    if((q.currentToken().toString().equals("<"))){
                        p.compare = false;
                    }
                    q.nextToken();
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


    public PriceExp parsePrice(){
        return parsePrice(queryTokenizer);
    }


    public ArrayList<Exp> getExp(){
        ArrayList<Exp> result = new ArrayList<>();
        result.add(parseManufacturer(queryTokenizer));
        result.add(parseType(queryTokenizer));
        result.add(parseSpeed(queryTokenizer));
        result.add(parsePrice(queryTokenizer));
        return result;
    }

    @Test
    public void testParser(){
        query = "type = sports";
        ArrayList<Exp> explist = this.getExp();
        TypeExp t = (TypeExp)explist.get(1);
        assertEquals("sports", t.type);
    }




}
