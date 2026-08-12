public class _03_palindrome {
    public static boolean isPalindrome(int n) {
        int dup = n;
        int reverseNumber = 0;

        while(n > 0) {
            int lastDigit = n % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            n /= 10;
        }

        if(dup == reverseNumber) return true;
        else return false;
    }
    public static void main(String[] args) {
        int a = 121;
        int b = -121;
        int c = 10;

        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(c));
    }
}

// TC: O(log10(n))
// SC: O(1)