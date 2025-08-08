package com.wipro.annonymous.test;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.function.Consumer;

public class Consumer1 {
    public static void main(String[] args) {
        Consumer<ZoneId> zTime=zone -> {
            ZonedDateTime a=ZonedDateTime.now(zone);
            System.out.println(a.toLocalTime());
        };
        zTime.accept(ZoneId.of("Europe/London"));
    }
}