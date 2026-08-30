public class _06_move_zeros_to_end {
    public static void moveZerosToEndOpt(int[] arr) {
        int j = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }

        if(j == -1) return;

        for(int i = j + 1; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void moveZerosToEnd(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                temp[index] = arr[i];
                index++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }        
    }
    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, 4, 0, 9, 5 };

        moveZerosToEndOpt(arr);

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}

// BF:
// TC: O(n)
// SC: O(n)

// Opt:
// TC: O(n)
// SC: O(1)