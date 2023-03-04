package numbers;

import java.util.ArrayList;
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
            System.out.println("\tjumping: " + isJumpingNumber(number));
            System.out.println("\thappy: " + isHappyNumber(number));
            System.out.println("\tsad: " + !isHappyNumber(number));
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
        String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny",
                "square", "jumping", "happy", "sad"};
        String[] negativeProperties = {"-even", "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-sunny",
                "-square", "-jumping", "-happy", "-sad"};
        String prop = property.toLowerCase();

        if (!Arrays.asList(properties).contains(prop) && !Arrays.asList(negativeProperties).contains(prop)) {
            System.out.println("The property " + "[" + prop.toUpperCase() + "]" + " is wrong.\n" +
                    "Available properties: " + Arrays.toString(properties).toUpperCase());
        } else {
            int count = 0;
            while (count < listLen) {
                if (prop.charAt(0) == '-' && !hasProperty(number, prop.substring(1))) {
                    System.out.println(propList(number));
                    count++;
                }
                if (hasProperty(number, prop)) {
                    System.out.println(propList(number));
                    count++;
                }
                number++;
            }
        }
    }

    public void printProperties(long number, int listLen, String[] properties) {
        String[] validProperties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny",
                "square", "jumping", "happy", "sad"};
        String[] negativeProperties = {"-even", "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-sunny",
                "-square", "-jumping", "-happy", "-sad"};
        int invalidProp = 0;
        ArrayList<String> invalidPropList = new ArrayList<>();

        for (String property : properties) {
            if (!Arrays.asList(validProperties).contains(property.toLowerCase()) &&
                    !Arrays.asList(negativeProperties).contains(property.toLowerCase())) {
                invalidProp++;
                invalidPropList.add(property);
            }
        }

        switch (invalidProp) {
            case 0:
                for (int i = 0; i < properties.length - 1; i++) {
                    for (int j = i + 1; j < properties.length; j++) {
                        if (hasMutuallyExclusiveProperties(properties[i], properties[j])) {
                            System.out.println("The request contains mutually exclusive properties: [" +
                                    properties[i].toUpperCase() + ", " + properties[j].toUpperCase() + "]\n" +
                                    "There are no numbers with these properties.");
                            return;
                        }
                    }
                }
                int count = 0;
                while (count < listLen) {
                    int countProp = 0;
                    for (int i = 0; i < properties.length; i++) {
                        if (properties[i].charAt(0) == '-' && !hasProperty(number, properties[i].substring(1))) {
                            countProp += 1;
                        }
                        if (hasProperty(number, properties[i])) {
                            countProp += 1;
                        }
                    }
                    if (countProp == properties.length) {
                        System.out.println(propList(number));
                        count++;
                    }
                    number++;
                }
                break;
            case 1:
                System.out.println("The property " + invalidPropList.toString().toUpperCase() + " is wrong.\n" +
                        "Available properties: " + Arrays.toString(validProperties).toUpperCase());
                break;
            default:
                System.out.println("The properties " + invalidPropList.toString().toUpperCase() + " are wrong.\n" +
                        "Available properties: " + Arrays.toString(validProperties).toUpperCase());
                break;
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
        String jumping = isJumpingNumber(number) ? "jumping" : "";
        String happy = isHappyNumber(number) ? "happy" : "";
        String sad = !isHappyNumber(number) ? "sad" : "";

        String listProperties = Stream.of(even, odd, buzz, duck, palindromic, gapful, spy, sunny, square,
                        jumping, happy, sad)
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
            case "jumping" -> isJumpingNumber(number);
            case "happy" -> isHappyNumber(number);
            case "sad" -> !isHappyNumber(number);
            default -> false;
        };
    }

    public boolean hasMutuallyExclusiveProperties(String property, String property2) {
        if (property.equals(property2)) { return false; }
        if (property.equals(property2.substring(1)) || property2.equals(property.substring(1))) {
            return true;
        }

        String[] exProp1 = {"even", "odd"};
        String[] exProp2 = {"duck", "spy"};
        String[] exProp3 = {"sunny", "square"};
        String[] exProp4 = {"happy", "sad"};
        String[] exProp5 = {"-even", "-odd"};
        String[] exProp6 = {"-duck", "-spy"};
        String[] exProp7 = {"-sunny", "-square"};
        String[] exProp8 = {"-happy", "-sad"};
        return Arrays.asList(exProp1).contains(property) && Arrays.asList(exProp1).contains(property2) ||
                Arrays.asList(exProp2).contains(property) && Arrays.asList(exProp2).contains(property2) ||
                Arrays.asList(exProp3).contains(property) && Arrays.asList(exProp3).contains(property2) ||
                Arrays.asList(exProp4).contains(property) && Arrays.asList(exProp4).contains(property2) ||
                Arrays.asList(exProp5).contains(property) && Arrays.asList(exProp5).contains(property2) ||
                Arrays.asList(exProp6).contains(property) && Arrays.asList(exProp6).contains(property2) ||
                Arrays.asList(exProp7).contains(property) && Arrays.asList(exProp7).contains(property2) ||
                Arrays.asList(exProp8).contains(property) && Arrays.asList(exProp8).contains(property2);

    }


}