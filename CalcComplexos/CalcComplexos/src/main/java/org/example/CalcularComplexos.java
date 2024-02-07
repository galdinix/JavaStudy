package org.example;

public class CalcularComplexos {

    public static double somar(double x, double y) {
        return x+y;
    }

    public static double somarImaginario(double firstImaginario, double secondImagionario) {
        return firstImaginario + secondImagionario;
    }

    public static double sub(double x, double y) {
        return x-y;
    }

    public static double subImaginario(double firstImaginario, double secondImagionario) {
        return  firstImaginario - secondImagionario;
    }

    public static double modulo(double firstnumReal, double firstNumImaginario) {
        double somaNumPow = (Math.pow(firstnumReal, 2) + Math.pow(firstNumImaginario, 2));
        double modulo = Math.sqrt(somaNumPow);
        return modulo;
    }
}
