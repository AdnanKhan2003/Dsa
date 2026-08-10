import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class _02_second_largest_bf {
    public static int getSecondLargest(String str) {
        List<Integer> digits = new ArrayList<>();
        
        for(char c: str.toCharArray()) {
            if(Character.isDigit(c)) {
                digits.add(c-'0');
            }
        }
        
        if(digits.isEmpty()) return -1;
        
        Collections.sort(digits);
        
        int largest = digits.get(digits.size() - 1);
        
        for(int i = digits.size() - 2; i >= 0; i--) {
            if(digits.get(i) < largest) {
                return digits.get(i);
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        String s = "dfa12321afd";
        String s2 = "abc1111";
        
        int result = getSecondLargest(s);
        int result2 = getSecondLargest(s2);
        System.out.println(result);
        System.out.println(result2);
    }
}

// TC: (toCharArray + loop + sort + backward loop) O(n) + O(n) + O(n log n) + O(n) => O(3n + n log n) => O(n log n)
// SC: (toCharArray + list) => O(n) + O(n) => O(2n) => O(n)