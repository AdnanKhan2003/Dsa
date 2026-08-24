import java.util.ArrayList;

public class _08_merge_sort {
    public static void merge(int[] arr, int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = start;
        int right = mid + 1;

        while(left <= mid && right <= end) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while(right <= end) {
            temp.add(arr[right]);
            right++;
        }

        for(int i = start; i <= end; i++) {
            arr[i] = temp.get(i - start);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public static void main(String[] args) {
        int[] arr = { 2, 3, 12, 22, 23, 1, 3, 2, 4, 6, 8 };
        int start = 0;
        int end = arr.length - 1;

        mergeSort(arr, start, end);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// TC: O(N logN)
// SC: O(N)