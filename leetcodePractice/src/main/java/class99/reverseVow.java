package class99;

import java.util.*;

public class reverseVow {
    public String reverse(String input) {
        // Write your solution here.
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] inputs = input.toCharArray();
        int i = 0, j = inputs.length - 1;
        
        while (i < j) {
            if (!set.contains(inputs[i])) {
                i++;
            } else if (!set.contains(inputs[j])) {
                j--;
            } else {
                swap(inputs, i, j);
                i++;
                j--;
            }
        }
        return new String(inputs);
    }
    
    public void swap(char[] input, int left, int right) {
        char tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }
}
