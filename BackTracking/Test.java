import java.util.*;
public class Test{

    public static void printBoard(char[][] board){
        System.out.println("==================");
        for(char[] rows : board){
            for(char cell : rows){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("==================");
    }

    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the Board Size --> ");
            int n = sc.nextInt();

            while(n <= 0){
                System.out.println("Enter a valid board size ! ! !");
                n = sc.nextInt();
            }

            
            //Creating the board
            char[][] board = new char[n][n];

            for(char[] rows : board){
                Arrays.fill(rows, '.');
            }

            printBoard(board);
            
            if(solve(board, n, 0)){
                printBoard(board);
            } else {
                System.out.println("Not Possible");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        
    }

    private static boolean solve(char[][] board, int n, int currCol) {
        
        if(currCol == n) return true;

        for(int currRow = 0; currRow < n; currRow++){
            if(isSafe(currRow, currCol, board, n)){
                board[currRow][currCol] = 'Q';
                if(solve(board, n, currCol+1)) return true;
                board[currRow][currCol] = '.';
            }
        }
        
        return false;
    }

    private static boolean isSafe(int currRow, int currCol, char[][] board, int n) {

        //Left Row Check
        for(int col = 0; col < currCol; col++){
            if(board[currRow][col] == 'Q'){
                return false;
            }
        }

        //Upper diagonal check
        for(int row = currRow-1, col= currCol-1; row >= 0 && col >= 0; row--, col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }

        //Lower Diagonal Check
        for(int row = currRow+1, col = currCol-1;  row < n && col >= 0; row++, col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }


        return true;
    }

}
