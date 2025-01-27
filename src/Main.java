import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Boolean isCalculatorIsOn = true;

        //-- INIT --\\

        Calculator calculator = new Calculator();
        calculator.buttons();

        //-- LOOP --\\

        // addition (5+5 = 10)
        calculator.
                clickOnButton("5", true).
                clickOnButton("+", true).
                clickOnButton("5", true).
                calculate().
                reset().
                divider();

        // addition (2+2=4) without input showing
        calculator.
                clickOnButton("2", false).
                clickOnButton("+", false).
                clickOnButton("2", false).
                calculate().
                reset().
                divider();

        // subtraction (5-5=0)
        calculator.
                clickOnButton("5", true).
                clickOnButton("-", true).
                clickOnButton("5", true).
                calculate().
                reset().
                divider();

        // multiplication (2*2=4)
        calculator.
                clickOnButton("2", true).
                clickOnButton("*", true).
                clickOnButton("2", true).
                calculate().
                reset().
                divider();

        // division (10/2 = 5)
        calculator.
                clickOnButton("10", true).
                clickOnButton("/", true).
                clickOnButton("2", true).
                calculate().
                reset().
                divider();

        // (2+(2*4)) -> 2+8 -> 10
        calculator.
                clickOnButton("2", true).
                clickOnButton("+", true).
                clickOnButton("2", true).
                clickOnButton("*", true).
                clickOnButton("4", true).
                calculate().
                reset().
                divider();
    }
}