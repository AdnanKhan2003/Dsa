public class _07_binary_search {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == arr[mid]) return mid;
            else if(target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 8;

        int result = binarySearch(arr, target);
        System.out.println(result);
    }
}

// TC: O(log N)
// SC: O(1)