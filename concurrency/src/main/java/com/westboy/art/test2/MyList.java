package com.westboy.art.test2;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("westboy");
    }

    public static int size() {
        return list.size();
    }

}
