import java.util.HashSet;
import java.util.Set;

/**
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set
 * to 0.
 */

class ZeroMatrix {

    public static void main(String[] agrs) {
        int[][] matrix = {{1, 2, 3}, {0, 5, 6}, {7, 8, 9}};
        zeroMatrix(matrix);

        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void zeroMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        while (i < m || j < n) {
            if(j==n){
                i++;
                j=0;
            }
            if(i==m)
                break;
            if(matrix[i][j]==0){
                if(rowSet.contains(i)  || colSet.contains(j)){
                    j++;
                }
                else{
                    makeZeros(matrix, i, j, m, n);
                    rowSet.add(i);
                    colSet.add(j);
                    i++;
                    j++;
                }

            }
            else {
                j++;
            }
        }
    }

    static void makeZeros(int[][] matrix, int i, int j, int m, int n) {
        for (int col = 0; col < n; col++) {
            matrix[i][col] = 0;
        }
        for (int row = 0; row < m; row++) {
            matrix[row][j] = 0;
        }
    }
}