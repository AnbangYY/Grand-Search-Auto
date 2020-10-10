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
    private double price;
    private int seat;
    private String brand;
    private Color color;
    private String name;

    /**
     * Create a uninitialized car.
     */
    public Car() {
    }

    /**
     * Create a car
     *
     * @param brand the brand of car
     * @param price the price of car
     * @param seat  the number of seats in the car
     */
    public Car(String name, String brand, double price, int seat, Color color) {
        this.brand = brand;
        this.price = price;
        this.seat = seat;
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getSeat() {
        return seat;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor(){
        return color.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
            return this.brand.equals(c.brand) && this.price == c.price
                    && this.seat == c.seat;
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
        //or TypeToken.getParameterized(ArrayList.class, PersonJSON.class).getType();

        try {
            jsonReader = new JsonReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gson.fromJson(jsonReader, CUS_LIST_TYPE);
    }

}
