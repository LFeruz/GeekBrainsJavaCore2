package ru.geekbrains.lesson3.homework1;

import java.util.HashMap;

public class UniqueHashMap extends HashMap {

    public void putUniq(String key) {
        Integer val = 0;
        if (this.containsKey(key)) {
            val = Integer.parseInt(this.get(key).toString());
        }
        this.put(key,new Integer(val.intValue()+1));
    }
}
