import java.text.NumberFormat;
import java.util.Locale;

public class CommaAdder {
    
    public String addCommas(String number) {

        String numberString = number;

        // Convert the string to a long (or double) if it represents a numeric value
        long numberLong = Long.parseLong(numberString);

        // Format the number with commas
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String formattedNumber = numberFormat.format(numberLong);

        return formattedNumber;
    }
}
