package class21;

public class rainbowIISort {
    public int[] rainbowSortIII(int[] array, int k) {
        // Write your solution here.
        int count = 0;
        int left = 0;
        int right = array.length - 1;
        
        while (count + 1 < k) {
          // sort two color very time
          int min = Integer.MAX_VALUE;
          int max = Integer.MIN_VALUE;
          
          for (int i = left; i <= right; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
          }
          int localLeft = left;
          int localRight = right;
          int i = localLeft;
          while (i <= localRight) {
            if (array[i] == min) {
              swap(array, i++, localLeft++);
            } else if (array[i] == max) {
              swap(array, i, localRight--);
            } else {
              i++;
            }
          }
          count += 2;
          left = localLeft;
          right = localRight;
        }
        
        return array;
      }
      
      public void swap (int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
      }
}
