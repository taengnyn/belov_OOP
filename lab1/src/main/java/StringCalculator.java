import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // default delimiter
        if (numbers.startsWith("//")) {
            int endOfDelimiter = numbers.indexOf("\n");
            String custDelimiter = numbers.substring(2, endOfDelimiter);
            delimiter = Pattern.quote(custDelimiter);
            numbers = numbers.substring(endOfDelimiter + 1);
        }

        String regex = "[" + delimiter + "]+";
        Pattern pattern = Pattern.compile(regex);
        String[] nums = pattern.split(numbers);

        int sum = 0;
        StringBuilder negatives = new StringBuilder();
        for (String num : nums) {
            int intNum = Integer.parseInt(num);
            if (intNum < 0) {
                negatives.append(intNum).append(" ");
            }
            if(intNum <= 1000){
                sum += intNum;
            }
        }
        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
        return sum;
    }
}