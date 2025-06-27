import java.io.*;
import java.util.*;

public class Main {
    static int[] cnt = {0, 0};

    static boolean check(int x, int y, int n){
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(board[x][y] != board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    static void solve(int x, int y, int z){
        if(check(x,y,z)){
            cnt[board[x][y]]++;
            return;
        }
        int n = z/2;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                solve(x+i*n, y+j*n,n);
            }
        }
    }
    static int[][] board;
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
        bw.write(cnt[0]+"\n");
        bw.write(cnt[1]+"\n");
        bw.flush();
        bw.close();
    }
}