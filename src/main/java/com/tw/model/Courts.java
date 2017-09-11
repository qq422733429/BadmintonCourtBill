package com.tw.model;

import java.util.HashMap;

public class Courts {
    //所有场地类的集合，用map进行保存，key：场地id，value：单个场地类
    private HashMap<String, Court> courts;

    public Courts(int courtsNum) {
        this.courts = new HashMap<>();
        for (int i = 0; i < courtsNum ; i++) {
            courts.put(String.valueOf((char) ('A' + i)), new Court(String.valueOf((char) ('A' + i))));
        }
    }

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

    public Court findCourtById(String index) {
        return courts.get(index);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("收入汇总\n---\n");
        double totalPrice = 0;
        for (Court court : courts.values()) {
            sb.append(court);
            totalPrice += court.getPrice();
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("---\n总计：");
        String priceStr = String.valueOf(totalPrice);
        String temp[] = priceStr.split(".");
        if(temp[1].equals("0")){
            sb.append(temp[0]);
        }else {
            sb.append(totalPrice);
        }
        sb.append("元");
        return sb.toString();
    }
}
