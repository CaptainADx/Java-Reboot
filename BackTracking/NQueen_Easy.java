import java.util.*;

public class NQueen_Easy {
    private static boolean isSafe(int row, int col, char[][] board){
        for(int currCol = col; currCol >= 0; currCol--){
            if(board[row][currCol] == 'Q'){
                return false;
            }
        }

        for(int currRow = row, currCol = col; currRow>=0 && currCol>=0; currRow--, currCol--){
            if(board[currRow][currCol] == 'Q'){
                return false;
            }
        }

        for(int currRow=row, currCol = col; currRow<board.length && currCol>=0; currRow++, currCol--){
            if(board[currRow][currCol] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private static boolean solve(int currCol, char[][] board, int n){
        if(currCol == n){
            return true;
        }

        for(int row=0; row<n; row++){
            if(isSafe(row, currCol, board)){
                board[row][currCol] = 'Q';
                if(solve(currCol+1, board, n)) return true;
                board[row][currCol] = '.';
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        char[][] board  = new char[n][n];   

        for(char[] line : board){
            Arrays.fill(line, '.');
        }

        printBoard(board);

        if(solve(0, board, n)){
            printBoard(board);
        } else {
            System.out.println("No solution exist");
        }

    }

    private static void printBoard(char[][] board){

        for(char[] ele : board){
            System.out.println(new String(ele));
        }
    }
}
