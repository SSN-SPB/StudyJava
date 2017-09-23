import java.util.Arrays;
        import java.util.InputMismatchException;
        import java.util.Scanner;

/**

 Reuse:
 1) input from console
 2) Menu with exit by decision
 3) Regexp rule:
 double like grRes=333.1234567 moves to string 333.12 or 333.123 by following
 String grRes = Double.toString(res);
 grRes = grRes.replaceAll("([0-9]+\\.[0-9][0-9])[0-9]+", "$1");
 String grRes2 = Double.toString(res).replaceAll("(\\d+\\.\\d{1,3})\\d+", "$1");

 Two dimension Array treating

 */
public class Calculator {
    public static final String HELP_ARGUMENT = "-h";
    public static final String THE_REQUIRED_PSEUDOSYMBOLS_ARE_NOT_DEFINED = "The required pseudo symbols are not defined yet. Sorry. Try to another digits, please";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.mainImpl(args);

    }

    public static void mainImpl(String args[]) {
// Analyze the input argument. If it is equal to "-h" - display message
/*

        boolean again = true;
        while (again) {
*/
        try {
            String fstarg = args[0];

            if (HELP_ARGUMENT.equals(fstarg)) {
                ServiceInfo.help();
                return;
            }
// If there is no input argument the "Introduction Message" will be displayed.
// It suppose to provide instruction to user as "Introduction Message"
        } catch (ArrayIndexOutOfBoundsException ie) {
            System.out.println(ServiceInfo.INTRODUCTION_MESSAGE);

        }


        boolean again = true;
        while (again) {

// Assign the initial values for 1st, 2nd digits and the result
            double firstDigit;
            double secondDigit;
            double res = 0;
// Define values for 1st, 2nd digits via method "inpdig"
            try {
                firstDigit = inputDigit("1st");
                secondDigit = inputDigit("2nd");
// In case of the wrong input the performing is stopped and the
// corresponding message is displayed
            } catch (NumberFormatException ie) {
                System.out.println(ServiceInfo.WRONG_ACTION_SELECTED);
                return;
            }
// Define the action to perform

            System.out.println("Now select the math action:::");
            System.out.println("Enter 1 to add the first and the second: a+b");
            System.out.println("Enter 2 to multiply the first and the second: a*b");
            System.out.println("Enter 3 to substruct " +
                    "the second from the first: a-b");
            System.out.println("Enter 4 to divide the first by the second: a/b\n Enter 5 if you want to exit\n");
            Scanner scanner2 = new Scanner(System.in);
            int choice = -5;
            try {
                choice = scanner2.nextInt();
// In case of the wrong input the performing is stopped and
// the corresponding message is displayed
            } catch (InputMismatchException ie) {
                System.out.println(ServiceInfo.WRONG_ACTION_SELECTED);
                return;
            }

            switch (choice) {
                case 1:
                    res = sumDigit(firstDigit, secondDigit);
                    printOutResult(res);
                    break;
                case 2:
                    res = multiplyDigit(firstDigit, secondDigit);
                    printOutResult(res);
                    break;
                case 3:
                    res = substuctDigit(firstDigit, secondDigit);
                    printOutResult(res);
                    break;
                case 4:
                    res = divideDigit(firstDigit, secondDigit);

                    printOutResult(res);
                    break;
                case 5:
                    System.out.println(ServiceInfo.THANKS_FOR_USING);
                    again = false;
                    break;

                default:
// If selection is unknown the exit flag is set to TRUE and exit from program
                    System.out.println(ServiceInfo.WRONG_ACTION_SELECTED);
                    again = true;

            }

        }
    }

    private static void printOutResult(double res) {
        System.out.printf(ServiceInfo.THE_FINAL_RESULT_IS, res);
        // System.out.println(res);

        String grRes = Double.toString(res);
        grRes = grRes.replaceAll("([0-9]+\\.[0-9][0-9])[0-9]+", "$1");
        // String grRes2 = Double.toString(res).replaceAll("(\\d+\\.\\d{1,2})\\d+", "$1");
        System.out.println("String result: " + grRes);
        // System.out.println("String result2: " + grRes2);
        char[] charArray = grRes.toCharArray();

        try {
            printOutR(charArray);
        } catch (NullPointerException e) {
            System.out.println(THE_REQUIRED_PSEUDOSYMBOLS_ARE_NOT_DEFINED);
        }


    }

    private static void printOutR(char[] charArrayResult) {
        String stringArrayResult [][]= new String[charArrayResult.length][];
        String stringArrayResult2 [][]= new String[charArrayResult.length][];
        for(int z1=0;z1<charArrayResult.length;z1++) {
           // stringArrayResult2[z1]= new PseudoSymbol(charArrayResult[z1]);

            if(charArrayResult[z1] == '3'){
                stringArrayResult[z1] = new String[]{"ZZZZZ ", "   Z  ", "  Z   ", " ZZZ  ", "    Z ", "    Z ","ZZZZ  "};
            }
            if(charArrayResult[z1] == '0'){
                stringArrayResult[z1] = new String[]{" ZZZ   ", "ZZZZZ  ", "Z   Z ", "Z   Z ", "Z   Z ","ZZZZZ  "," ZZZ   "};
              }
            if(charArrayResult[z1] == '.'){
                stringArrayResult[z1] = new String[]{"     ", "     ", "     ", "     ", "     ", " ZZ  ", " ZZ  "};
                }
            if(charArrayResult[z1] == '4'){
                stringArrayResult[z1] = new String[]{"  Z  Z ", "  Z  Z ", "  Z  Z ", "  ZZZZ ", "     Z ", "     Z ","     Z "};
            }
            if(charArrayResult[z1] == '5'){
                stringArrayResult[z1] = new String[]{" ZZZZ  ", " Z     ", " Z     ", " ZZZZ  ", "    Z  ", "    Z  "," ZZZZ  "};
            }
        }
        System.out.println("Print out final result in pseudographic mode:\n"/* + Arrays.deepToString(stringArrayResult*/);

        for(int j=0;j<7;j++)
        {
            for(int i=0;i<stringArrayResult.length;i++)
            {
                System.out.print(stringArrayResult[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n");

         }







    public static Double inputDigit(String order) {
        System.out.println("Enter the " + order + " digit");
        Scanner scanner = new Scanner(System.in);

        String country = scanner.next();
        double digit = Double.parseDouble(country);
        return digit;

    }

    public static Double sumDigit(double one, double two) {
        double result = one + two;
        return result;
    }

    public static Double multiplyDigit(double one, double two) {
        double result = one * two;
        return result;
    }

    public static Double substuctDigit(double one, double two) {
        double result = one - two;
        return result;
    }

    public static Double divideDigit(double one, double two) {
        double result = one / two;
        return result;
    }


}
