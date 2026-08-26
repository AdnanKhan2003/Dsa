public class _03_reverse_string {
    public static void reverseString(char[] ch) {
        int start = 0;
        int end = ch.length - 1;

        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        String str = "Adnan";

        char[] charArr = str.toCharArray();

        reverseString(charArr);

        String reversedString = new String(charArr);

        System.out.println(reversedString);
    }
}

// TC: O(n)
// TC: O(1)
