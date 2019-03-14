import java.util.Scanner;

public class Calculator {
    public int result=0;

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

        public void showMenu () {
       //     do {
                System.out.println("+ Add");
                System.out.println("- Deduct");
                System.out.println("* Multiply");
                System.out.println("/ Divide");
                System.out.println("Q Quit");
            System.out.println("Your current value is: " + result);

              }


        public String readOperand(String s) {
            System.out.println(s);
            Scanner sc = new Scanner(System.in);
            String srtInput = sc.nextLine();
            return srtInput;

        }
        public int readNumber(String s) {
            System.out.println(s);
            Scanner sc = new Scanner(System.in);
            int i =sc.nextInt();
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


