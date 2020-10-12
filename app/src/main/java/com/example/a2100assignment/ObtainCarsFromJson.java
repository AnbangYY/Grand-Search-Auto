package com.example.a2100assignment;


import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ObtainCarsFromJson {


    public static  ArrayList<Car> getCarList(File file) throws IOException{
        ArrayList carCollection = new ArrayList();
        Gson gson = new Gson();
        JsonReader jsonReader = null;

        final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>(){}.getType();
        try {
            jsonReader = new JsonReader(new FileReader(file.getAbsolutePath()));
        }catch (Exception e){
            e.printStackTrace();
        }

        carCollection = gson.fromJson(jsonReader, CUS_LIST_TYPE);

        return carCollection;
    }



    @Test
    public void testGetCarCollection() throws IOException{
        ArrayList e = new ArrayList();
        Car modelx = new Car("Model X", "Tesla", 138990.0, 5, Color.RED);
        Car mustang = new Car("Mustang", "Ford", 35630.0, 4, Color.RED);
        Car model3 = new Car("Model 3", "Tesla", 67900.0, 5, Color.WHITE);
        Car ftype = new Car("F-Type", "Jaguar", 61600.0, 4, Color.BLUE);
        Car corolla = new Car("Collora", "Toyota", 17490.0, 5, Color.YELLOW);
        Car cullinan = new Car("Cullinan", "Rolls Royce", 325000.0, 5, Color.BLACK);
        e.add(modelx);
        e.add(mustang);
        e.add(model3);
        e.add(ftype);
        e.add(corolla);
        e.add(cullinan);


        File f = new File("src/main/Resources/Json Files/carsDetails.json");
        assertEquals(e, getCarList(f));

    }


}
