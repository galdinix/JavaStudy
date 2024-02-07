package org.example;

import static org.junit.jupiter.api.Assertions.*;

class CalcularComplexosTest {
    CalcularComplexos cal = new CalcularComplexos();

    @org.junit.jupiter.api.Test
    void somar() {

        assertEquals(10, cal.somar(5,5));
    }

    @org.junit.jupiter.api.Test
    void somarImaginario() {
        assertEquals(10, cal.somarImaginario(5,5));
    }

    @org.junit.jupiter.api.Test
    void sub() {
        assertEquals(0, cal.sub(5,5));
    }

    @org.junit.jupiter.api.Test
    void subImaginario() {
        assertEquals(0, cal.subImaginario(5,5));
    }

    @org.junit.jupiter.api.Test
    void modulo() {
        assertEquals(2.8284271247461903, cal.modulo(2,2));
    }
}