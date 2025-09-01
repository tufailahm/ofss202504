package com.training.com.training.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import static java.lang.System.out;
public class Product
{
    private int id;         //instance varib
    private String name="ProductNameNotAvailable1";
    private BigDecimal price;
    private LocalDate bestBefore = LocalDate.now().plusDays(3);
    public static String storeName = "Reliance";       //Class variables
    private final int totalBill;
    Date dob;
    {
        out.println("INITIALZER  BLOCK CALLED");
        this.name = "ProductNameNotAvailable2";
       if(Locale.getDefault().equals(Locale.GERMANY)){
           totalBill = 100000;
       }
       else  if(Locale.getDefault().equals(Locale.US)){
           totalBill = 20000000;
       }
       else {
           totalBill=0;
       }
    }

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        Condition.COLD.setCaution("TOO COLD");
        this.name = Condition.COLD.getCaution();
        this.price = price;

    }

    static
    {
        storeName= "Chroma";
        out.println("STATIC BLOCK CALLED");
    }

    public  Product(){
        out.println("PRODUCT DEF CONS CALLED");
        this.price = BigDecimal.valueOf(-99);
             this.name = "ProductNameNotAvailable3";
    }
    public Product(int id, String name, BigDecimal price, LocalDate bestBefore) {
        this();
        out.println("PRODUCT 4  CONS CALLED");

        this.id = id;
        this.name = name;
        this.price = price;
        this.bestBefore = bestBefore;
    }

    public Product(int id, BigDecimal price) {
        this();
        this.id = id;
        this.price = price;
    }

    public Product(int id, int price) {
        this();

        this.id = id;
        this.price = BigDecimal.valueOf(price);
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getCapitalizedProductName(name);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setPrice(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public void displayProduct(){
        System.out.println("Product Id: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Product Best Before: " + bestBefore);
        System.out.println("Store Name: " + storeName);
        out.println("Product Store Name: " + storeName);
    }

    public static void changeStoreName(String str){
        //access only static variabales
        storeName = str;

    }
    //return updated price //calculateBill(discount)
    public void applyDiscount(BigDecimal discountPercent){

         price = price.subtract(price.multiply(discountPercent.divide(BigDecimal.valueOf(100))));
    }

    public void applyDiscount(){

        price = price.subtract(price.multiply(BigDecimal.valueOf(0.5)));
    }

    public void applyDiscount(double slab,int...rates){

        out.println(slab);
        for(int i:rates){
            out.println(i);
        }
    }

    public String getCapitalizedProductName(String name){
            return name.toUpperCase();
    }
    
    public void addPrice(){
        BigDecimal price = BigDecimal.valueOf(100);

        this.price =  this.price.add(price);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bestBefore=" + bestBefore +
                ", totalBill=" + totalBill +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && totalBill == product.totalBill && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(bestBefore, product.bestBefore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, bestBefore, totalBill, dob);
    }
}
