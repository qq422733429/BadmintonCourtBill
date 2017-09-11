package com.tw.model;

import java.util.HashMap;

public class Courts {
    //所有场地类的集合，用map进行保存，key：场地id，value：单个场地类
    private HashMap<String, Court> courts;

    public HashMap<String, Court> getCourts() {
        return courts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courts courts1 = (Courts) o;

        return courts.equals(courts1.courts);
    }

    @Override
    public int hashCode() {
        return courts.hashCode();
    }
}
