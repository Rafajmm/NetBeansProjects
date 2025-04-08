package com.mycompany.calculadoratests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalduladora{
    
    private final Calcu calculadora = new Calcu();
    
    @Test
    public void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
        assertEquals(-1, calculadora.sumar(-4, 3));
        assertEquals(0, calculadora.sumar(0, 0));
    }
    
    @Test
    public void testRestar() {
        assertEquals(1, calculadora.restar(4, 3));
        assertEquals(-7, calculadora.restar(-4, 3));
        assertEquals(0, calculadora.restar(5, 5));
    }
    
    @Test
    public void testMultiplicar() {
        assertEquals(12, calculadora.multiplicar(3, 4));
        assertEquals(-12, calculadora.multiplicar(3, -4));
        assertEquals(0, calculadora.multiplicar(0, 5));
    }
    
    @Test
    public void testDividir() {
        assertEquals(2, calculadora.dividir(6, 3));
        assertEquals(-2, calculadora.dividir(-6, 3));
        assertEquals(0, calculadora.dividir(0, 5));
    }
    
}