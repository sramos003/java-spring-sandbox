import java.text.DecimalFormat;

class Scratch {
    static class DigitCounter {
        public static void evaluateNumber(Object numToTest, int numberEquals) {
            // Return decimal formatted number initialized with starting/ending 0s
            DecimalFormat decimalFormat = new DecimalFormat("00000.00000");
            String messageToDisplay;
            String numberToPrint;
            if (numToTest instanceof Double || numToTest instanceof Float) {
                messageToDisplay = (numToTest instanceof Double ? "double" : "float") + " number test ";
                numberToPrint = decimalFormat.format(numberEquals);
            } else if (numToTest instanceof String) {
                messageToDisplay = "string number test ";
                numberToPrint = decimalFormat.format(Double.parseDouble((String) numToTest));
            } else {
                messageToDisplay = "integer number test ";
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

    public static void main(String[] args) {
        double digitDouble = 001234.22000d;
        double decimalDouble = 123.4500d;
        float digitFloat = 123.45f;
        float decimalFloat = 123.45f;
        int number = 123;
        String string = "123.45000";
        // ---
        int three = 3;
        int five = 5;
        DigitCounter.evaluateNumber(digitDouble, five);
        DigitCounter.evaluateNumber(digitFloat, five);
        DigitCounter.evaluateNumber(number, three);
        DigitCounter.evaluateNumber(string, five);
        DigitCounter.evaluateNumber(decimalDouble, five);
        DigitCounter.evaluateNumber(decimalFloat, five);
        DigitCounter.evaluateNumber(number, three);
        DigitCounter.evaluateNumber(string, five);
    }
}
