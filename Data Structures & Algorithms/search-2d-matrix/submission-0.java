class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row_len =matrix.length;
        int col_len =matrix[0].length;

        int row=0;
        int col = col_len -1;

        while(row<row_len && col>=0) {
            int temp = matrix[row][col];

            if(temp>target) {
                col--;
            } else if(temp<target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
        
    }
}
