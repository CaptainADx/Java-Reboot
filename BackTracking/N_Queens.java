import java.util.ArrayList;

public class N_Queens {

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check left row
        for (int j = col; j >= 0; j--) {
            if (board[row][j] == 'Q') return false;
        }

        // Check bottom-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void solve(int col, ArrayList<ArrayList<String>> ans, char[][] board, int n) {
        if (col == n) {
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(new String(board[i])); // Convert char[] to String
            }
            ans.add(res);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, ans, board, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, ans, board, n);

        // Print all solutions
        for (ArrayList<String> solution : ans) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
