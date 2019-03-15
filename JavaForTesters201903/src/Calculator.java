import java.util.Scanner;

public class Calculator {
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private int result=0;

    public void runCalculator() {
        String operandString="";
        do {

            showMenu();
            operandString = readOperand("Please enter operand: ");
            int selectedNumber = readNumber("Please enter number: ");
            switch (operandString) {
                case "+":
                    addMethod(selectedNumber);
                    break;
                case "-":
                    deductMethod(selectedNumber);
                    break;
                case "/":
                     devideMethod(selectedNumber);
                    break;
                case "*":
                     mulityplyMethod(selectedNumber);
                    break;

            }
            System.out.println("Your current value is: " + result);
        }while (!operandString.equals("Q"));
       System.out.println("Your final value is: " + result);
    }

        private void showMenu () {
       //     do {
                System.out.println("+ Add");
                System.out.println("- Deduct");
                System.out.println("* Multiply");
                System.out.println("/ Divide");
                System.out.println("Q Quit");
            System.out.println("Your current value is: " + result);

              }



        private String readOperand(String s) {
            Scanner sc = getScanner(s);
//            String srtInput = sc.nextLine();
            return sc.nextLine();

        }

    private Scanner getScanner(String s) {
        System.out.println(s);
        return new Scanner(System.in);
    }

    private int readNumber(String s) {
        Scanner sc = getScanner(s);
//        int i =sc.nextInt();
        boolean isValid=false;
        int i = 0;

        try {
            i = Integer.parseInt(readOperand(s));
            isValid=true;
        } catch (NumberFormatException e) {
            System.out.println("The wrong value, try one more time please");
        }
        return i;

        }

        private int addMethod (int number) {
        result = result + number;
        return result;


        }
        private int deductMethod (int number) {
            result -= number;
            return result;
        }
        private int devideMethod (int number) {
            result/=number;
            return result;
        }
        private int mulityplyMethod (int number) {
        result *=number;
        return result;
        }


     }

/*
showMenu
readOperand

addMethod
deductMethod
devideMethod
mulityplyMethod


quitMethod
*/
//Requirements for Calculator:
// display menu:
//+ Add
//- Deduct
//* Multiply
// Devide
//Q Quit
//Your reslut is


