import java.util.Arrays;

public class _06_smallest_number {
    public static int findSmallestBf(int[] arr) {
        int smallestDigit = Integer.MAX_VALUE;
        if(arr == null || arr.length == 0) return smallestDigit;

        Arrays.sort(arr);

        smallestDigit = arr[0];

        return smallestDigit;
    }

    public static int findSmallestOpt(int[] arr) {
        int smallestDigit = Integer.MAX_VALUE;
        if(arr == null || arr.length == 0) return smallestDigit;

        smallestDigit = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < smallestDigit) {
                smallestDigit = arr[i];
            }
        }

        return smallestDigit;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 3, 6 };
        int[] arr2 = { 4, 5, 3, 6 };

        System.out.println("BF: " + findSmallestBf(arr));
        System.out.println("BF: " + findSmallestBf(arr2));

        System.out.println("Opt: " + findSmallestOpt(arr));
        System.out.println("Opt: " + findSmallestOpt(arr2));
    }
}

// BF:
// TC: O(N log N)
// SC: O(1)

// Opt:
// TC: O(N)
// SC: O(1)