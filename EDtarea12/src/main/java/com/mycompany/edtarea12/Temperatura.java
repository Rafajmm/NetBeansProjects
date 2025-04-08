package com.mycompany.edtarea12;

public class Temperatura {
    public double fahrenheitCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public double celsiusFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}

