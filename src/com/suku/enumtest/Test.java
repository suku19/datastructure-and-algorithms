package com.suku.enumtest;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
       Optional<String> val =  CountryCodeEnum.fromString("en");
        System.out.println(val.get());
    }
}
