package com.suku.string;

import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {

    public String mostCommonWord(String s, String[] banned) {
        Set bannedSet = new HashSet(Arrays.asList(banned));
        s = s.toLowerCase();

        Map.Entry entry = new AbstractMap.SimpleEntry("", 0);

        entry = Arrays.stream(s.toLowerCase().split("[ !?',;.]+")).filter(e->!bannedSet.contains(e.toLowerCase())).collect(Collectors.groupingBy(w->w, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        return entry.getKey().toString();
    }
}
