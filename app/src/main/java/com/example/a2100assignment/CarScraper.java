//package com.example.a2100assignment;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.FileWriter;
//import java.net.InetSocketAddress;
//import java.net.Proxy;
//import java.net.URL;
//import java.util.ArrayList;
//
//public class CarScraper {
//    static ArrayList<String> htmls = new ArrayList<>();
//    static ArrayList<Car> cars = new ArrayList<>();
//
//
//
//
//   static void getHTMLs(){
//       htmls.add("https://www.gta5rides.com/vehicles/sports.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/compacts.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/coupes.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/motorcycles.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/muscle.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/off-road.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/sedans.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/sports.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/sports-classics.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/super.cfm");
//       htmls.add("https://www.gta5rides.com/vehicles/vans.cfm");
//    }
//
//    static ArrayList<Car> getCars(){
//       getHTMLs();
//       int total = 0;
//        for (String html:htmls
//             ) {
//            String type1 = html.substring(35, html.length());
//            String type = type1.substring(0, type1.length()-4);
//            int carNumber = 0;
//            try{Document doc = Jsoup.connect(html).timeout(50000).get();
//                Elements e = doc.select("div.card");
//                int size = e.size();
//                carNumber = size;
//                for (Element ele : e) {
//                    if (ele==e.get(0)) continue;
//                    String brand =ele.select("h4")
//                            .text();
//                    String spr = ele.select("strong")
//                            .text();
//                    String[] a = spr.split("\\s+");
//                    String[] b = brand.split("\\s+");
//                    String speed = a[0];
//                    String manufacturer;
//                    String model ;
//                    String price;
//                    try{
//                        price = a[2].substring(1).replace(",","");}
//                    catch (ArrayIndexOutOfBoundsException ex){
//                        price = "0";
//                    }
//                    try {
//                        model = b[1];
//                        manufacturer=b[0];
//                    }catch (ArrayIndexOutOfBoundsException el){
//                        manufacturer = null;
//                        model = b[0];
//                    }
//                    int priceNum;
//                    try {
//                        priceNum =Integer.parseInt(price);
//                    }catch (NumberFormatException n){
//                        priceNum = 0;
//                    }
//
//                    String URL1 = ele.select("img")
//                            .attr("src");
//                    String URL = URL1.replaceAll("\\s+", "%20");
//                    String imgURL = "https://www.gta5rides.com"+URL;
//
//
//                    Car car = new Car(manufacturer, model,Double.parseDouble(speed), priceNum, type, imgURL);
//                    cars.add(car);
//
////                    System.out.println(manufacturer+" " + model + " " +" "+speed + " " + price);
////                    System.out.println(imgURL);
////                    System.out.println(type);
//
//                }
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//            total = total + carNumber;
//        }
//        System.out.println(total);
//        return cars;
//    }
//
//    static void writeToFile(){
//       ArrayList carsToBeWritten = getCars();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try (FileWriter fw = new FileWriter("C:\\COURSES\\COMP2100\\Labs\\Lab3\\comp2100_6442_s2_2020-master\\Lab Trees\\task2\\Resources\\Raw\\GTACars.json") ){
//            gson.toJson(carsToBeWritten, fw);
//            System.out.println("Scrape complete");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
////    public static void main(String[] args) {
////        writeToFile();
////
////}
//}
