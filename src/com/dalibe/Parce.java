package com.dalibe;

import java.util.ArrayList;

// "Parce" is NOT a misspelling

public class Parce {
    public static int[] parceInt(String src){
        ArrayList<Integer> list = new ArrayList<>();
        int srcLen = src.length();
        StringBuilder sb = new StringBuilder();
        boolean startedBuilding = false;
        for (var i = 0; i < srcLen; i++){
            if (Character.isDigit(src.charAt(i))){
                sb.append(src.charAt(i));
                startedBuilding = true;
            }
            else if (startedBuilding) {
                list.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                startedBuilding = false;
            }
        }
        if (startedBuilding)list.add(Integer.parseInt(sb.toString()));
        int listSize = list.size();
        int[] dest = new int[listSize];
        for (var i = 0; i < listSize; i++) dest[i] = list.get(i);
        return dest;
    }

    public static float[] parceFloat(String src){
        ArrayList<Float> list = new ArrayList<>();
        int srcLen = src.length();
        StringBuilder sb = new StringBuilder();
        boolean startedBuilding = false;
        for (var i = 0; i < srcLen; i++){
            if (sb.isEmpty() && src.charAt(i) == '.') continue;
            if (Character.isDigit(src.charAt(i)) || src.charAt(i) == '.'){
                sb.append(src.charAt(i));
                startedBuilding = true;
            }
            else if (startedBuilding) {
                list.add(Float.parseFloat(sb.toString()));
                sb = new StringBuilder();
                startedBuilding = false;
            }
        }
        if (startedBuilding)list.add(Float.parseFloat(sb.toString()));
        int listSize = list.size();
        float[] dest = new float[listSize];
        for (var i = 0; i < listSize; i++) dest[i] = list.get(i);
        return dest;
    }

    public static double[] parceDouble(String src){
        ArrayList<Double> list = new ArrayList<>();
        int srcLen = src.length();
        StringBuilder sb = new StringBuilder();
        boolean startedBuilding = false;
        for (var i = 0; i < srcLen; i++){
            if (sb.isEmpty() && src.charAt(i) == '.') continue;
            if (Character.isDigit(src.charAt(i)) || src.charAt(i) == '.'){
                sb.append(src.charAt(i));
                startedBuilding = true;
            }
            else if (startedBuilding) {
                list.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
                startedBuilding = false;
            }
        }
        if (startedBuilding)list.add(Double.parseDouble(sb.toString()));
        int listSize = list.size();
        double[] dest = new double[listSize];
        for (var i = 0; i < listSize; i++) dest[i] = list.get(i);
        return dest;
    }

    public static String[] parceWords(String src){
        while (src.contains("  ")) src = src.replaceAll("  ", " ");
        return src.split(" ");
    }
}
