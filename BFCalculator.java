/**
 * Evaluates user inputs and calls BigFraction Operators
 * 
 * @author Noah Mendola
 * 
 * @version 1.0 9/17/2023
 */

public class BFCalculator {

    private BigFraction currentValue;

    public BigFraction evaluate(String exp) {
        String[] expressions = exp.split(" ");
        this.currentValue = new BigFraction(expressions[0]);
        for (int i = 1; i < expressions.length; i++) {
            String expression = expressions[i];
            if (expression.equals("+") || expression.equals("-") || expression.equals("*") || expression.equals("/")) {
                if (i + 1 < expressions.length) {
                    this.currentValue = performOperation(this.currentValue, expression, expressions[i + 1]);
                } else {
                    throw new IllegalArgumentException("Invalid expression");
                }
            }
        }
        return this.currentValue;
    }

    public BigFraction evaluateQuick(String[] expressions) {
        this.currentValue = new BigFraction(expressions[0]);
        for (int i = 1; i < expressions.length; i++) {
            String expression = expressions[i];
            if (expression.equals("+") || expression.equals("-") || expression.equals("*") || expression.equals("/")) {
                if (i + 1 < expressions.length) {
                    this.currentValue = performOperation(this.currentValue, expression, expressions[i + 1]);
                } else {
                    throw new IllegalArgumentException("Invalid expression");
                }
            }
        }
        return this.currentValue;
    }

    private BigFraction performOperation(BigFraction currentValue, String operator, String operand) {
        BigFraction operandBigFraction = new BigFraction(operand);
        if (operator.equals("+")) {
            return currentValue.add(operandBigFraction);
        } else if (operator.equals("-")) {
            return currentValue.subtract(operandBigFraction);
        } else if (operator.equals("*")) {
            return currentValue.multiply(operandBigFraction);
        } else if (operator.equals("/")) {
            return currentValue.divide(operandBigFraction);
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
