import java.util.Scanner;

public class Calculator {
    public int result=10;

    public void runCalculator() {
//        do {
            showMenu();
//        }while (true);
    }

        public void showMenu () {
            System.out.println("+ Add");
            System.out.println("- Deduct");
            System.out.println("* Multiply");
            System.out.println("/ Devide");
            System.out.println("Q Quit");
            //System.out.println("Your current value is: " + result);
            String operandString = readOperand();
            int numberOneInput = readNumber();

            /*if ("+" == operandString){
                addMethod();
            } else if ("-" == operandString){
                deductMethod();
            } else if {

            }*/


            switch (operandString) {
                case "+":
                    addMethod(numberOneInput);
                    break;
                case "-":
                    deductMethod(numberOneInput);
                    break;
                case "/":
                    // addMethod();
                    break;
                case "*":
                    // addMethod();
                    break;
                case "Q":
                    quitMethod();
                    break;
            }
            System.out.println("Your final value is: " + result);

        }
        public String readOperand () {
            System.out.println("Type the operand:");
            Scanner sc = new Scanner(System.in);
            String srtInput = sc.nextLine();
            System.out.println("Your operand is: " + srtInput);
            return srtInput;

        }
        public int readNumber () {
            System.out.println("Type your number:");
            Scanner sc = new Scanner(System.in);
            int i =sc.nextInt();
            System.out.println("Your number is: " + i);
            return i;

        }

        public int addMethod (int number) {
        result = result + number;
        return result;


        }
        public int deductMethod (int number) {
            result -= number;
            return result;
        }
        public int devideMethod (int number) {
            result/=number;
            return result;
        }
        public int mulityplyMethod (int number) {
        result *=number;
        return result;
        }


        public void quitMethod () {

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


