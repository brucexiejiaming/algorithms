package class21;

public class mergeStones {
    public int minCost(int[] stones) {
        // Write your solution here.
        if (stones.length == 1) {
          return stones[0];
        }
        int len = stones.length;
        int[][] table = new int[len][len];
        int[][] subSum = new int[len][len];
        // 0 <= j <= i
        for (int i = 0; i < len; i++) {
          for (int j = i; j >= 0; j--) {
            if (i == j) {
                table[j][i] = 0;
                subSum[j][i] = stones[j];
            } else {
                subSum[j][i] = subSum[j][i - 1] + stones[i];
                table[j][i] = Integer.MAX_VALUE;
                for (int k = j; k + 1 <= i; k++) {
                    table[j][i] = Math.min(table[j][i], table[j][k] + table[k + 1][i] + subSum[j][i]);
                }
            }
          }
        }
        
        return table[0][len - 1];
    }
}
