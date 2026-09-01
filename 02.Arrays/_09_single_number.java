import java.util.HashMap;

public class _09_single_number {
    public static int singleNumberBf(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for(int key : hm.keySet()) {
            if (hm.get(key) == 1) return key;
        }

        return -1;
    }

    public static int singleNumberOpt(int[] arr) {
        int xor = 0;

        for(int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        return xor;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3 };
        int unique = singleNumberBf(arr);
        // int unique = singleNumberOpt(arr);

        System.out.println(unique);
    }
}

// BF: 
// TC: O(N x log2M + M) 
// SC: O(m)

// Opt:
// TC: O(n)
// SC: O(1)