import java.util.*;

public class nQueen {

    public static boolean isSafe(char[][] board, int row, int col){
        //Vertical Up check
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //Left Diagonal
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Right Diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] board){
        System.out.println("--------------CHESS BOARD--------------");
        for (char[] board1 : board) {
            for (int j = 0; j<board[0].length; j++) {
                System.out.print(board1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueens(char[][] board, int row){
        if(row == board.length){
            printBoard(board);
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j]='x';
            }
        }
        
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            char board[][] = new char[n][n];
            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    board[i][j] = 'x';
                }
            }
            
            nQueens(board, 0);
        }
    }
}
