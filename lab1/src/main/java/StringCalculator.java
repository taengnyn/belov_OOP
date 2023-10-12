import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        {
            if (numbers.isEmpty()) {
                return 0;
            }
            String numbersString = numbers;
            String customDelimiter = ",|\n";
            if (numbers.startsWith("//"))
            {
                Matcher matcher = Pattern.compile("//(\\[.+\\])+\n").matcher(numbers);
                if (matcher.find()) {
                    customDelimiter = "";
                    String customDelimiters = matcher.group(1);

                    Matcher delimiterMatch = Pattern.compile("\\[(.*?)\\]").matcher(customDelimiters);
                    while (delimiterMatch.find()) {
                        if (!customDelimiter.isEmpty()) {
                            customDelimiter += "|";
                        }
                        customDelimiter += Pattern.quote(delimiterMatch.group(1));
                    }
                    numbersString = numbers.substring(numbers.indexOf("\n") + 1);
                }
                else {
                        throw new IllegalArgumentException("Invalid custom delimiter: " + customDelimiter);
                    }
            }

            String delimiterRegex = ",|\n";
            if (!customDelimiter.isEmpty()) {
                delimiterRegex += "|" + customDelimiter;
            }

            if (numbers.endsWith(customDelimiter) || numbers.endsWith("\n") || numbers.endsWith(",")) {
                throw new IllegalArgumentException("Wrong input format: " + numbers);
            }

            String[] numberArray = numbersString.split(delimiterRegex);
            StringBuilder negatives = new StringBuilder();
            int sum = 0;
            for (String i : numberArray) {
                int intNum = Integer.parseInt(i);
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
    /*public static void main(String[] args){
        StringCalculator stringCalc = new StringCalculator();
        try {
            int nums = stringCalc.add("1\n-25");
            System.out.println(nums);
            System.out.println();
            nums = stringCalc.add("?\n-1,4?3");
            System.out.println(nums);
        } catch (Exception e) {
            System.err.println("An exception occurred: " + e.getMessage());
        }

    }*/
}
