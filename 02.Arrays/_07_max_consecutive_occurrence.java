public class _07_max_consecutive_occurrence {
    public static int getMaximumOccurrence(int[] arr) {
        int count = 0;
        int maxS = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            maxS = Math.max(count, maxS);
        }

        return maxS;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        
        int maximumOccurrence = getMaximumOccurrence(arr);
        System.out.println(maximumOccurrence);
    }
}

// TC: O(n)
// SC: O(1)