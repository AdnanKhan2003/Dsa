import java.util.Arrays;

public class _07_largest_number {
    public static int findLargestBf(int[] arr) {
        int largestDigit = Integer.MIN_VALUE;

        if(arr == null || arr.length == 0) return largestDigit;

        Arrays.sort(arr);

        largestDigit = arr[arr.length - 1];

        return largestDigit;
    }

    public static int findLargestOpt(int[] arr) {
        int largestDigit = Integer.MIN_VALUE;

        if(arr == null || arr.length == 0) return largestDigit;

        largestDigit = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largestDigit) largestDigit = arr[i];
        }

        return largestDigit;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 3, 6 };
        int[] arr2 = { 4, 5, 3, 8 };

        System.out.println("BF: " + findLargestBf(arr));
        System.out.println("BF: " + findLargestBf(arr2));

        System.out.println("Opt: " + findLargestOpt(arr));
        System.out.println("Opt: " + findLargestOpt(arr2));
    }
}

// BF:
// TC: O(N log N)
// SC: O(1)

// Opt:
// TC: O(N)
// SC: O(1)