/**
 * A simple implementation of Fractions.
 * 
 * @author Livia Stein Freitas and Noah Mendola
 * @version 0.9 of September 2023
 */

import java.math.BigInteger;
import java.io.PrintWriter;

public class Counter{

  BigInteger counter_value;

public Counter(){
this.counter_value = BigInteger.valueOf(0);
}

public Counter(int starting_value){
  this.counter_value = BigInteger.valueOf(starting_value);
  }

public void increment(){
  this.counter_value = counter_value.add(BigInteger.valueOf(1));
} 

public BigInteger get(){
  return this.counter_value;
}

public String toString (){
  return "[" + this.counter_value + "]";
}

public void reset(){
  this.counter_value = BigInteger.valueOf(0);
}

public static void main(String[] args) throws Exception{
Counter c1 = new Counter();
Counter c2 = new Counter();
Counter c3 = new Counter(4);
PrintWriter pen = new PrintWriter(System.out, true);
c1.increment();
c1.increment();
c2.increment();
pen.println("c1: " + c1);
pen.println("c2: " + c2);
pen.println("c3: " + c3);
c3.reset();
pen.println("c3: " + c3);
}
}
