public class _04_Reverse_Integer {
    public static int reverseInt(int x) {
        int n = Math.abs(x);
        int reverseNumber = 0;

        while(n > 0) {
            int lastDigit = n % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            n /= 10;
        }

        if(reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE) return 0;
        else return x > 0 ? reverseNumber : -reverseNumber;
    }
    public static void main(String[] args) {
        int a = 123;
        int b = -123;
        int c = Integer.MAX_VALUE+1;
        int d = Integer.MIN_VALUE-1;

        System.out.println(reverseInt(a));
        System.out.println(reverseInt(b));
        System.out.println(reverseInt(c));
        System.out.println(reverseInt(d));
    }
}
