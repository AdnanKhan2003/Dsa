import java.util.HashSet;
import java.util.Arrays;

public class _01_remove_duplicates {
    public static int removeDuplicatesOpt(int[] arr) {
        int i = 0;

        for(int j = i + 1; j < arr.length; j++) {
            if(arr[i] != arr[j]) {
                arr[i+1] = arr[j];
                i++;
            }
        }

        return i+1;
    }

    public static int removeDuplicatesBf1(int[] arr) {
        HashSet<Integer> st = new HashSet<>();
        
        int i = 0;
        for(int num : arr) {
            if(!st.contains(num)) {
                st.add(num);
                arr[i] = num;
                i++;
            }
        }

        return i;
    }

    public static void removeDuplicatesBf2(int[] arr) {
        HashSet<Integer> st = new HashSet<>();

        for(int num : arr) {
            st.add(num);
        }

        int i = 0;
        for(int num : st) {
            arr[i] = num;
            i++;
        }

        for(int j = 0; j < i; j++) {
            System.out.print(arr[j] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3, 4, 7, 9, 4, 9 };

        // removeDuplicatesBf2(arr);

        // int uniqueCount = removeDuplicatesBf1(arr);
        // for(int i = 0; i < uniqueCount; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        Arrays.sort(arr);
        int uniqueCountOpt = removeDuplicatesOpt(arr);
        for(int i = 0; i < uniqueCountOpt; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// BF:
// TC: O(n)
// SC: O(n)

// Opt:
// TC: O(n)
// SC: O(1)