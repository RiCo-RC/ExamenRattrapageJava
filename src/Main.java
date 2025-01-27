import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Boolean isCalculatorIsOn = true;

        //-- INIT --\\

        Calculator calculator = new Calculator();
        calculator.buttons();

        //-- LOOP --\\

        calculator.clickOnButton("5").clickOnButton("+").clickOnButton("5").calculate();
        calculator.clickOnButton("2").clickOnButton("-").clickOnButton("2").calculate();
    }
}