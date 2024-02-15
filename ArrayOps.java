public class ArrayOps {

    public static void main(String[] args) {
        System.out.println(findMissingInt(new int[]{3, 0, 1}));
        System.out.println(findMissingInt(new int[]{0, 1, 2, 3, 4, 6}));
        System.out.println(findMissingInt(new int[]{0}));
        System.out.println(secondMaxValue(new int[]{6, 9, 4, 7, 3, 4}));
        System.out.println(secondMaxValue(new int[]{1, 2, 3, 4, 5}));
        System.out.println(secondMaxValue(new int[]{2, 8, 3, 7, 8}));
        System.out.println(secondMaxValue(new int[]{1, -2, 3, -4, 5}));
        System.out.println(secondMaxValue(new int[]{-202, 48, 13, 7, 8}));
        System.out.println(containsTheSameElements(new int[]{1, 2, 1, 1, 2}, new int[]{2, 1}));
        System.out.println(containsTheSameElements(new int[]{2, 2, 3, 7, 8, 3, 2}, new int[]{8, 2, 7, 7, 3}));
        System.out.println(containsTheSameElements(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(containsTheSameElements(new int[]{3, -4, 1, 2, 5}, new int[]{1, 3, -4, 5}));
        System.out.println(isSorted(new int[]{7, 5, 4, 3, -12}));
        System.out.println(isSorted(new int[]{1, 2, 3}));
        System.out.println(isSorted(new int[]{1, -2, 3}));
        System.out.println(isSorted(new int[]{1, 1, 500}));
        System.out.println(isSorted(new int[]{1, 3, 2}));
    }

    public static int findMissingInt(int[] array) {
        int n = array.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        // sums the array
        for (int num : array) {
            actualSum += num;
        }
        return expectedSum - actualSum; // the missing number
    }

    public static int secondMaxValue(int[] array) {
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
        
            for (int num : array) {
                // finds maximum number
                if (num > max) {
                    secondMax = max;
                    max = num;
                    // finds second maximum number
                } else if (num > secondMax && num != max) {
                    secondMax = num;
                }
            }
            return secondMax;
        }

    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        boolean identical = true;
        // checks for a match
        for (int num1 : array1) {
            boolean foundMatch = false;

            for (int num2 : array2) {
                if (num1 == num2) {
                    foundMatch = true;
                    break;
                }
            }

            // can't find a match
            if (!foundMatch) {
                identical = false;
                break;
            }
        }
        return identical;
    }

    public static boolean isSorted(int[] array) {
        int firstNum = array[0];
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                decreasing = false;
            } else if (array[i] < array[i - 1]) {
                increasing = false;
            }
            // not increasing or decreasing
            if (!increasing && !decreasing) {
                return false;
            }
        }

        // increasing or decreasing - the array is sorted
        return increasing || decreasing;
    }
}