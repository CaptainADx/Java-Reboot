import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] board  = new char[n][n];

        for(char[] ele : board){
            Arrays.fill(ele, '.');
        }

        printBoard(board);
        System.out.println();
        System.out.println();


        n_queen(0, board, ans, n);

        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(i).size(); j++){
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
            System.out.println();
        }
    }

    private static void printBoard(char[][] board){
        
        for(char[] ele : board){
            System.out.println(new String(ele));
        }
    }

    private static void n_queen(int col, char[][] board, ArrayList<ArrayList<String>> ans, int n){
        if(col == n){
            ArrayList<String> res = new ArrayList<>();
            for(char[] ele : board){
                res.add(new String(ele));
            }
            ans.add(res);

            return;
        }

        for(int row=0; row < n; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                n_queen(col+1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board){

        // Horizontal Row Check
        for(int currCol = col; currCol >=0 ; currCol--){
            if(board[row][currCol] == 'Q'){
                return false;
            }
        }

        //Diagonal upward check
        for(int currRow=row, currCol=col; currRow>=0 && currCol>=0; currCol--, currRow--){
            if(board[currRow][currCol] == 'Q'){
                return false;
            }
        }

        //Diagonal Downward check

        for(int currRow=row, currCol = col; currRow<board.length && currCol>=0; currRow++, currCol--){
            if(board[currRow][currCol] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
