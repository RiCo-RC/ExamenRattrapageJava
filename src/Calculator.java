import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public String[] numberList = new String[10];
    public String[] operatorList = new String[5];

    public String operatorType = "";
    public String expression = "";

    public List<Double> expressionNumber = new ArrayList<Double>();
    public List<Character> expressionOperator = new ArrayList<Character>();

    public double result = 0.0;

    public List<Double> log = new ArrayList<Double>();

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

    public Calculator clickOnButton(String buttonValue, Boolean displayInput) {
        for (char character : buttonValue.toCharArray()) {
            if (expression.isEmpty()) expression = String.valueOf(character);
            else expression += String.valueOf(character);
        }
        if (displayInput) System.out.println("--> " + this.expression);
        return this;
    }



    public Calculator extractNumber() {
        StringBuilder number = new StringBuilder();
        for (char character : this.expression.toCharArray()) {
            if (Character.isDigit(character)) {
                number.append(character);
            } else {
                this.expressionNumber.add(Double.parseDouble(number.toString()));
                number.setLength(0);
            }
        }
        this.expressionNumber.add(Double.parseDouble(number.toString()));
        //System.out.println("--> " + this.expressionNumber);
        return this;
    }

    public Calculator extractOperator() {
        for (char character : this.expression.toCharArray()) {
            if (character == '+' || character == '-' || character == '*' || character == '/') {
                this.operatorType = String.valueOf(character);
                this.expressionOperator.add(character);
            }
        }
        //System.out.println("--> " + this.expressionOperator);
        //System.out.println("--> " + this.operatorType);
        return this;
    }

    public Calculator handlePriority() {
        for (int i = 0; i < this.expressionOperator.size(); i++) {
            this.operatorType = String.valueOf(this.expressionOperator.get(i));
            if (this.operatorType.equals("*")) {
                this.result = this.expressionNumber.get(i) * this.expressionNumber.get(i + 1);
            }
            if (this.operatorType.equals("/")) {
                this.result = this.expressionNumber.get(i) / this.expressionNumber.get(i + 1);
            }
            if (this.operatorType.equals("*") || this.operatorType.equals("/")) {
                this.expressionNumber.remove(i + 1);
                this.expressionNumber.remove(i);
                this.expressionNumber.add(i, this.result);
                this.expressionOperator.remove(i);
                i++;
            }
        }
        return this;
    }

    public Calculator extractResult() {
        this.result = this.expressionNumber.getFirst();
        for (int i = 0; i < this.expressionOperator.size(); i++) {
            this.operatorType = String.valueOf(this.expressionOperator.get(i));
            if (this.operatorType.equals("+")) {
                this.result += this.expressionNumber.get(i + 1);
            }
            if (this.operatorType.equals("-")) {
                this.result -= this.expressionNumber.get(i + 1);
            }
        }
        return this;
    }

    public Calculator calculate() {
        this.extractNumber();
        this.extractOperator();
        this.handlePriority();
        this.extractResult();
        System.out.println("Result is: " + this.result);
        return this;
    }

    public Calculator reset() {
        this.operatorType = "";
        this.expression = "";

        this.expressionNumber = new ArrayList<Double>();
        this.expressionOperator = new ArrayList<Character>();
        this.result = 0.0;

        return this;
    }

    public Calculator divider() {
        System.out.println("----------");
        return this;
    }
}
