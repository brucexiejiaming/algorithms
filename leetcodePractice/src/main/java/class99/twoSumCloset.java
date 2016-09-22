package class99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class twoSumCloset {
    public List<Integer> closest(int[] array, int target) {
        // write your solution here
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        result.add(array[left]);
        result.add(array[right]);
        
        while (left < right) {
            if (array[left] + array[right] == target) {
                result.set(0, array[left]);
                result.set(1, array[right]);
                return result;
            } else if (array[left] + array[right] > target) {
                update(array, result, left, right, target);
                right--;
            } else {
                update(array, result, left, right, target);
                left++;
            }
        }
        
        return result;
    }

    public void update(int[] array, List<Integer> result, int left, int right, int target) {
        int presDis = Math.abs(result.get(0) + result.get(1) - target);
        int dis = Math.abs(array[left] + array[right] - target);
        if (presDis > dis) {
            result.set(0, array[left]);
            result.set(1, array[right]);
        }
    }
}
