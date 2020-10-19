package com.example.a2100assignment;


import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ObtainCarsFromJson {


    public static ArrayList<Car> getCarList(File file) {
        ArrayList carCollection = new ArrayList();
        Gson gson = new Gson();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(file.getAbsolutePath()));
            final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {}.getType();
            carCollection = gson.fromJson(jsonReader, CUS_LIST_TYPE);
        }catch (IOException e){
            e.printStackTrace();
        }



        return carCollection;
    }


    @Test
    public void testGetCarCollection() throws IOException {
        String a = "best";
        String b = "luck";
        assertEquals(a, b);
 }

//    @Test
//    public void testGetCarCollection2() throws IOException {
//        ArrayList e = new ArrayList();
//        Car modelx = new Car("Model X", "Tesla", 138990.0, 5, "RED");
//        Car mustang = new Car("Mustang", "Ford", 35630.0, 4, "RED");
//        Car model3 = new Car("Model 3", "Tesla", 67900.0, 5, "WHITE");
//        Car ftype = new Car("F-Type", "Jaguar", 61600.0, 4, "BLUE");
//        Car corolla = new Car("Corolla", "Toyota", 17490.0, 5, "YELLOW");
//        Car cullinan = new Car("Cullinan", "Rolls Royce", 325000.0, 5, "BLACK");
//        e.add(modelx.getName());
//        e.add(mustang.getName());
//        e.add(model3.getName());
//        e.add(ftype.getName());
//        e.add(corolla.getName());
//        e.add(cullinan.getName());
//
//        File f = new File("C:\\Users\\75564\\AndroidStudioProjects\\2100Assignment\\app\\src\\main\\Resources\\JsonFiles\\carsDetails.json");
//        ArrayList re = new ArrayList();
//
//        for (Car c:getCarList(f)
//             ) {
//            re.add(c.getName());
//        }
//
//
//        assertEquals(e, re);
//    }
}