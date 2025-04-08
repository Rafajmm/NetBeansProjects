package com.mycompany.edtarea12;

import java.util.LinkedHashMap;
import java.util.Map;

public class nRomanos {
    private static final Map<String, Integer> mapa = new LinkedHashMap<>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    private static final int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] letras = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int lromanaNumero(String lromana) {
        int resul = 0;
        String mayus = lromana.toUpperCase();
        
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            while (mayus.startsWith(entry.getKey())) {
                resul += entry.getValue();
                mayus = mayus.substring(entry.getKey().length());
            }
        }                
        return resul;
    }

    public String numeroLromana(int decimal) {       
        StringBuilder lromana = new StringBuilder();
        int mayus = decimal;
        
        for (int i = 0; i < nums.length; i++) {
            while (mayus >= nums[i]) {
                lromana.append(letras[i]);
                mayus -= nums[i];
            }
        }        
        return lromana.toString();
    }
}

