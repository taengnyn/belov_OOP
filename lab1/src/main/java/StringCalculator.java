public class StringCalculator {
    public int add(String numbers) {
        {
            if (numbers.isEmpty()) {
                return 0;
            }

            String delimiter = "[,|\n]"; // default delimiter
            if (numbers.startsWith("//"))
            {
                delimiter = numbers.substring(2, numbers.indexOf("\n"));
                numbers = numbers.substring(numbers.indexOf("\n") + 1);
            }

            if (!numbers.matches("\\d+("+delimiter+"\\d+)*")) {
                throw new IllegalArgumentException("Wrong input: " + numbers);
            }
            int sum = 0;
            String[] nums = numbers.split(delimiter);
            for (String i : nums) {
                sum += Integer.parseInt(i);
            }
            return sum;
        }
    }
}