import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner inputG = new Scanner(System.in);

        System.out.print(
                "** Welcome to the Java Calculator! ** \n\n What would like to solve today? \n 1. Basic Arithmetic (+,-,*,/) \n 2. Quadratic Equation \n 3. Sqaure Root \n 4. Exponent \n Enter a number: ");
        int userAnswer = inputG.nextInt();
        if (userAnswer == 1) {
            arithmetic();
        }
        if (userAnswer == 2) {
            quadratic();
        }
        if (userAnswer == 3) {
            System.out.println("Enter a number: ");
            double userRoot = inputG.nextDouble();
            if (userRoot > 0) {
                System.out.println("The square root of " + userRoot + " is " + sqrt(userRoot));
                System.out.println();
                repeatCalc();
            } else {
                System.out.println("Invalid Input.");
                System.out.println();
                repeatCalc();
            }
        }
        if (userAnswer == 4) {
            System.out.println("Enter a number (base): ");
            double base = inputG.nextDouble();
            System.out.println("Enter an exponent: ");
            double exp = inputG.nextDouble();
            System.out.println(
                    base + " raised to a power of " + exp + " is " + Math.pow(base, exp));
            repeatCalc();
        }
        inputG.close();
    }

    public static void arithmetic() {
        double num1;
        double num2;
        double answer;
        Scanner inputA = new Scanner(System.in);

        System.out.println("Select an operator: +, -, *, /");
        char operator = inputA.next().charAt(0);
        System.out.println("Enter first number:");
        num1 = inputA.nextDouble();

        System.out.println("Enter second number:");
        num2 = inputA.nextDouble();

        switch (operator) {
            case '+':
                answer = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + answer);
                repeatCalc();
            case '-':
                answer = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + answer);
                repeatCalc();

            case '*':
                answer = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + answer);
                repeatCalc();

            case '/':
                answer = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + answer);
                repeatCalc();
        }
        inputA.close();
    }

    public static void quadratic() {
        double a, b, c;
        double root1, root2;
        Scanner inputQ = new Scanner(System.in);

        System.out.print("Quadratic Equation: ax^2 + bx + c = 0 \n Enter a value of a: ");
        a = inputQ.nextDouble();
        System.out.print("Enter a value of b: ");
        b = inputQ.nextDouble();
        System.out.print("Enter a value of c: ");
        c = inputQ.nextDouble();

        double discriminant = (b * b) - (4 * a * c);
        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            root2 = (-b - Math.sqrt(discriminant)) / 2 * a;
            System.out.format("First Root: %.2f \n Second Root: %.2f", root1, root2);
            System.out.println();
            repeatCalc();
        } else if (discriminant == 0) {
            root1 = -b / (2 * a);
            System.out.format("Root: %.2f", root1);
            System.out.println();
            repeatCalc();
        } else {
            double real = -b / (2 * a);
            double img = Math.sqrt(-discriminant) / (2 * a);
            System.out.format("First Root: %.2f+%.2fi", real, img);
            System.out.format("\n Second Root: %.2f-%.2fi", real, img);
            System.out.println();
            repeatCalc();
        }
        inputQ.close();
    }

    public static double sqrt(double userA) {
        return Math.sqrt(userA);
    }

    public static void repeatCalc() {
        Scanner repeat = new Scanner(System.in);
        System.out.print("Would you like to do another calculation (Y/N)? ");
        String userRepeat = repeat.next();
        if (userRepeat.equals("Y") || userRepeat.equals("y")) {
            main(null);
        } else if (userRepeat.equals("N") || userRepeat.equals("n")) {
            System.exit(0);
        }
        repeat.close();
    }
}
