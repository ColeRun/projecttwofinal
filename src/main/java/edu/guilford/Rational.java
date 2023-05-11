package edu.guilford;
import java.util.Random;

public class Rational {
    private int numerator;
    private int denominator;
// random number generator
    Random rand = new Random();
    //constuctor that sets numerator to 0 and denominator to 1
    public Rational() {
        //generate random values for numerator and denominator from -100 to 100
        numerator = rand.nextInt(200) - 100;
        denominator = rand.nextInt(200) - 100;
        //print a warning out if the denominator is 0
        if (denominator == 0) {
            System.out.println("Warning: Program may crash, denominator is 0, reselecting denominator");
            denominator = rand.nextInt(200) - 100;
        }
    }
    //constructor that takes two ints and sets numerator and denominator
    public Rational(int n, int d) {
        numerator = n;
        denominator = d;
        //print a warning out if the denominator is 0
        if (denominator == 0) {
            System.out.println("Warning: denominator is 0 ");
        }
        reduce();
    }
    //method that reverses the numerator and denominator
    public void invertt() {
        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }
    //method called negate that changes the sign of the rational
    public void negate() {
        numerator = -numerator;
    }
//method to turn a rational into a double
    public double toDouble() {
        return (double) numerator / (double) denominator;
    }
//method that takes a Rational object and adds it to the current Rational object, and reduces it
    public void add(Rational r) {
        numerator = numerator * r.denominator + r.numerator * denominator;
        denominator = denominator * r.denominator;
        reduce();
    }


    
    
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }
    private int gcd(int numerator2, int denominator2) {
        if (denominator2 == 0) {
            return numerator2;
        }
        return gcd(denominator2, numerator2 % denominator2);
        
    }
    //add a toString method that displays a Rational object
    public String toString() {
        return numerator + "/" + denominator;
    }


    
}
