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

    @Test
    public void testGetCarCollection2() throws IOException {
        ArrayList g = new ArrayList();
//        public Car(String manufacturer, String model, double speed, int price, String type, String URL, boolean promotedItem) {
        Car a = new Car("Model A", "Tesla", 138990.0, 5, "Jeep", "https://www.gta5rides.com/vehicleImages/cropped/VSTR-GTAO-front.png.jpg", true);
        Car b = new Car("Model B", "Tesla", 138990.0, 5, "Jeep", "https://www.gta5rides.com/vehicleImages/cropped/VSTR-GTAO-front.png.jpg");
        Car c = new Car("Model C", "Tesla", 138990.0, 5, "Jeep", "https://www.gta5rides.com/vehicleImages/cropped/VSTR-GTAO-front.png.jpg", true);
        Car d = new Car("Model D", "Tesla", 138990.0, 5, "Jeep", "https://www.gta5rides.com/vehicleImages/cropped/VSTR-GTAO-front.png.jpg");
        Car e = new Car("Model E", "Tesla", 138990.0, 5, "Jeep", "https://www.gta5rides.com/vehicleImages/cropped/VSTR-GTAO-front.png.jpg");
        Car f = new Car("Model F", "Tesla", 138990.0, 5, "Jeep", "https://www.gta5rides.com/vehicleImages/cropped/VSTR-GTAO-front.png.jpg");

        g.add(a);
        g.add(b);
        g.add(c);
        g.add(d);
        g.add(e);
        g.add(f);


        c.showIt(true);
        File h = new File("src\\main\\assets\\PromotedCars.json");
        Car.savePromotedToJSON(g, h);
//        e.add(modelx.getName());
//        e.add(mustang.getName());
//        e.add(model3.getName());
//        e.add(ftype.getName());
//        e.add(corolla.getName());
//        e.add(cullinan.getName());

//        File f = new File("C:\\Users\\75564\\AndroidStudioProjects\\2100Assignment\\app\\src\\main\\Resources\\JsonFiles\\PromotedCars.json");
//        ArrayList re = new ArrayList();

//        for (Car c:getCarList(f)
//             ) {
//            re.add(c.getName());
//        }


//        assertEquals(e, re);
    }
}