//FAIL
import java.io.*;
import java.util.*;

public class Main{
    static char[][] board;

    static void solve(int n, int x, int y){
        if(n == 1){
            board[x][y] = '*';
            return;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i ==1 & j == 1) continue;
                solve(n/3, x+n/3*i, y+n/3*j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],' ');
        }
        solve(n, 0, 0);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}