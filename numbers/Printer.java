package numbers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Printer extends NumberProcessor{

    public void printProperties(long number) {
        if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else {
            System.out.println("Properties of " + number);
            System.out.println("\teven: " + isEvenNumber(number));
            System.out.println("\todd: " + !isEvenNumber(number));
            System.out.println("\tbuzz: " + isBuzzNumber(number));
            System.out.println("\tduck: " + isDuckNumber(number));
            System.out.println("\tpalindromic: " + isPalindromicNumber(number));
            System.out.println("\tgapful: "  + isGapfulNumber(number));
            System.out.println("\tspy: " + isSpyNumber(number));
        }
    }

    public void printProperties(long number, int listLen) {
        if (listLen < 0) {
            System.out.println("The second parameter should be a natural number.");
        } else {
            for (int i = 0; i < listLen; i++) {
                printPropList(number);
                number++;
            }
        }
    }

    public void printProperties(long number, int listLen, String property) {
        String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy"};
        String prop = property.toLowerCase();

        if (!Arrays.asList(properties).contains(prop)) {
            System.out.println("The property " + "[" + prop.toUpperCase() + "]" + " is wrong.\n" +
                                "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
        } else {
            int count = 0;
            while (count < listLen) {
                if (hasProperty(number, prop)) {
                    printPropList(number);
                    count++;
                }
                number++;
            }
        }
    }

    public void printPropList(long number) {
        String even = isEvenNumber(number) ? "even" : "";
        String odd = !isEvenNumber(number) ? "odd" : "";
        String buzz = isBuzzNumber(number) ? "buzz" : "";
        String duck = isDuckNumber(number) ? "duck" : "";
        String palindromic = isPalindromicNumber(number) ? "palindromic" : "";
        String gapful = isGapfulNumber(number) ? "gapful" : "";
        String spy = isSpyNumber(number) ? "spy" : "";

        String listProperties = Stream.of(even, odd, buzz, duck, palindromic, gapful, spy) //
                .filter(str -> str != null && !str.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println(number + " is " + listProperties);
    }

    public boolean hasProperty(long number, String property) {
        boolean numberProperty = false;
        if (property.equals("duck")) {
            numberProperty = isDuckNumber(number);
        } else if (property.equals("spy")) {
            numberProperty = isSpyNumber(number);
        } else if (property.equals("even")) {
            numberProperty = isEvenNumber(number);
        } else if (property.equals("odd")) {
            numberProperty = !isEvenNumber(number);
        } else if (property.equals("gapful")) {
            numberProperty = isGapfulNumber(number);
        } else if (property.equals("palindromic")) {
            numberProperty = isPalindromicNumber(number);
        } else if (property.equals("buzz")) {
            numberProperty = isBuzzNumber(number);
        }
        return numberProperty;
    }


}
