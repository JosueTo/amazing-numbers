package numbers;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static int len;
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        printInstructions();
        long num;
        do {
            System.out.println("Enter a request:");
            String userInput = scan.nextLine();

            if (userInput.isBlank()){
                printInstructions();
            }
            String[] params = userInput.split(" ");
            num = Long.parseLong(params[0]);
            len = params.length;
            if (num < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (num > 0){
                if (len == 1) {
                    printProperties(num);
                } else {
                    if (Long.parseLong(params[1]) < 0) {
                        System.out.println("The second parameter should be a natural number.");
                    } else {
                        for (int i = 0; i < Long.parseLong(params[1]); i++) {
                            printProperties(num++);
                        }
                    }
                }
            }
        } while (num != 0);
//        System.out.println("Goodbye!");
    }


    public  static void printInstructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("\t* the first parameter represents a starting number;");
        System.out.println("\t* the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    public static void printProperties(long number) {
        if (len == 1) {
            System.out.println("Properties of " + number);
            System.out.println("\teven: " + isEvenNumber(number));
            System.out.println("\todd: " + !isEvenNumber(number));
            System.out.println("\tbuzz: " + isBuzzNumber(number));
            System.out.println("\tduck: " + isDuckNumber(number));
            System.out.println("\tpalindromic: " + isPalindromicNumber(number));
            System.out.println("\tgapful: "  + isGapfulNumber(number));
        } else {
            String even = isEvenNumber(number) ? "even" : "";
            String odd = !isEvenNumber(number) ? "odd" : "";
            String buzz = isBuzzNumber(number) ? "buzz" : "";
            String duck = isDuckNumber(number) ? "duck" : "";
            String palindromic = isPalindromicNumber(number) ? "palindromic" : "";
            String gapful = isGapfulNumber(number) ? "gapful" : "";

            String listProperties = Stream.of(even, odd, buzz, duck, palindromic, gapful)
                    .filter(str -> str != null && !str.isEmpty())
                    .collect(Collectors.joining(", "));
            System.out.println(number + " is " + listProperties);
        }

    }

    public static boolean isEvenNumber(long number) {
        return number % 2 == 0;
    }
    public static boolean isBuzzNumber(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isDuckNumber(long number) {
        String input = Long.toString(number);
        return input.indexOf("0", 1) > 0 ? true : false;
    }

    public static boolean isPalindromicNumber(long number) {
        String userNum = Long.toString(number);
        String numReversed = new StringBuilder(userNum).reverse().toString();
        return userNum.equals(numReversed);
    }

    public static boolean isGapfulNumber(long number) {
        String[] userNum = Long.toString(number).split("");
        long divider = Long.parseLong(userNum[0] + userNum[userNum.length - 1]);
        return userNum.length >= 3 && number % divider == 0;
    }
}
