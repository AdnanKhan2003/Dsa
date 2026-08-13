public class _04_Reverse_Integer {
    public static int reverseInt(int x) {
        int reverseNumber = 0;

        while(x != 0) {
            int lastDigit = x % 10;
            x /= 10;
            if(reverseNumber > Integer.MAX_VALUE/10 || reverseNumber == Integer.MAX_VALUE/10) {
                return 0;
            }

            if(reverseNumber < Integer.MIN_VALUE/10 || reverseNumber == Integer.MIN_VALUE/10) {
                return 0;
            }

            reverseNumber = (reverseNumber * 10) + lastDigit;
            
        }

        return reverseNumber;
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
