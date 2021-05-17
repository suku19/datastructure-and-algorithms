package com.suku.enumtest;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CountryCodeEnum {

    en("England","United Kingdom"),
    ni("Northern Ireland","United Kingdom"),
    sc("Scotland","United Kingdom"),
    wl("Wales","United Kingdom"),
    at("Austria","Europe"),
    be("Belgium","Europe"),
    bg("Bulgaria","Europe"),
    hr("Croatia","Europe"),
    cy("Cyprus","Europe"),
    cz("Czech Republic","Europe"),
    dk("Denmark","Europe"),
    ee("Estonia","Europe"),
    fi("Finland","Europe"),
    fr("France","Europe"),
    de("Germany","Europe"),
    gr("Greece","Europe"),
    hu("Hungary","Europe"),
    ie("Ireland","Europe"),
    it("Italy","Europe"),
    lv("Latvia","Europe"),
    lt("Lithuania","Europe"),
    lu("Luxembourg","Europe"),
    mt("Malta","Europe"),
    nl("Netherlands","Europe"),
    pl("Poland","Europe"),
    pt("Portugal","Europe"),
    ro("Romania","Europe"),
    sk("Slovakia","Europe"),
    si("Slovenia","Europe"),
    es("Spain","Europe"),
    se("Sweden","Europe");

    private String countryName;
    private String region;

    CountryCodeEnum(final String name) {
        this.countryName = name;
    }

    CountryCodeEnum(final String name, final String region) {
        this(name);
        this.region = region;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getRegion() {
        return this.region;
    }

    public static String getNameByCountryCode(String code) {
        for (CountryCodeEnum es : CountryCodeEnum.values()) {
            if (es.name().equals(code)) {
                return es.getCountryName();
            }
        }
        throw new IllegalArgumentException();
    }

    private static final Map<String, CountryCodeEnum> stringToEnum =
            Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<String> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol).getCountryName());
    }
}
