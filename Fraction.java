/*Class BigFraction:
    Initialize numerator and denominator as integers

    Constructor BigFraction(numerator, denominator):
        Set this.numerator = numerator
        Set this.denominator = denominator
        Reduce the fraction to its simplest form

    Method add(otherFraction):
        Calculate the common denominator
        Add numerators with common denominator
        Create and return a new BigFraction with the result

    Method subtract(otherFraction):
        Calculate the common denominator
        Subtract numerators with common denominator
        Create and return a new BigFraction with the result

    Method multiply(otherFraction):
        Multiply numerators and denominators
        Create and return a new BigFraction with the result

    Method divide(otherFraction):
        Invert the otherFraction (swap numerator and denominator)
        Multiply by the inverted otherFraction
        Create and return a new BigFraction with the result

    Method reduce():
        Find the greatest common divisor (GCD) of numerator and denominator
        Divide both numerator and denominator by the GCD

    Method toString():
        Return the fraction as a string in the format "numerator/denominator"

    Static Method gcd(a, b):
        Calculate the greatest common divisor using Euclidean algorithm
        Return the GCD
        */
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Livia Stein Freitas and Noah Mendola
 * @version 1.2 of August 2023
 */
public class Fraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   *  
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public Fraction(String str) {
    String num1 = str.substring (0, 1);
    int numInt = Integer.parseInt(num1);
    this.num = BigInteger.valueOf(numInt);
    String num2 = str.substring (2, 3);
    int numInt2 = Integer.parseInt(num2);
    this.denom = BigInteger.valueOf(numInt2);
  } // Fraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public void gcd() {
        int bigNum;
        int smallNum;
        if (this.num.compareTo(this.denom) >= 0) {
            bigNum = this.num.intValue();
            smallNum = this.denom.intValue();
        }
        else {
            bigNum = this.denom.intValue();
            smallNum = this.num.intValue();
        }
        int remainder = 1;  
        int gcf = remainder;
        while (remainder != 0) {
            gcf = remainder;
            remainder = bigNum % smallNum;
        }
        BigInteger commonFactor = BigInteger.valueOf(gcf);
        this.denom.divide(commonFactor);
        this.num.divide(commonFactor);
    }
    
  public Fraction add(Fraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Multiplie two fractions.
   * @param multiplyMeOne
   * @param multiplyMeTwo
   * @return
   */
  public Fraction multiply(Fraction FractionTwo){
  BigInteger resultNumerator;
  BigInteger resultDenominator;

  // The numerator of the result is the
  // product of FractionOne and FractionTwo's numerators.
  resultNumerator = this.num.multiply(FractionTwo.num);
  // The denominator of the result is the
  // product of fractionOne and FractionTwo's numerators.
  resultDenominator = this.denom.multiply(FractionTwo.denom);

  return new Fraction(resultNumerator, resultDenominator);


}
  public Fraction fractional(){
  BigInteger resultNumerator;
  BigInteger resultDenominator;

  resultNumerator = this.num.mod (this.denom);
  resultDenominator = this.denom;
  return new Fraction(resultNumerator, resultDenominator);
  }

  

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  public static void main(String[] args) throws Exception{
  }
}

    

  