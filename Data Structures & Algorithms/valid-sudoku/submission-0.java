class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();

        for(int row =0; row<9; row++) {
            for(int col =0; col<9; col++) {
                if(board[row][col] == '.') continue;
                String first = "row["+row+"]"+board[row][col];
                String second = "column["+col+"]"+board[row][col];
                String third = "box["+row/3+"]"+"["+col/3+"]"+board[row][col];

                if(set.contains(first) || set.contains(second) || set.contains(third)) {
                    return false;
                }

                set.add(first);
                set.add(second);
                set.add(third);
            }
        }

        return true;
        
    }
}
