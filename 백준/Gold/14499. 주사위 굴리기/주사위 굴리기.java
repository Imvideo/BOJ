import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, x, y, k;    
    static int[] dice = new int[7];
    static int[][] board = new int[22][22];
    static int[][] idx = {
        {},
        {6,3,1,4},
        {6,4,1,3},
        {6,2,1,5},
        {6,5,1,2}
    };

    static void score(int d){
        int[] tmp = new int[7];
        for(int i=1; i<=6; i++) tmp[i] = dice[i];
        for(int i=0; i<4; i++){
            tmp[idx[d][i]] = dice[idx[d][(i+1)%4]];
        }
        for(int i=1; i<=6; i++) dice[i] = tmp[i];

    }
    static void roll (int d) throws IOException{
        int nx = x, ny = y;
        if(d == 1) ny++;
        else if(d == 2) ny--;
        else if(d == 3) nx--;
        else nx++;

        if(nx < 0 || nx >= n || ny < 0 || ny >= m) return;
        x = nx; y = ny;
        score(d);
        if(board[x][y] == 0) board[nx][ny] = dice[6];
        else{
            dice[6] = board[nx][ny];
            board[nx][ny] = 0;
        }
        bw.write(dice[1]+"\n");
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
            roll(Integer.parseInt(st.nextToken()));
        }
        bw.flush();
        bw.close();
    }
}