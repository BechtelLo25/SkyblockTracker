import java.text.NumberFormat;
import java.util.Locale;

public class Testing {
    public static void main(String[] args) {
        // Example number as a string
        String numberString = "1234567890";

        // Convert the string to a long (or double) if it represents a numeric value
        long number = Long.parseLong(numberString);

        // Format the number with commas
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String formattedNumber = numberFormat.format(number);

        // Display the result
        System.out.println("Original number: " + numberString);
        System.out.println("Formatted number: " + formattedNumber);
    }
}