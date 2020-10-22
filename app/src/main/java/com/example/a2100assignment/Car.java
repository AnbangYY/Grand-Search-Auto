package com.example.a2100assignment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {
    private int price;
    private double speed;
    private String manufacturer;
    private String model;
    private String type;
    private String imgURL;
    private int originalPrice;
    private boolean show;
    private boolean promotedItem = false;


    /**
     * Create a uninitialized car.
     */
    public Car() {
    }

    public Car(String manufacturer, String model, double speed, int price, String type, String URL, boolean promotedItem) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.speed = speed;
        this.price = price;
        this.type = type;
        this.imgURL = URL;
        this.promotedItem = promotedItem;
    }

    /**
     * Create a car
     *
     * @param manufacturer the brand of car
     * @param price        the price of car
     * @param speed        the maximum speed of car
     */
    public Car(String manufacturer, String model, double speed, int price, String type, String URL) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.speed = speed;
        this.price = price;
        this.type = type;
        this.imgURL = URL;
    }

    public String getModel() {
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

    public String getType() {
        return type;
    }

    public String getImgURL() {
        return imgURL;
    }

    public boolean isPromotedItem() {
        return this.promotedItem;
    }

    public void showIt(boolean show) {
        this.show = show;
    }

    public boolean showOrNot() {
        return this.show;
    }

    public void setItPromoted(boolean promoted, double account) {
        this.promotedItem = promoted;
        if (promoted) {
            this.originalPrice = this.price;
            this.price = (int) account * this.price;
        } else {
            this.price = this.originalPrice;
        }
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
    public static void savePromotedToJSON(List<Car> cars, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Car> promoted = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).isPromotedItem()) promoted.add(cars.get(i));
        }
        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(promoted, fw);
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


    @Override
    public int compareTo(Car o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() == o.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * This is a method that take two String and return if they are approximately to each other.
     * Here, "approximately" means:
     * - case insensitive
     * - have same characters but with different order
     * - have approximately 75% correctness.
     *
     *
     * currently not working well.
     *
     * @param a the string to be compared
     * @param b the string to be compared
     * @return if these two string are approximately equal to each other.
     */
//    public static boolean approximateEqual(String a, String b) {
//        if (a.equalsIgnoreCase(b)) {
//            return true;
//        } else if (a.length() - b.length() > 5) {
//            return false;
//        } else {
//            ArrayList<Character> AErrors = new ArrayList<>();
//            ArrayList<Character> BErrors = new ArrayList<>();
//            for (int i = 0; i < a.length() && i < b.length(); i++) {
//                if (a.charAt(i) != b.charAt(i)) {
//                    AErrors.add(a.charAt(i));
//                    BErrors.add(b.charAt(i));
//                }
//
//            }
//            for (int i = 0; i < AErrors.size(); i++) {
//                for (int j = 0; j < BErrors.size(); j++) {
//                    if (AErrors.get(i) == BErrors.get(j)) {
//                        AErrors.remove(i);
//                        BErrors.remove(j);
//                    }
//                }
//            }
//            if (AErrors.size() <= (int) b.length() * 0.75 || BErrors.size() <= (int) a.length() * 0.75) {
//                return true;
//            }
//        }
//        return false;
//    }

}
