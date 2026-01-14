import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, x, y, k, r = 1, c = 1, upDix = 1, eastIdx = 3;
    static int[] dice = new int[7];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] board = new int[22][22];
    static int[][] idx = {
        {},
        {2,6,4,5},
        {2,5,4,6},
        {3,2,1,4},
        {2,3,4,1},
    };

    static void roll(int dir){
        int[] tmp = new int[7];
        for(int i=1; i<=6; i++) {
            tmp[i] = dice[i];
        }
        for(int i=0; i<4; i++) {
            tmp[idx[dir][i]] = dice[idx[dir][(i+1)%4]];
        }
        for(int i=1; i<=6; i++) {
            dice[i] = tmp[i];
        }
    }

    static void score(int d) throws IOException{
        int nx = x, ny = y;
        if(d==1) ++ny;
        else if(d == 2) --ny;
        else if(d == 3) --nx;
        else ++nx;

        if(OOB(nx,ny)) {
            x = nx; y = ny;
            roll(d);
            if(board[nx][ny] == 0) board[nx][ny] = dice[4];
            else{
                dice[4] = board[nx][ny];
                board[nx][ny] = 0;
            }
            bw.write(dice[2]+"\n");
        }
    }

    static boolean OOB(int nx, int ny) {
        if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
        return true;
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int dir = Integer.parseInt(st.nextToken());
            score(dir);
        }
        bw.flush();
        bw.close();
    }
}