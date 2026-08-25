public class _02_remove_elements {
    public static int removeAllOccurenceOf(int[] arr, int target) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != target) {
                arr[k] = arr[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 2, 9, 2 };
        int target = 2;

        int count = removeAllOccurenceOf(arr, target);
        System.out.println(count);
    }
}

// TC: O(n)
// SC: O(1)