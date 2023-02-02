
import java.text.DecimalFormat;

class Scratch {
    static class DigitCounter {
        // Return decimal formatted number initialized with starting/ending 0s 
        private final DecimalFormat decimalFormat = new DecimalFormat("00000.00000");
        
        private int getConvertedNum(String string) {
            var index = string.indexOf(".");
            return index == -1 ? string.length() : index;
        }
        
        private int counter(Object value) {
            boolean isDecimalInstance = (value instanceof Double || value instanceof Float);
            boolean isStringInstance = (value instanceof String);
            // If Object is of Double or Float return decimal formatted number
            if (isDecimalInstance) {
                return getConvertedNum(decimalFormat.format(value));
            }
            // If Object is of String return decimal formatted number
            if (isStringInstance) {
                return getConvertedNum(decimalFormat.format(Double.parseDouble((String) value)));
            }
            // If Object is of anything else besides Double or Float or String, convert to string.
            return getConvertedNum(String.valueOf(value));
        }

        public static void evaluateNumber(String messageToDisplay, Object numToTest, int numberEquals) {
            var digitCounter = new DigitCounter();
            System.out.printf(messageToDisplay + (digitCounter.counter(numToTest) == numberEquals ? " PASS " : " FAIL ") + "\n-//-\n");
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
        // Digit counter must return the numbers of digits left of the decimal
        DigitCounter.evaluateNumber("Double digit test 001234.22000: ", digitDouble, five);
        DigitCounter.evaluateNumber("Float digit test 00123.4500 ", digitFloat, five);
        DigitCounter.evaluateNumber("Int digit test 123: ", number, three);
        DigitCounter.evaluateNumber("String digit test: 123.4500: ", string, five);
        // Decimal counter must return the numbers of digits right of the decimal
        DigitCounter.evaluateNumber("Double decimal test 00123.4500", decimalDouble, five);
        DigitCounter.evaluateNumber("Float decimal test 00123.4500", decimalFloat, five);
        DigitCounter.evaluateNumber("Int decimal test 123: ", number, three);
        DigitCounter.evaluateNumber("String decimal test 123.4500", string, five);
    }
}
