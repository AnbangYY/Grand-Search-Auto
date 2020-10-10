package com.example.a2100assignment;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

//This class mainly stores the colors in ColorDictionary.txt into respective arraylists.

public class ColorDictionary {

    private static File dictionary = new File("src/main/res/Raw/ColorDictionary.txt");


    public static ArrayList white() throws IOException {
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> white = new ArrayList<>();
        String current;

         while(dictionaryScanner.hasNextLine()){
             current = dictionaryScanner.nextLine();
             if(current.equals("white")){
                 white.add(current);
             }
             else{
                 if(Color.isColorContained(current)){
                     break;
                 }
                 white.add(current);
             }
         }
         return white;
    }

    public static ArrayList<String> black() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("black")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> red() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("red")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> purple() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("purple")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> yellow() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("purple")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> orange() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
                ArrayList<String> o = new ArrayList<>();
                String current;
                Boolean flag = false;


                while(dictionaryScanner.hasNextLine()){
                    current = dictionaryScanner.nextLine();

                    if(flag){
                        if(Color.isColorContained(current)){
                            break;
                        }
                        o.add(current);
            }

            if(current.equals("orange")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> blue() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("blue")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> green() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("green")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }

    public static ArrayList<String> pink() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("pink")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }


    public static ArrayList<String> brown() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("brown")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }


    public static ArrayList<String> grey() throws IOException{
        Scanner dictionaryScanner = new Scanner(dictionary);
        ArrayList<String> o = new ArrayList<>();
        String current;
        Boolean flag = false;


        while(dictionaryScanner.hasNextLine()){
            current = dictionaryScanner.nextLine();

            if(flag){
                if(Color.isColorContained(current)){
                    break;
                }
                o.add(current);
            }

            if(current.equals("grey")){
                o.add(current);
                flag = true;
            }
        }
        return o;
    }
    @Test

    public void testWhiteResult() throws IOException{
        ArrayList<String> expect = new ArrayList();
        expect.add("white");
        expect.add("pearl");
        expect.add("alabaster");
        expect.add("snow");
        expect.add("ivory");
        expect.add("cream");
        expect.add("eggshell");
        expect.add("cotton");
        expect.add("chiffon");
        expect.add("salt");
        expect.add("lace");
        expect.add("coconut");
        expect.add("linen");
        expect.add("bone");
        expect.add("daisy");
        expect.add("powder");
        expect.add("frost");
        expect.add("porcelain");
        expect.add("parchment");
        expect.add("rice");
        assertEquals(expect, white());

    }



@Test
public void testOrangeResult() throws IOException{
    ArrayList<String> expect = new ArrayList();
    expect.add("orange");
    expect.add("tangerine");
    expect.add("marigold");
    expect.add("cider");
    expect.add("rust");
    expect.add("ginger");
    expect.add("tiger");
    expect.add("fire");
    expect.add("bronze");
    expect.add("cantaloupe");
    expect.add("apricot");
    expect.add("clay");
    expect.add("honey");
    expect.add("carrot");
    expect.add("squash");
    expect.add("spice");
    expect.add("marmalade");
    expect.add("amber");
    expect.add("sandstone");
    expect.add("yam");
    assertEquals(expect, orange());
    }
}



