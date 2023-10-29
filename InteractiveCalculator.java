
/**
 * takes user inputs through continuous scanner inputs and sends them to BFCalculator
 * 
 * @author Noah Mendola
 * 
 * @version 1.0 9/17/2023
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class InteractiveCalculator {

    private static char[] storedValues = new char[26];

    public static void storeValue(String var, BigFraction value) {
        int index = (int) var.toLowerCase().charAt(0) - 97;
        storedValues[index] = value.toString().charAt(0);
    }

    public BigFraction evaluate(String exp) {

        if (exp.length() == 1) {
            // Check if single letter variable
            int index = (int) exp.toLowerCase().charAt(0) - 97;
            return new BigFraction(String.valueOf(storedValues[index]));
        } else {
            BFCalculator calculator = new BFCalculator();
            return calculator.evaluate(exp);
        }

    }

    public static void main(String[] args) throws Exception {

        BFCalculator myBFCalculator = new BFCalculator();
        Scanner myScanner = new Scanner(System.in);
        PrintWriter pen = new PrintWriter(System.out, true);
        String userInput = "";
        BigFraction result = new BigFraction(0, 1);
        while (!userInput.equals("exit")) {
            pen.println("Enter Expression or write 'exit'");
            userInput = myScanner.nextLine();

            if (!userInput.equals("exit")) {
                result = myBFCalculator.evaluate(userInput);
                pen.println("Result fraction: " + result);
            }

            if (userInput.startsWith("store ")) {
                // Extract variable name
                String var = userInput.substring(6);
                storeValue(var, result);
            }
        }
    }
}
