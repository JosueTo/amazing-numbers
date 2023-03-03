package numbers;

public class NumberProcessor {
    public boolean isEvenNumber(long number) {
        return number % 2 == 0;
    }
    public boolean isBuzzNumber(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public boolean isDuckNumber(long number) {
        String input = Long.toString(number);
        return input.indexOf("0", 1) > 0;
    }

    public boolean isPalindromicNumber(long number) {
        String userNum = Long.toString(number);
        String numReversed = new StringBuilder(userNum).reverse().toString();
        return userNum.equals(numReversed);
    }

    public boolean isGapfulNumber(long number) {
        String[] userNum = Long.toString(number).split("");
        long divider = Long.parseLong(userNum[0] + userNum[userNum.length - 1]);
        return userNum.length >= 3 && number % divider == 0;
    }

    public boolean isSpyNumber(long number) {
        String[] userNum = Long.toString(number).split("");
        long sum = 0;
        long prod = 1;
        for (int i = 0; i < userNum.length; i++) {
            sum += Long.parseLong(userNum[i]);
            prod *= Long.parseLong(userNum[i]);
        }
        return sum == prod;
    }

    public boolean isSunnyNumber(long number) {
        long sqrt = (long) Math.sqrt(++number);
        return (sqrt * sqrt == number);
    }

    public boolean isPerfectSquareNumber(long number) {
        long sqrt = (long) Math.sqrt(number);
        return (sqrt * sqrt == number);
    }

    public boolean isJumpingNumber (long number) {
        String[] userNum = Long.toString(number).split("");
        if (userNum.length == 1) { return true;}

        for (int i = 0; i < userNum.length - 1; i++) {
            int currentPos = Integer.parseInt(userNum[i]);
            int nextPos = Integer.parseInt(userNum[i + 1]);
            if (Math.abs(currentPos - nextPos) != 1) {
                return false;
            }
        }
        return true;
    }
}
