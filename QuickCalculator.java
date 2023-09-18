import java.io.PrintWriter;

public class QuickCalculator {

    public static void main(String[] args) throws Exception{
        BFCalculator myBFCalculator = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);
        BigFraction result = myBFCalculator.evaluateQuick(args);
        pen.println("Result fraction: " + result);
    } 
}
