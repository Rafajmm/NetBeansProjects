package com.mycompany.edtarea12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class nRomanosTest {
    
    private final nRomanos conversor = new nRomanos();
    
    @Test
    public void testRomanToDecimal() {
        assertEquals(21, conversor.lromanaNumero("XXI"));
        assertEquals(2016, conversor.lromanaNumero("MMXVI"));
    }
    
    @Test
    public void testDecimalToRoman() {
        assertEquals("XXI", conversor.numeroLromana(21));
        assertEquals("MMXVI", conversor.numeroLromana(2016));
    }
    
}
