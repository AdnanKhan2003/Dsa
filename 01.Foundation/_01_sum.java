public class _01_sum {
    public static double printSum(double... arr) {
        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(printSum(1, 2, 3));
        System.out.println(printSum(10));
        System.out.println(printSum());
        System.out.println(printSum(5, -5, 10, 20));
        System.out.println(printSum(100, 200, 300, 400));
        System.out.println(printSum(10, 23.20));
    }
}

// TC: O(1) + O(n)*O(1) + O(1) = O(n + 2) => O(n) linear
// SC: O(n..arr) (input ignore) + O(1) => O(1) Constant