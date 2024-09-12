//fail
import java.io.*;
import java.util.*;

public class Main{
    static int[][] board;
    static int[] cnt = {0, 0, 0};

    static boolean check(int x, int y, int n){
        int num = 3;
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(board[x][y] != board[i][j]) return false;
            }
        }
        return true;
    }

    static void solve(int x, int y, int z){
        if(check(x, y, z)){
            cnt[board[x][y] + 1] += 1;
            return;
        }
        int n = z/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                solve(x+i*n, y+j*n, n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,0,n);
        for(int i=0; i<3; i++){
            bw.write(cnt[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
