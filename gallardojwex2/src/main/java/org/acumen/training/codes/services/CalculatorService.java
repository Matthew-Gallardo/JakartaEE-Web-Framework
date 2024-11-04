package org.acumen.training.codes.services;

public class CalculatorService {
    
    private double operand1;
    private double operand2;
    private String operator;
    private double result;

    
    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    
    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    
    public void calculate() {
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
