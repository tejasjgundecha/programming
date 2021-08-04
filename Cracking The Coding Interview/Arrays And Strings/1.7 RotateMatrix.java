/**
 * 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

class RotateMatrix{
    public static void main(String[] args){

//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateBy90(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void rotateBy90(int[][] matrix){
        if(matrix==null || matrix.length!=matrix[0].length) return;

        int n = matrix.length;

        for(int layer=0; layer<n/2;layer++){

            int start = layer, end = n-layer-1;
            for(int index=start; index< end;index++){
                int temp = matrix[layer][index];
                matrix[layer][index] = matrix[end-index][layer];
                matrix[end-index][layer] = matrix[end][end-index];
                matrix[end][end-index] = matrix[layer+index][end];
                matrix[layer+index][end] = temp;
            }
        }
    }
}

/**
 *      1   2   3   4
 *      5   6   7   8
 *      9   10  11  12
 *      13  14  15  16
 */