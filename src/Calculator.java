public class Calculator {

    public String[] numberList = new String[10];
    public String[] operatorList = new String[5];
    public int firstNumber;
    public boolean isFirstNumberEmpty = true;
    public String operatorType = "";
    public int secondNumber;
    public boolean isSecondNumberEmpty = true;
    public String operatorString = "";

    public void buttons() {
        numberList[0] = "0";
        numberList[1] = "1";
        numberList[2] = "2";
        numberList[3] = "3";
        numberList[4] = "4";
        numberList[5] = "5";
        numberList[6] = "6";
        numberList[7] = "7";
        numberList[8] = "8";
        numberList[9] = "9";

        operatorList[0] = "+";
        operatorList[1] = "-";
        operatorList[2] = "*";
        operatorList[3] = "/";
        operatorList[4] = "%";
    }

    public Calculator clickOnButton(String button) {
        for (String number : this.numberList) {
            if (number.equals(button) && this.isFirstNumberEmpty) {
                this.firstNumber = Integer.parseInt(button);
                this.isFirstNumberEmpty = false;
                this.operatorString += button + " ";
                //System.out.println("First Number: " + button);
                break;
            }
            else if (number.equals(button) && this.isSecondNumberEmpty) {
                this.secondNumber = Integer.parseInt(button);
                this.isSecondNumberEmpty = false;
                this.operatorString += button;
                //System.out.println("Second Number: " + button);
                break;
            }
        }

        for (String operator : this.operatorList) {
            if (operator.equals(button) && this.operatorType.isEmpty()) {
                this.operatorType = button;
                this.operatorString += button + " ";
                //System.out.println("Operator is : " + button);
                break;
            }
        }
        return this;
    }

    public Calculator calculate() {
        int value = 0;
        switch (this.operatorType) {
            case "+":
                value = this.firstNumber + this.secondNumber;
                //System.out.println(value);
                break;
            case "-":
                value = this.firstNumber - this.secondNumber;
                //System.out.println(value);
                break;
            case "*":
                value = this.firstNumber * this.secondNumber;
                //System.out.println(value);
                break;
            case "/":
                value = this.firstNumber / this.secondNumber;
                //System.out.println(value);
                break;
            case "%":
                value = this.firstNumber % this.secondNumber;
                //System.out.println(value);
                break;
            default:
                //System.out.println(value);
                break;
        }
        System.out.println(this.operatorString + " = " + value);
        return this;
    }
}