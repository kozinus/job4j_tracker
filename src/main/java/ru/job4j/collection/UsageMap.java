package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("kkozin2403@gmail.com", "Kozin Kirill Yurievich");
        map.put("kozinus@yahoo.com", "Kozin Kirill Yurievich");
        map.put("kozinyu@gmail.com", "Kozin Yuriy Yurievich");
        map.put("kozinus@yahoo.com", "Kozin Kirill Yurievich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
