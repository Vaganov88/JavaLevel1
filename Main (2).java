import java.util.Arrays;

public class Main {
    public static void invert () {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                nums[i] += 1;
            }   else {
                nums[i] -= 1;
            }
        }
        System.out.println(Arrays.toString(nums));
    } // 1. First task



    public static void progression() {
        int[] numbs = new int[8];
            for (int i = 0; i < numbs.length; i++) {
            numbs[i] = (i * 3) ;
    }System.out.println(Arrays.toString(numbs));
}  // 2. Second task


    public static void mult6By2() {
        int[] numbrs = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < numbrs.length; i++) {
                if (numbrs[i] < 6) {
                    numbrs[i] *= 2;
                }
                }
                System.out.println(Arrays.toString(numbrs));
            } // 3. Third task

    public static void twoDimensionalArray() {
        int [][] table = new int [ 4 ][ 4 ];
for ( int i = 0 ; i < 4 ; i ++) {
        for ( int j = 0 ; j < 4 ; j ++) {
            if (i == j) {
                table[i][j] = 1;
            } else {
                table[i][j] = 0;
            }
            System . out . print ( table [ i ][ j ] + " " );
            }System . out . println ();
    }
} // 4. Fourth task


    public static void minMax () {
        int[] nums = {4, 5, 1, 9, 2};
        int currentMin = nums[0];
        int currentMax = nums [1];
                for (int i = 1; i < nums.length; i++) {
                if (currentMin > nums[i]) {
                     currentMin = nums[i];
                    } else if (currentMax < nums[i]) {
                    currentMax = nums[i];
                }

                } System.out.println("min " +currentMin);
        System.out.println("max " +currentMax);


                } //5. Fifth task










    public static void main(String[] args) {
     invert();
     progression();
     mult6By2();
     twoDimensionalArray();
     minMax();
     



        }
}



