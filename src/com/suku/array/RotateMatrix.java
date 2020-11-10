package com.suku.array;

public class RotateMatrix {

    // Time complexity O(n2) and space complexity O(1)
    static int[][] rotateMatrix(int [][] matrix) {
        // transpose the matrix
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for (int j = i; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //reverse the matrix
        for(int i=0; i<n; i++) {
            int start = 0;
            int end = n-1;

            while(start < end) {
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }

        return matrix;
    }

    // Time complexity O(n2) and space complexity O(1)
    static int[][] rotateMatrix1(int [][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n/2; i++){
            for(int j = i; j<n-1-i; j++){
                // save the top left
                int tmp = matrix[i][j];

                //move bottom left to top
                matrix[i][j] = matrix[n-1-j][i];

                //move bottom right to left
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];

                //move top right to bottom
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];

                //move top left to right top
                matrix[j][n-1-i] = tmp;
            }
        }

        return matrix;
    }

    // Function to print the matrix
    static void displayMatrix(int mat[][]) {
        int N = mat.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int N = 4;

        // Test Case 1
        int mat[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Tese Case 2
        /* int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
         */

        // Tese Case 3
        /*int mat[][] = {
                        {1, 2},
                        {4, 5}
                    };*/

        // displayMatrix(mat);

        rotateMatrix1(mat);

        // Print rotated matrix
        displayMatrix(mat);
    }
}
