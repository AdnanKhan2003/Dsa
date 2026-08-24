public class _09_power_of_two {
    public static boolean powerOfTwoOpt(int n) {
        if (n <= 0) return false;

        return (n & (n-1)) == 0;
    }

    public static boolean powerOfTwo(int n) {
        if(n == 1) return true;
        if(n <= 0 || n % 2 != 0) return false;

        return powerOfTwo(n/2);
    }

    public static void main(String[] args) {
        int n = 16;

        boolean result = powerOfTwo(n);
        boolean result2 = powerOfTwoOpt(n);
        System.out.println(result);
        System.out.println(result2);
    }
}

// Opt
// TC: O(1)
// SC: O(1)

// TC: O(log n)
// SC: O(log n)