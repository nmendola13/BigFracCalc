import java.math.BigInteger;

/**
 * A simple implementation of BigFractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Livia Stein Freitas and Noah Mendola
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * Denominators are always positive. Therefore, negative BigFractions are represented 
   * with a negative numerator. Similarly, if a BigFraction has a negative numerator, it 
   * is negative.
   */

  /** The numerator of the BigFraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the BigFraction. Must be non-negative. */
  BigInteger denom;

  /**
   * Build a new BigFraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new BigFraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // BigFraction(int, int)

  /**
   * Build a new BigFraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public BigFraction(String str) {
    String[] parts = str.split("/");
    if (parts.length == 2) {
        int numInt = Integer.parseInt(parts[0]);
        int denomInt = Integer.parseInt(parts[1]);
        this.num = BigInteger.valueOf(numInt);
        this.denom = BigInteger.valueOf(denomInt);
    }
  } // BigFraction



  /**
   * Express this BigFraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the BigFraction `addMe` to this BigFraction.
   */
    public BigFraction reduce(BigFraction reduceMe) {
        BigInteger commonFactor = reduceMe.num.gcd(reduceMe.denom);
        BigInteger reduceDenom = reduceMe.denom.divide(commonFactor);
        BigInteger reduceNum = reduceMe.num.divide(commonFactor);
        BigFraction result = new BigFraction (reduceNum, reduceDenom);
    return result;
    }
    
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    BigFraction result = new BigFraction (resultNumerator, resultDenominator);
    return reduce(result);
  }// add(BigFraction)
  
  public BigFraction subtract(BigFraction minusMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(minusMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(minusMe.denom)).subtract(minusMe.num.multiply(this.denom));

    // Return the computed value
    BigFraction result = new BigFraction (resultNumerator, resultDenominator);
    return reduce(result);
  }// add(BigFraction)
  
  /**
   * Multiplie two BigFractions.
   * @param multiplyMeOne
   * @param multiplyMeTwo
   * @return
   */
  public BigFraction multiply(BigFraction BigFractionTwo){
      BigInteger resultNumerator;
      BigInteger resultDenominator;

      // The numerator of the result is the
      // product of BigFractionOne and BigFractionTwo's numerators.
      resultNumerator = this.num.multiply(BigFractionTwo.num);
      // The denominator of the result is the
      // product of BigFractionOne and BigFractionTwo's numerators.
      resultDenominator = this.denom.multiply(BigFractionTwo.denom);
      BigFraction result = new BigFraction (resultNumerator, resultDenominator);
      return reduce(result);
  }
  /**
   * Multiplie two BigFractions.
   * @param multiplyMeOne
   * @param multiplyMeTwo
   * @return
   */
  public BigFraction divide(BigFraction BigFractionTwo){
      BigInteger resultNumerator;
      BigInteger resultDenominator;

      // The numerator of the result is the
      // product of BigFractionOne and BigFractionTwo's numerators.
      resultNumerator = this.num.multiply(BigFractionTwo.denom);
      // The denominator of the result is the
      // product of BigFractionOne and BigFractionTwo's numerators.
      resultDenominator = this.denom.multiply(BigFractionTwo.num);
      
      BigFraction result = new BigFraction (resultNumerator, resultDenominator);
      return reduce(result);
  }

  public BigFraction BigFractional(){
  BigInteger resultNumerator;
  BigInteger resultDenominator;

  resultNumerator = this.num.mod (this.denom);
  resultDenominator = this.denom;
  return new BigFraction(resultNumerator, resultDenominator);
  }

  

  /**
   * Get the denominator of this BigFraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this BigFraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this BigFraction to a string for ease of printing.
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

    

  