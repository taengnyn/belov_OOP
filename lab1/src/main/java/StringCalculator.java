public class StringCalculator {
    public int add(String numbers) {
        {
            if (numbers.isEmpty()) {
                return 0;
            }

            String[] nums = numbers.split(",");
            int sum = 0;

            for (String num : nums) {
                try {
                    int i = Integer.parseInt(num);
                    sum += i;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid input: '" + num + "' is not a valid number.");
                }
            }

            return sum;
        }

    }
}