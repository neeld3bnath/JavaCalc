import java.math.BigInteger;

public class MathList {
    private int option;

    public MathList(int option) {
        this.option = option;
    }

    public MathList(int option, String expression) {
        this.option = option;
        if (option == 1) {
            System.out.println("Your expression: " + expression);
        }
    }

    public String toString() {
        String output = "Your option: " + String.valueOf(option);
        return output;
    }

    /**
     * Calculates the result of a mathematical expression.
     *
     * @param expression the mathematical expression to be evaluated
     * @return the result of the expression as a string
     */
    public String calculateExpression(String expression) {
        String[] parts = expression.split("\\+|\\-|\\*|\\/");
        double num1 = Double.parseDouble(parts[0]);
        double num2 = Double.parseDouble(parts[1]);
        String operation = expression.replaceAll("[0-9]+(\\.[0-9]+)?", "");

                
        if (operation.equals("+")) {
            double sum = num1 + num2;
            if (sum % 1 == 0) {
                return num1 + " + " + num2 + " = " + (int) sum;
            } else {
                return num1 + " + " + num2 + " = " + sum;
            }
        }

        if (operation.equals("-")) {
            double diff = num1 - num2;
            if (diff % 1 == 0) {
                return num1 + " - " + num2 + " = " + (int) diff;
            } else {
                return num1 + " - " + num2 + " = " + diff;
            }
        }

        if (operation.equals("*")) {
            double prod = num1 * num2;
            if (prod % 1 == 0) {
                return num1 + " * " + num2 + " = " + (int) prod;
            } else {
                return num1 + " * " + num2 + " = " + prod;
            }
        }

        if (operation.equals("/")) {
            if (num2 == 0) {
                return "Cannot divide by zero";
            }
            else {
                double quot = num1 / num2;
                if (quot % 1 == 0) {
                    return num1 + " / " + num2 + " = " + (int) quot;
                }
                else {
                    return num1 + " / " + num2 + " = " + quot;
                }
            }
        }

        return "Invalid expression";
    }

    /**
     * Calculate the power of a number.
     *
     * @param x the base number
     * @param n the exponent
     */
    public void power(int x, int n) {
        if (x == 0 && n == 0) {
            System.out.println("Undefined");
        }
        else {
            Math.pow(x, n);
            System.out.printf("%d^%d = %d\n", x, n, (int) Math.pow(x, n));
        }
    }

    /**
     * Calculates the nth number in the Fibonacci sequence.
     *
     * @param n the position of the number to be calculated
     * @return the nth number in the Fibonacci sequence
     */
    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    /**
     * Calculates the sum of the digits of a given integer.
     *
     * @param n the integer from which to calculate the sum of digits
     * @return the sum of the digits of the given integer
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Performs an arithmetic operation on two fractions.
     *
     * @param fraction1 the first fraction in the format "numerator/denominator"
     * @param fraction2 the second fraction in the format "numerator/denominator"
     * @param operation the arithmetic operation to perform ("+", "-", "*", "/")
     * @return the result of the arithmetic operation as a simplified fraction
     */
    public String operationFractions(String fraction1, String fraction2, String operation) {
        String[] parts = fraction1.split("/");
        int num1 = Integer.parseInt(parts[0]);
        int den1 = Integer.parseInt(parts[1]);

        parts = fraction2.split("/");
        int num2 = Integer.parseInt(parts[0]);
        int den2 = Integer.parseInt(parts[1]);

        int num;
        int den;

        if (operation.equals("+")) {
            num = num1 * den2 + num2 * den1;
            den = den1 * den2;
        } else if (operation.equals("-")) {
            num = num1 * den2 - num2 * den1;
            den = den1 * den2;
        } else if (operation.equals("*")) {
            num = num1 * num2;
            den = den1 * den2;
        } else if (operation.equals("/")) {
            num = num1 * den2;
            den = den1 * num2;
            if (den == 0) {
                return "Cannot divide by zero";
            }
        } else {
            return "Invalid operation";
        }

        // Calculate the greatest common divisor
        int gcd = BigInteger.valueOf(num).gcd(BigInteger.valueOf(den)).intValue();
        num /= gcd;
        den /= gcd;

        // Check if the fraction can be a whole number
        if (den == 1) {
            return String.valueOf(num);
        } else {
            return num + "/" + den;
        }
    }

    /**
     * A function that takes in two strings and an operation, and returns the length
     * of the resulting string
     * based on the given operation.
     *
     * @param str1      the first string
     * @param str2      the second string
     * @param operation the operation to perform on the strings ("+", "-", "*", "/")
     * @return the length of the resulting string based on the given operation, or
     *         "Invalid operation"
     *         if the operation is not one of the specified options
     */
    public String stringOp(String str1, String str2, String operation) {
        if (operation.equals("+")) {
            return String.valueOf(str1.length() + str2.length());
        } else if (operation.equals("-")) {
            return String.valueOf(str1.length() - str2.length());
        } else if (operation.equals("*")) {
            return String.valueOf(str1.length() * str2.length());
        } else if (operation.equals("/")) {
            return String.valueOf((double) str1.length() / str2.length());
        } else {
            return "Invalid operation";
        }
    }

    public void goodbye() {
        System.out.println("Goodbye!");
    }
}
