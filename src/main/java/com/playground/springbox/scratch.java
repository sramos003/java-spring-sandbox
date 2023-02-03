import java.text.DecimalFormat;
import java.util.List;

class Scratch {

    static class DigitCounter {
        enum CounterTypes {
            DecimalCounter, DigitCounter
        }
        // Determine current instance of Object method,
        // this is the same as overloading the methods signatures,
        // you just use the base Object type and check for the type instance you need
        public static void evaluateNumber(Object numToTest, int numberEquals, CounterTypes counterTypes) {
            // Return decimal formatted number initialized with starting/ending 0s
            DecimalFormat decimalFormat = new DecimalFormat("00000.00000");
            // boolean t/f checks.
            boolean isDecimalInstance = (numToTest instanceof Double || numToTest instanceof Float);
            boolean isStringInstance = (numToTest instanceof String);
            String messageToDisplay;
            String numberToPrint;
            String subMessage = CounterTypes.DigitCounter.equals(counterTypes) ? "digit" : "decimal";
            int counterTypeLength;
            // Check current instance.
            if (isDecimalInstance) {
                messageToDisplay = String.format("%s %s number test", (numToTest instanceof Double ? "double" : "float"), subMessage);
                numberToPrint = decimalFormat.format(numToTest);
            } else if (isStringInstance) {
                messageToDisplay = String.format("string %s number test ", subMessage);
                numberToPrint = decimalFormat.format(Double.parseDouble((String) numToTest));
            } else {
                messageToDisplay = String.format("integer %s number test ", subMessage);
                numberToPrint = String.valueOf(numToTest);
            }
            // Determine comparison to make for digits or decimals or L or R of decimal point.
            if (isDecimalInstance || isStringInstance) {
                var splitStringLeft = numberToPrint.substring(0, numberToPrint.indexOf("."));
                var splitStringRight = numberToPrint.substring(numberToPrint.indexOf("."));
                // Digit counter must return the numbers of digits left of the decimal
                // Digit counter must return the numbers of digits right of the decimal
                counterTypeLength = counterTypes.equals(CounterTypes.DigitCounter) ? splitStringLeft.length() : splitStringRight.length();
            } else {
                // No decimal points provided, return the length of the string.
                counterTypeLength = numberToPrint.length();
            }
            String pass_or_fail = (counterTypeLength == numberEquals ? " PASS " : " FAIL ");
            System.out.printf(messageToDisplay + " number: " + numberToPrint + " : " + pass_or_fail + " \n --- \n");
        }
    }

    static class Digit {
        private final Object numberToTest;
        private final int numberToEvaluate;

        public Digit(Object numberToTest, int numberToEvaluate) {
            this.numberToTest = numberToTest;
            this.numberToEvaluate = numberToEvaluate;
        }

        public void evaluateNumber(DigitCounter.CounterTypes counterTypes) {
            DigitCounter.evaluateNumber(this.numberToTest, this.numberToEvaluate, counterTypes);
        }
    }

    static class DigitWrapper {
        List<Digit> digitList;
        DigitCounter.CounterTypes counterTypes;

        public DigitWrapper(List<Digit> digitList, DigitCounter.CounterTypes counterTypes) {
            this.digitList = digitList;
            this.counterTypes = counterTypes;
        }

        public void evaluateNumber() {
            digitList.forEach((digitItem) -> digitItem.evaluateNumber(counterTypes));
        }
    }

    public static void main(String[] args) {
        int three = 3, five = 5;
        double digitDouble = 001234.22000d, decimalDouble = 123.4500d;
        float digitFloat = 123.45f, decimalFloat = 123.45f;
        int number = 123;
        String string = "123.45000";
        // -- Lists of data
        List<Digit> digitList = List.of(new Digit(digitDouble, five), new Digit(digitFloat, five), new Digit(number, three), new Digit(string, five));
        List<Digit> decimalList = List.of(new Digit(decimalDouble, five), new Digit(decimalFloat, five), new Digit(number, three), new Digit(string, five));
        // -- Run logic
        new DigitWrapper(digitList, DigitCounter.CounterTypes.DigitCounter).evaluateNumber();
        new DigitWrapper(decimalList, DigitCounter.CounterTypes.DecimalCounter).evaluateNumber();
    }
}
