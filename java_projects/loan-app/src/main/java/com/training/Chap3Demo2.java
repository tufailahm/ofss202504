package com.training;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Chap3Demo2 {

    public static void main(String[] args) {
        String name1 = "neha";

       name1 =  name1.concat(" OFSS");

        System.out.println(name1);

        String password =  "neha123";
        String password2 = new String("jajassa");
        String hashPassword = password2.intern();
        String hashPassword2 = hashPassword.intern();

        System.out.println(hashPassword2==hashPassword);


        String userPassword ="19181";
        String tokenPassword = userPassword.intern();


    StringBuilder sb1 = new StringBuilder("Data");


        String textBlock1 = """
  Tea "English Breakfast"
    price 1.99
    quantity 2
  """;

        System.out.println(textBlock1.indexOf("price"));
        System.out.println(textBlock1.substring(26,30));


        //Wrapper classes
        String marks = "90";
        int temp = Integer.parseInt(marks);

        Integer num1 =90;
        int num2 = num1;        //auto boxing


        System.out.println(temp+5);

        BigDecimal price = BigDecimal.valueOf(12.99);
        BigDecimal taxRate = BigDecimal.valueOf(0.2);
        BigDecimal tax = price.multiply(taxRate);                // tax is 2.598
        price = price.add(tax).setScale(2, RoundingMode.HALF_UP);

        System.out.println(price);



        LocalDate today = LocalDate.now();
        LocalTime thisTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate someDay = LocalDate.of(2019,Month.APRIL,1);
        LocalTime someTime = LocalTime.of(10,6);
        LocalDateTime otherDateTime = LocalDateTime.of(2019, Month.MARCH,31,23,59);
        LocalDateTime someDateTime = someDay.atTime(someTime);
        LocalDate whatWasTheDate = someDateTime.toLocalDate();

        ZoneId london = ZoneId.of("Europe/Paris");
        ZoneId la  = ZoneId.of("America/Los_Angeles");
        LocalDateTime someTime2 = LocalDateTime.of(2019,Month.APRIL,1,07,14);
        ZonedDateTime londonTime = ZonedDateTime.of(someTime2, london);
        ZonedDateTime laTime = londonTime.withZoneSameInstant(la);

        System.out.println(londonTime);
        System.out.println(laTime);

        System.out.println("hello");

        Locale locale = Locale.of("en","GB");
        Locale localeFrench = Locale.of("fr","FR");

        ResourceBundle bundle =
                ResourceBundle.getBundle("messages",localeFrench);
        String helloPattern = bundle.getString("hello");
        String otherMessage = bundle.getString("other");
        System.out.println(helloPattern);
        System.out.println(otherMessage);
    }
}
