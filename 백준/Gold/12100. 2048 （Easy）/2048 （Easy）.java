import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, mx = 0;    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board = new int[22][22];
    static int[][] board2 = new int[22][22];

    static void rotate() {
        int[][] tmp = new int[22][22];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tmp[i][j] = board2[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board2[i][j] = tmp[n-1-j][i];
            }
        }
    }
    static void tilt(int dir) {
        for(int i=0; i<dir; i++) rotate();
        for(int i=0; i<n; i++) {
            int[] tilted = new int[22];
            int idx = 0;
            for(int j=0; j<n; j++){
                if(board2[i][j] == 0) continue;
                if(tilted[idx] == 0) tilted[idx] = board2[i][j];
                else if(board2[i][j] == tilted[idx]) {
                    tilted[idx++] *= 2;
                }
                else{
                    tilted[++idx] = board2[i][j];
                }
            }
            for(int j=0; j<n; j++){
                board2[i][j] = tilted[j];
            }
        }

    }
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int tmp=0; tmp < (1 << 10); tmp++ ){
            int brute = tmp;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            for(int k=0; k<5; k++){
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    mx = Math.max(mx, board2[i][j]);
                }
            }
        }
        bw.write(mx+"");
        bw.flush();
        bw.close();
    }
}