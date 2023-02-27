package numbers;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static int inputLen;
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        Scanner scan =  new Scanner(System.in);
        printInstructions();
        long num;
        do {
            System.out.println("Enter a request:");
            String request = scan.nextLine();
            while (request.isBlank()) {
                printInstructions();
                System.out.println("Enter a request:");
                request = scan.nextLine();
            }

            String[] params = request.split(" ");
            num = Long.parseLong(params[0]);
            inputLen = params.length;
            Printer printer = new Printer();
            switch (inputLen) {
                case 1:
                    printer.printProperties(num);
                    break;
                case 2:
                    int listLen = Integer.parseInt(params[1]);
                    printer.printProperties(num, listLen);
                    break;
                case 3:
                    listLen = Integer.parseInt(params[1]);
                    String property = params[2];
                    printer.printProperties(num, listLen, property);
                default:
                    break;
            }
        } while (num != 0);
        System.out.println("Goodbye!");
    }


    public  static void printInstructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("\t* the first parameter represents a starting number;");
        System.out.println("\t* the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

}
