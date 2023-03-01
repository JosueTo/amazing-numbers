package numbers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Printer extends NumberProcessor{

    public void printProperties(long number) {
        if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else if (number > 0) {
            System.out.println("Properties of " + number);
            System.out.println("\teven: " + isEvenNumber(number));
            System.out.println("\todd: " + !isEvenNumber(number));
            System.out.println("\tbuzz: " + isBuzzNumber(number));
            System.out.println("\tduck: " + isDuckNumber(number));
            System.out.println("\tpalindromic: " + isPalindromicNumber(number));
            System.out.println("\tgapful: "  + isGapfulNumber(number));
            System.out.println("\tspy: " + isSpyNumber(number));
            System.out.println("\tsunny: " + isSunnyNumber(number));
            System.out.println("\tsquare: " + isPerfectSquareNumber(number));
        }
    }

    public void printProperties(long number, int listLen) {
        if (listLen <= 0) {
            System.out.println("The second parameter should be a natural number.");
        } else {
            for (int i = 0; i < listLen; i++) {
                System.out.println(propList(number));
                number++;
            }
        }
    }

    public void printProperties(long number, int listLen, String property) {
        String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny", "square"};
        String prop = property.toLowerCase();

        if (!Arrays.asList(properties).contains(prop)) {
            System.out.println("The property " + "[" + prop.toUpperCase() + "]" + " is wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
        } else {
            int count = 0;
            while (count < listLen) {
                if (hasProperty(number, prop)) {
                    System.out.println(propList(number));
                    count++;
                }
                number++;
            }
        }
    }

    public void printProperties(long number, int listLen, String property, String property2) {
        String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny", "square"};
        String prop1 = property.toLowerCase();
        String prop2 = property2.toLowerCase();

        if (!Arrays.asList(properties).contains(prop2) && !Arrays.asList(properties).contains(prop1)) {
            System.out.println("The properties [" + prop1.toUpperCase() + ", " + prop2.toUpperCase() + "] are wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
        } else if (!Arrays.asList(properties).contains(prop1)) {
            System.out.println("The property [" + prop1.toUpperCase() + "] is wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
        } else if (!Arrays.asList(properties).contains(prop2)) {
            System.out.println("The property [" + prop2.toUpperCase() + "] is wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
        } else if (hasMutuallyExclusiveProperties(prop1, prop2)) {
            System.out.println("The request contains mutually exclusive properties: [" + prop1.toUpperCase() +
                    ", " + prop2.toUpperCase() + "]\n" +
                    "There are no numbers with these properties.");
        } else {
            int count = 0;
            while (count < listLen) {
                if (hasProperty(number, prop1) & hasProperty(number, prop2)) {
                    System.out.println(propList(number));
                    count++;
                }
                number++;
            }
        }
    }



    public String propList(long number) {
        String even = isEvenNumber(number) ? "even" : "";
        String odd = !isEvenNumber(number) ? "odd" : "";
        String buzz = isBuzzNumber(number) ? "buzz" : "";
        String duck = isDuckNumber(number) ? "duck" : "";
        String palindromic = isPalindromicNumber(number) ? "palindromic" : "";
        String gapful = isGapfulNumber(number) ? "gapful" : "";
        String spy = isSpyNumber(number) ? "spy" : "";
        String sunny = isSunnyNumber(number) ? "sunny" : "";
        String square = isPerfectSquareNumber(number) ? "square" : "";

        String listProperties = Stream.of(even, odd, buzz, duck, palindromic, gapful, spy, sunny, square) //
                .filter(str -> str != null && !str.isEmpty())
                .collect(Collectors.joining(", "));
        return (number + " is " + listProperties);
    }

    public boolean hasProperty(long number, String property) {
        return switch (property) {
            case "duck" -> isDuckNumber(number);
            case "spy" -> isSpyNumber(number);
            case "even" -> isEvenNumber(number);
            case "odd" -> !isEvenNumber(number);
            case "gapful" -> isGapfulNumber(number);
            case "palindromic" -> isPalindromicNumber(number);
            case "buzz" -> isBuzzNumber(number);
            case "sunny" -> isSunnyNumber(number);
            case "square" -> isPerfectSquareNumber(number);
            default -> false;
        };
    }

    public boolean hasMutuallyExclusiveProperties(String property, String property2) {
        String[] exProp1 = {"even", "odd"};
        String[] exProp2 = {"duck", "spy"};
        String[] exProp3 = {"sunny", "square"};
        return Arrays.asList(exProp1).contains(property) && Arrays.asList(exProp1).contains(property2) ||
                Arrays.asList(exProp2).contains(property) && Arrays.asList(exProp2).contains(property2) ||
                Arrays.asList(exProp3).contains(property) && Arrays.asList(exProp3).contains(property2);

    }


}