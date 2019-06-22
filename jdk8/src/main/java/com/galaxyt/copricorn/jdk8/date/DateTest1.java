package com.galaxyt.copricorn.jdk8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTest1 {


    public static void main(String[] args) {


        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);


        Duration d = Duration.ofDays(12);

        System.out.println(d);


    }



}
