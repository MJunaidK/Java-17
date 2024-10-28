public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {

        if (number < 0) {
            return -1;
        }

        int lastDigit = number % 10;  // use % 10 to get last digit in a number.
        while (number >= 10) {
            number /= 10;  // divide with 10 until there is 1 digit left (< 10) to get first digit.  This is also equivalent to number = number / 10.
        }

        int firstDigit = number; // this is not necessary, but this makes it clear that number is now the first digit.
        return firstDigit + lastDigit;
    }
}
