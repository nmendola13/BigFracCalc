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
    public static void main(String[] args) throws Exception{
        BFCalculator myBFCalculator = new BFCalculator();
        Scanner myScanner = new Scanner(System.in); 
        PrintWriter pen = new PrintWriter(System.out, true);
        String userInput = "";
        while (!userInput.equals("exit")){
            pen.println("Enter Expression or write 'exit'");
            userInput = myScanner.nextLine();  // Read user input
            if (!userInput.equals("exit")){
            BigFraction result = myBFCalculator.evaluate(userInput);
            pen.println("Result fraction: " + result);
            }
        }
    } 
}
