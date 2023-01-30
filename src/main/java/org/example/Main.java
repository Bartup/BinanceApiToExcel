package org.example;

import org.example.util.ExcelHandler;
import org.example.util.Kline;
import org.example.util.UrlHandler;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Instant start = Instant.now();
        ArrayList<String> pairs = UrlHandler.getAllWantedPairs();
        ArrayList<Kline> klines = UrlHandler.getAllKlines(pairs);
        Instant end = Instant.now();
        System.out.println("Time taken: "+ Duration.between(start, end).toMillis() +" milliseconds");


        Collections.sort(klines, new Comparator<Kline>() {
            @Override
            public int compare(Kline o1, Kline o2) {
                if (o1.growth > o2.growth)
                    return -1;
                else if (o1.growth < o2.growth)
                    return 1;
                else
                    return 0;
            }
        });

        ExcelHandler.exportToExcel(klines);
    }
}
