package com.example.a2100assignment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class Car {
    private int price;
    private double speed;
    private String manufacturer;
    private String model;
    private String type;
    private String imgURL;


    /**
     * Create a uninitialized car.
     */
    public Car() {
    }

    /**
     * Create a car
     *
     * @param manufacturer the brand of car
     * @param price the price of car
     * @param speed the maximum speed of car
     */
    public Car(String manufacturer, String model, double speed, int price, String type, String URL) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.speed = speed;
        this.price = price;
        this.type = type;
        this.imgURL = URL;
    }

    public String getModel(){
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getSpeed() {
        return speed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType(){
        return type;
    }

    public String getImgURL(){
        return imgURL;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * this is a method from lab persistent data.
     *
     * @param o an object that we need to compare
     * @return true if two object are same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Car) {
            Car c = (Car) o;
            return this.manufacturer.equals(c.manufacturer) && this.model.equals(c.model)
                    && this.price == c.price && this.speed == c.speed;
        }

        return false;
    }

    /**
     * Save the list of cars' data to a JSON file. From lab Persistent data.
     *
     * @param cars a list of cars
     * @param file the path to a file
     */
    public void saveToJSON(List<Car> cars, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(cars, fw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load a list of cars' data from a JSON file. From lab Persistent data.
     *
     * @param file the path to a file, must be exits.
     * @return a list of cars.
     */
    public List<Car> loadFromJSON(File file) {
        Gson gson = new Gson();
        JsonReader jsonReader = null;

        final Type CUS_LIST_TYPE = new TypeToken<List<Car>>() {
        }.getType();
        // TypeToken.getParameterized(ArrayList.class, PersonJSON.class).getType();

        try {
            jsonReader = new JsonReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gson.fromJson(jsonReader, CUS_LIST_TYPE);
    }

}
