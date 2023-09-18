/**
 * takes user inputs through system arguments and sends them to BFCalculator
 * 
 * @author Noah Mendola
 * 
 * @version 1.0 9/17/2023
 */
import java.io.PrintWriter;

public class QuickCalculator {

    public static void main(String[] args) throws Exception{
        BFCalculator myBFCalculator = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);
        BigFraction result = myBFCalculator.evaluateQuick(args);
        pen.println("Result fraction: " + result);
    } 
}
