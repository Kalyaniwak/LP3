import java.util.*;

public class NQueens {
    static int N;
    static int[][] board;

    static boolean safe(int r, int c) {
        for (int i = 0; i < N; i++)
            if (board[r][i] == 1 || board[i][c] == 1)
                return false;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if ((i + j == r + c || i - j == r - c) && board[i][j] == 1)
                    return false;

        return true;
    }

    static boolean solve(int n) {
        if (n == 0)
            return true;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (safe(i, j) && board[i][j] == 0) {
                    board[i][j] = 1;
                    if (solve(n - 1))
                        return true;
                    board[i][j] = 0;
                }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        N = sc.nextInt();
        board = new int[N][N];

        if (solve(N)) {
            for (int[] row : board) {
                for (int v : row)
                    System.out.print(v + " ");
                System.out.println();
            }
        } else
            System.out.println("No solution");
    }
}
