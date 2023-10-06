public class StringCalculator {
    public int add(String numbers) {
        {
            if (numbers.isEmpty()) {
                return 0;
            }

            if (!numbers.matches("\\d+([,\n]\\d+)*")) {
                throw new IllegalArgumentException("Wrong input: " + numbers);
            }

            String[] nums = numbers.split("[,|\n]+");
            int sum = 0;

            for (String i : nums) {
                sum += Integer.parseInt(i);
            }
            return sum;
        }

    }
}