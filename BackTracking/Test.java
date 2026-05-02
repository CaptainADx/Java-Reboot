
import java.util.*;

public class Test{

    public static boolean isSafe(int row, int col, char[][] board){
        
        for(int prevCol = 0; prevCol<col; prevCol++){
            if(board[row][prevCol] == 'Q'){
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j >=0 ; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row, j=col; i<board.length && j >=0; i++, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }


    
    public static void solve(int col, ArrayList<ArrayList<String>> ans, char[][] board, int n){
        if(col == n){
            ArrayList<String> res = new ArrayList<>();
            for(int i=0; i<n; i++){
                res.add(new String(board[i]));
            }

            ans.add(res);
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                solve(col+1, ans, board, n);
                board[row][col] = '.';
            }
        }
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] ele : board){
            Arrays.fill(ele, '.');
        }

        
        printBoard(board);

        solve(0, ans, board, n);

        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(i).size(); j++){
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void printBoard(char[][] board){
        for(char[] ele : board){
            System.out.println(new String(ele));
        }
    }

    
}
