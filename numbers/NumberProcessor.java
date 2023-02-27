package numbers;

public class NumberProcessor {
    public static boolean isEvenNumber(long number) {
        return number % 2 == 0;
    }
    public static boolean isBuzzNumber(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isDuckNumber(long number) {
        String input = Long.toString(number);
        return input.indexOf("0", 1) > 0;
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

    public static boolean isSpyNumber(long number) {
        String[] userNum = Long.toString(number).split("");
        long sum = 0;
        long prod = 1;
        for (int i = 0; i < userNum.length; i++) {
            sum += Long.parseLong(userNum[i]);
            prod *= Long.parseLong(userNum[i]);
        }
        return sum == prod ? true : false;
    }
}
