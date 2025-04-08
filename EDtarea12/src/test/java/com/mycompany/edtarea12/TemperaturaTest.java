package com.mycompany.edtarea12;
import com.mycompany.edtarea12.Temperatura;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperaturaTest {
    
    private final Temperatura conversor = new Temperatura();
    
    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(-20.555, conversor.fahrenheitCelsius(-5), 0.001);
        assertEquals(-17.777, conversor.fahrenheitCelsius(0), 0.001);
        assertEquals(-9.444, conversor.fahrenheitCelsius(15), 0.001);
        assertEquals(0, conversor.fahrenheitCelsius(32), 0.001);
    }
    
    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(23, conversor.celsiusFahrenheit(-5), 0.001);
        assertEquals(32, conversor.celsiusFahrenheit(0), 0.001);
        assertEquals(59, conversor.celsiusFahrenheit(15), 0.001);
        assertEquals(89.6, conversor.celsiusFahrenheit(32), 0.001);
    }
}