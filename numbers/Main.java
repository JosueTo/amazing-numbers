package numbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        long number;
        do {
            System.out.println("Enter a request:");
            number = scan.nextLong();
            if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (number > 0){
                checkOddEvenNumber(number);
                checkBuzzNumber(number);
                checkDuckNumber(number);
                checkPalindromicNumber(number);
            }
        } while (number != 0);
    }

    public static void checkOddEvenNumber(long number) {
        boolean odd = true;
        boolean even = true;
        if (number % 2 == 0) {
            System.out.println("Properties of " + number);
            System.out.println("\teven: " + even);
            System.out.println("\todd: " + !odd);
        } else {
            System.out.println("Properties of " + number);
            System.out.println("\teven: " + !even);
            System.out.println("\todd: " + odd);

        }
    }
    public static void checkBuzzNumber(long number) {
        boolean buzz = true;
        if (number % 7 != 0 && number % 10 != 7) {
            System.out.println("\tbuzz: " + !buzz);
        } else if (number % 7 == 0 && number % 10 == 7) {
            System.out.println("\tbuzz: " + buzz);
        } else if (number % 7 == 0) {
            System.out.println("\tbuzz: " + buzz);
        } else {
            System.out.println("\tbuzz: " + buzz);
        }
    }

    public static void checkDuckNumber(long number) {
        boolean duck = false;
        String userNum = Long.toString(number);
        int i = 1;
        while (i < userNum.length() && !duck) {
            if (userNum.charAt(i) == '0') {
                 duck = true;
            }
            i++;
        }

        System.out.println("\tduck: " + duck);
    }

    public static void checkPalindromicNumber(long number) {
        boolean palindrome = true;
        String userNum = Long.toString(number);
        String numReversed = new StringBuilder(userNum).reverse().toString();

        if(userNum.equals(numReversed)) {
            System.out.println("\tpalindromic: " + palindrome);
        } else {
            System.out.println("\tpalindromic: " + !palindrome);
        }
    }
}
