import java.util.Scanner;

public class MathListRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to my Math program!");

        Scanner scanner = new Scanner(System.in);
        String option = "0";

        while (!option.equals("7")) {
            System.out.println("What do you want to do?\n");
            System.out.println("0. Random choice from 1-6");
            System.out.println("1. Do basic operations (addition, subtraction, multiplication, division)");
            System.out.println("2. Find the power of x to the n");
            System.out.println("3. Find the nth term of the Fibonacci sequence");
            System.out.println("4. Find the sum of the digits of a positive number");
            System.out.println("5. Do basic operations with fractions (with pretty printing)");
            System.out.println("6. Do basic operations with the length of two strings");
            System.out.println("7. Exit the program");

            System.out.println(
                    "If you want option 1, you can type 1, followed by a comma (with no space) and then the expression you want to do.\nSelect an option: ");
            option = scanner.next();
            if (option.contains("1,")) {
                String expression = option.split(",")[1];
                String tempOption = "1";
                MathList mathListOpt1 = new MathList(Integer.parseInt(tempOption), expression);
                System.out.println(mathListOpt1.calculateExpression(expression));
            } else {
                int optionInt = Integer.parseInt(option);
                MathList mathList = new MathList(optionInt);
                if (optionInt == 0) {
                    optionInt = (int) (Math.random() * 6) + 1;
                    System.out.println("Random choice: " + optionInt);
                }

                if (optionInt == 1) {
                    System.out.println("Enter an expression: (e.g. 1+2)");
                    String expression = scanner.next();
                    System.out.println(mathList.calculateExpression(expression));

                } else if (optionInt == 2) {
                    System.out.println("Enter the value of x: ");
                    int x = scanner.nextInt();
                    System.out.println("Enter the value of n: ");
                    int n = scanner.nextInt();
                    mathList.power(x, n);

                } else if (optionInt == 3) {
                    System.out.println("Enter the value of n: ");
                    int n = scanner.nextInt();
                    if (n >= 48) {
                        System.out.println("Too big number");
                    } else {
                        System.out.printf("Nth term of the Fibonacci sequence: %d\n", mathList.fibonacci(n));
                    }

                } else if (optionInt == 4) {
                    System.out.println("Enter a positive number: ");
                    int n = scanner.nextInt();
                    if (n > Integer.MAX_VALUE) {
                        System.out.println("Too big number");
                    } else {
                        System.out.printf("Sum of digits: %d\n", mathList.sumOfDigits(n));
                    }

                } else if (optionInt == 5) {
                    System.out.println("Enter a fraction (if you want a whole number, write it as x/1): ");
                    String fraction1 = scanner.next();
                    System.out.println("Enter an operation (+, -, *, /): ");
                    String operation = scanner.next();
                    System.out.println("Enter another fraction (if you want a whole number, write it as x/1): ");
                    String fraction2 = scanner.next();
                    System.out.printf("%s %s %s = %s\n", fraction1, operation, fraction2,
                            mathList.operationFractions(fraction1, fraction2, operation));

                } else if (optionInt == 6) {
                    System.out.println("Enter a string: ");
                    String str1 = scanner.next();
                    System.out.println("Enter another string: ");
                    String str2 = scanner.next();
                    System.out.println("Enter an operation (+, -, *, /): ");
                    String operation = scanner.next();
                    System.out.printf("%s %s %s = %s\n", str1, operation, str2,
                            mathList.stringOp(str1, str2, operation));

                } else if (optionInt == 7) {
                    mathList.goodbye();
                    scanner.close();
                }
            }
        }
    }
}
