package com.galaxyt.copricorn.jdk8.method;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class MethodTest2 {


    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1,5, 6, 7, 2, 4,  8, 9);

        IntSummaryStatistics i = list.stream().mapToInt(x -> x).summaryStatistics();




    }



}
