package com.mycompany.edtarea12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DineroTestt {
    
    private final Dinero conversor = new Dinero();
    
    @Test
    public void testDollarToEuro() {
        assertEquals(9.66, conversor.dolarEuro(10.5), 0.01);
    }
    
    @Test
    public void testEuroToDollar() {
        assertEquals(22.065, conversor.euroDolar(20.30), 0.001);
    }
}