public class _08_missing_number {
    public static int getMissingNumberOpt2(int[] arr) {
        int xor1 = 0;
        int xor2 = 0;

        for(int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ i;
            xor2 = xor2 ^ arr[i];
        }

        xor1 = xor1 ^ arr.length;
        return xor1 ^ xor2;
    }

    public static int getMissingNumberOpt1(int[] arr) {
        int n = arr.length;
        int totalSum = n * (n + 1) / 2;

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }

        return totalSum - sum;
    }
    
    public static int getMissingNumberBfs(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int flag = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == i) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 2 };
        // int missingNumber = getMissingNumberBfs(arr);
        // int missingNumber = getMissingNumberOpt1(arr);
        int missingNumber = getMissingNumberOpt2(arr);

        System.out.println(missingNumber);
    }
}

// BF:
// TC: O(n^2)
// SC: O(1)

// Opt1:
// TC: O(n)
// SC: O(1)

// Opt2:
// TC: O(n)
// SC: O(1)