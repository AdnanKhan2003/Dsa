public class _05_Count_negative_arr {
    public static int countNegatives(int[] arr) {
        if(arr == null) return 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {12, -23, 43, -33, 23, -23};

        int result = countNegatives(arr);
        
        System.out.println(result);
    }
}

// TC: O(n)
// SC: O(n)
