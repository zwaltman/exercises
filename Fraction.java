/**
* Class for Fraction objects
* (1/3, 2/5, -1/2, etc.)
*/

/**
* This was just a simple exercise with constructing a class in Java so that 
* I could learn some of how it differs from constructing a class in Python, 
* which is the language I have more experience with. Nothing special.
*/

class Fraction extends Number implements Comparable<Fraction> {

    private Integer numerator;
    private Integer denominator;

    /** Creates new instance of Fraction */
    public Fraction(Integer top, Integer bottom) {
        numerator = top;
        denominator = bottom;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }

    // FUNCTIONS FOR TESTING EQUALITY AND RELATIVE VALUE

    /** Tests equality of two Fractions */
    public boolean equals(Fraction other) {
        Integer num1 = numerator * other.getDenominator();
        Integer num2 = denominator * other.getNumerator();
        if (num1 == num2) {
            return true;
        } else {
            return false;
        }
    }

    /** Compares value of Fractions (less than, greater than, etc.).
    * Returns signed int.
    */
    public int compareTo(Fraction other) {
        Integer num1 = numerator * other.getDenominator();
        Integer num2 = denominator * other.getNumerator();
        return num1 - num2;
    }

    // CONVERSION TO/FROM OTHER NUMBER TYPES
    // MOSTLY METHODS FOR Comparable INTERFACE

    /** Converts Integer to Fraction */
    public Fraction(Integer number) {
        numerator = number;
        denominator = 1;
    }

    /** Convert to double */
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    /** Convert to float */
    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    /** Convert to int */
    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    /** Convert to long */
    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    // BASIC ARITHMETIC 

    /** Adds two Fractions */
    public Fraction add(Fraction other) {
        Integer newNum, newDen, common;

        newNum = numerator*other.getDenominator() + 
            denominator*other.getNumerator();
        newDen = denominator*other.getDenominator();
        common = gcd(newNum, newDen);

        return new Fraction(newNum/common, newDen/common);
    }

    /** Multiplies two Fractions */
    public Fraction multiply(Fraction other) {
        Integer newNum, newDen, common;

        newNum = numerator*other.getNumerator();
        newDen = denominator*other.getDenominator();
        common = gcd(newNum, newDen);

        return new Fraction(newNum/common, newDen/common);
    }

    /** Greatest Common Denominator, used for simplifying Fractions */
    private static Integer gcd(Integer a, Integer b) {
        Integer olda, oldb;

        while (a%b != 0) {
            olda = a;
            oldb = b;
            
            a = oldb;
            b = olda%oldb;
        }
        
        return b;
    }
}