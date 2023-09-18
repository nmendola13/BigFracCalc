import java.util.Scanner; 
import java.io.PrintWriter;

public class InteractiveCalculator {
    public static void main(String[] args) throws Exception{
        BFCalculator myBFCalculator = new BFCalculator();
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        PrintWriter pen = new PrintWriter(System.out, true);
        String userInput = "";
        while (!userInput.equals("exit")){
            pen.println("Enter Expression or write 'exit'");
            userInput = myScanner.nextLine();  // Read user input
            if (!userInput.equals("exit")){
            Fraction result = myBFCalculator.evaluate(userInput);
            pen.println("Result fraction: " + result);
            }
        }
    } 
}
