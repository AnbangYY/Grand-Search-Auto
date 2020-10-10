package com.example.a2100assignment;

import java.io.IOException;

public enum  Color {
    BLACK("black"),
    WHITE("white"),
    RED("red"),
    PURPLE("purple"),
    YELLOW("yellow"),
    ORANGE("orange"),
    BLUE("blue"),
    GREEN("green"),
    PINK("pink"),
    BROWN("brown"),
    GREY("grey");

   String name;

   private Color(String name){
       this.name = name;
   }

   public static Boolean isColorContained(String c){
       for (Color a:Color.values()
            ) {
           if(c.equals(a.name)){
               return true;
           }
       }
       return false;
   }

   public static Color convertColor(String c) throws IOException {
       if(ColorDictionary.black().contains(c)){
           return BLACK;
       }
       if(ColorDictionary.white().contains(c)){
           return WHITE;
       }
       if(ColorDictionary.red().contains(c)){
           return RED;
       }
       if(ColorDictionary.purple().contains(c)){
           return PURPLE;
       }
       if(ColorDictionary.yellow().contains(c)){
           return YELLOW;
       }
       if(ColorDictionary.orange().contains(c)){
           return ORANGE;
       }
       if(ColorDictionary.blue().contains(c)){
           return BLUE;
       }
       if(ColorDictionary.green().contains(c)){
           return GREEN;
       }
       if(ColorDictionary.pink().contains(c)){
           return PINK;
       }
       if(ColorDictionary.brown().contains(c)){
           return BROWN;
       }
       if(ColorDictionary.grey().contains(c)){
           return GREY;
       }
       return null;
   }






}
