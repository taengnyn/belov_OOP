public class StringCalculator {
    public int add(String numbers) {
        {
            if (numbers.isEmpty()) {
                return 0;
            }

            String[] nums = numbers.split(",");
            if (nums.length > 2) {
                throw new IllegalArgumentException("Only two numbers are allowed");
            }

            int sum = 0;

            for (String num : nums) {
                sum += Integer.parseInt(num);
            }

            return sum;
        }
//        }catch (IllegalArgumentException e) {
//            System.out.println("Only two numbers are allowed");
//        }
//        return 0;
    }

    public static void main(String[] args){
        StringCalculator stringCalc = new StringCalculator();
        try {
            int nums = stringCalc.add("1,4");
            System.out.println(nums);
            nums = stringCalc.add("1,4,3");
            System.out.println(nums);
            } catch (Exception e) {
                System.err.println("An exception occurred: " + e.getMessage());
        }

    }
}