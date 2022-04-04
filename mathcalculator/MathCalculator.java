package mathcalculator;

import java.util.Scanner;


class SplashLoadingIndicator extends Thread{


    /**
     * Clear the terminal 
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {}
    }

    @Override
    public void run(){
        clearConsole();
        System.out.print("Loading :: ");


        for( int i=0; i<20; i++ ){
            System.out.print("#");
            try{
                Thread.sleep( 200  );

            }
            catch( Exception e ){
                    System.out.println("Sleeping thdread interrupte");
            }

        }

        clearConsole();


    }
}

/**
 *
 * @AUTHOR GUDINA NEGERA's Group @ MICROLINK INFORMATION TECHNOLOGY COLLEGE
 */
public class MathCalculator {


    public static void calculatorMenu(int opts[], String items[]) {
       
        /**
         * Start the loading indicator on a separate thread
         */
        Thread t = new SplashLoadingIndicator();
        t.start();


        /**
         * Wait for the thread to complete 
         */
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

        

        System.out.println("*************************************");
        System.out.println("\n M A T H C A L C U L A T O R");
        System.out.println("*************************************");



        for (int i = 0; i < opts.length - 1; i++) {
            System.out.printf("%d. %s\t\n", opts[i], items[i]);
        }
        System.out.printf("%d. %s\t\n", opts[opts.length - 1], items[items.length - 1]);
        System.out.println("*************************************");
        System.out.println(" Enter your selection number: \n ");
        System.out.println("*************************************");
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int choice;
        int option[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        String operatorMenu[] = { "Addition", "Subtraction", "Multiplication", "Division",
                "Remainder", "Quadratic Equation", "Square Root", "Exponent", "Sin", "Cosine", "Tangent", "Exit" };
        double firstnum, secondnum, a, b, c, num, answer, exb, expn, sini, x;
        int EXIT = option[option.length - 1];
        calculatorMenu(option, operatorMenu);

        Scanner in = new Scanner(System.in);

        choice = in.nextInt();

        while (choice != EXIT) {
            if (choice == option[0]) {
                System.out.println("Enter First Number: ");
                firstnum = in.nextDouble();
                System.out.println("Enter Second Number: ");
                secondnum = in.nextDouble();
                answer = firstnum + secondnum;
                System.out.println("First Number + Second Number: = " + answer);
            } else if (choice == option[1]) {
                System.out.println("Enter First Number: ");
                firstnum = in.nextDouble();
                System.out.println("Enter Second Number: ");
                secondnum = in.nextDouble();
                answer = firstnum - secondnum;
                System.out.println("First Number - Second Number: = " + answer);

            }

            else if (choice == option[2]) {
                System.out.println("Enter First Number: ");
                firstnum = in.nextDouble();
                System.out.println("Enter Second Number: ");
                secondnum = in.nextDouble();
                answer = firstnum * secondnum;
                System.out.println("First Number * Second Number: = " + answer);
            }

            else if (choice == option[3]) {
                System.out.println("Enter First Number: ");
                firstnum = in.nextDouble();
                System.out.println("Enter Second Number: ");
                secondnum = in.nextDouble();
                answer = firstnum / secondnum;
                System.out.println("First Number / Second Number: = " + answer);
            }

            else if (choice == option[4]) {
                System.out.println("Enter First Number: ");
                firstnum = in.nextDouble();
                System.out.println("Enter Second Number: ");
                secondnum = in.nextDouble();
                answer = firstnum % secondnum;
                System.out.println("The reminder is = " + answer);
            } else if (choice == option[5]) {
                System.out.print("Input a: ");
                a = in.nextDouble();
                System.out.print("Input b: ");
                b = in.nextDouble();
                System.out.print("Input c: ");
                c = in.nextDouble();

                double result = b * b - 4.0 * a * c;

                if (result > 0.0) {
                    double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
                    double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);
                    System.out.println("The roots are " + r1 + " and " + r2);
                } else if (result == 0.0) {
                    double r1 = -b / (2.0 * a);
                    System.out.println("The root is " + r1);
                } else {
                    System.out.println("The equation has no real roots.");
                }
            }

            else if (choice == option[6]) {
                System.out.print("Enter a number: ");
                num = in.nextDouble();
                Double squareroot = Math.pow(num, 0.5);
                System.out.println("The Square of a Given Number  " + num + "  =  " + squareroot);
            }

            else if (choice == option[7]) {
                System.out.println("Enter base:");
                exb = in.nextDouble();
                System.out.println("Enter Exponent:");
                expn = in.nextDouble();
                double result = Math.pow(exb, expn);

                System.out.println("Answer = " + result);
            }

            else if (choice == option[8]) {
                System.out.println("Enter number you want to find its Sin");
                sini = in.nextDouble();
                // converting values to radians
                sini = Math.toRadians(sini);
                System.out.println(Math.sin(sini));
            }

            else if (choice == option[9]) {

                System.out.println("Enter number you want to find its Cos");
                x = in.nextDouble();
                // convert them to radians
                x = Math.toRadians(x);

                // print their cosine
                System.out.println("Cos = " + x);

            }

            else if (choice == option[10]) {
                System.out.println("Enter number you want to find its tan: ");
                a = in.nextDouble();
                // converting values to radians
                b = Math.toRadians(a);

                System.out.println(Math.tan(b));

            }

            else {
                System.out.println("Invalid choice");
            }
            calculatorMenu(option, operatorMenu);
            choice = in.nextInt();
        }
        System.out.println("Thank you for Using ");
    }

}