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
   * Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   */

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

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
    String[] parts = str.split("/");
    if (parts.length == 2) {
        int numInt = Integer.parseInt(parts[0]);
        int denomInt = Integer.parseInt(parts[1]);
        this.num = BigInteger.valueOf(numInt);
        this.denom = BigInteger.valueOf(denomInt);
    }
  } // Fraction



  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
    public Fraction reduce(Fraction reduceMe) {
        BigInteger commonFactor = reduceMe.num.gcd(reduceMe.denom);
        BigInteger reduceDenom = reduceMe.denom.divide(commonFactor);
        BigInteger reduceNum = reduceMe.num.divide(commonFactor);
        Fraction result = new Fraction (reduceNum, reduceDenom);
    return result;
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
    Fraction result = new Fraction (resultNumerator, resultDenominator);
    return reduce(result);
  }// add(Fraction)
  
  public Fraction subtract(Fraction minusMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(minusMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(minusMe.denom)).subtract(minusMe.num.multiply(this.denom));

    // Return the computed value
    Fraction result = new Fraction (resultNumerator, resultDenominator);
    return reduce(result);
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
      Fraction result = new Fraction (resultNumerator, resultDenominator);
      return reduce(result);
  }
  /**
   * Multiplie two fractions.
   * @param multiplyMeOne
   * @param multiplyMeTwo
   * @return
   */
  public Fraction divide(Fraction FractionTwo){
      BigInteger resultNumerator;
      BigInteger resultDenominator;

      // The numerator of the result is the
      // product of FractionOne and FractionTwo's numerators.
      resultNumerator = this.num.multiply(FractionTwo.denom);
      // The denominator of the result is the
      // product of fractionOne and FractionTwo's numerators.
      resultDenominator = this.denom.multiply(FractionTwo.num);
      
      Fraction result = new Fraction (resultNumerator, resultDenominator);
      return reduce(result);
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

}

    

  