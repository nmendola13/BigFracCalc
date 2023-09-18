import java.math.BigInteger;

public class BFCalculator {

    private Fraction currentValue;

    public Fraction evaluate(String exp) {
        String[] expressions = exp.split(" ");
        this.currentValue = new Fraction(expressions[0]);
        for (int i = 1; i < expressions.length; i++) {
            String expression = expressions[i];
            if (expression.equals("+") || expression.equals("-") || expression.equals("*") || expression.equals("/")) {
                if (i + 1 < expressions.length) {
                    this.currentValue = performOperation(this.currentValue, expression, expressions[i + 1]);
                } else {
                    throw new IllegalArgumentException("Invalid expression format");
                }
            }
        }
        return this.currentValue;
    }

    private Fraction performOperation(Fraction currentValue, String operator, String operand) {
        Fraction operandFraction = new Fraction(operand);
        if (operator.equals("+")) {
            return currentValue.add(operandFraction);
        } else if (operator.equals("-")) {
            return currentValue.subtract(operandFraction);
        } else if (operator.equals("*")) {
            return currentValue.multiply(operandFraction);
        } else if (operator.equals("/")) {
            return currentValue.divide(operandFraction);
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
