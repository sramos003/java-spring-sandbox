import java.text.DecimalFormat;
import java.util.List;

class Scratch {

    static class DigitCounter {
        enum CounterTypes {
            DecimalCounter, DigitCounter
        }
        public static void evaluateNumber(Object numToTest, int numberEquals, CounterTypes counterTypes) {
            // Return decimal formatted number initialized with starting/ending 0s
            DecimalFormat decimalFormat = new DecimalFormat("00000.00000");
            String messageToDisplay;
            String numberToPrint;
            String subMessage = CounterTypes.DigitCounter.equals(counterTypes) ? "digit" : "decimal";
            if (numToTest instanceof Double || numToTest instanceof Float) {
                messageToDisplay = String.format("%s %s number test", (numToTest instanceof Double ? "double" : "float"), subMessage);
                numberToPrint = decimalFormat.format(numToTest);
            } else if (numToTest instanceof String) {
                messageToDisplay = String.format("string %s number test ", subMessage);
                numberToPrint = decimalFormat.format(Double.parseDouble((String) numToTest));
            } else {
                messageToDisplay = String.format("integer %s number test ", subMessage);
                numberToPrint = String.valueOf(numToTest);
            }
            var index = numberToPrint.indexOf(".");
            var convertedNumber = index == -1 ? numberToPrint.length() : index;
            // Digit counter must return the numbers of digits left of the decimal
            // Digit counter must return the numbers of digits right of the decimal   
            String pass_or_fail = (convertedNumber == numberEquals ? " PASS " : " FAIL ");
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
