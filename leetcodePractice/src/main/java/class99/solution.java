package class99;

import java.util.Arrays;import java.util.Collections;

public class solution {
    public static void main(String[] args) {
//        reverseWordsInString soln = new reverseWordsInString();
//        System.out.println("|" + soln.reverseWords("    an   apple    ") + "|");
        
//        arrayHopperIII soln = new arrayHopperIII();
//        int[] input = new int[]{1};
//        System.out.println(Arrays.toString(input));
//        System.out.println(soln.minJump(input));
        
//        twoSumCloset soln = new twoSumCloset();
//        for(Integer num : (soln.closest(new int[]{-1, 0, 1},  0))) {
//            System.out.println(num);
//        }
        
//        decomparessString soln =  new decomparessString();
//        System.out.println(soln.decompress("ac2d3ef"));
        grid soln = new grid();
        int[][] aGrid = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(soln.uniquePathsWithObstacles(aGrid));
    }

}
