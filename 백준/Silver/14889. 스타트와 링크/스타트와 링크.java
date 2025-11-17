import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, mn = 999999999;
    static int[][] board = new int[22][22];
    static boolean[] visited = new boolean[22];
    static void func(int k, int idx){
        if(k==n/2){
            int a =0,b = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visited[i] && visited[j]) a += board[i][j];
                    else if (!visited[i] && !visited[j]) b += board[i][j];
                }
            }
            mn = Math.min(mn, Math.abs(a-b));
            return;
        }
        for(int i=idx; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            func(k+1, i);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0,0);
        bw.write(mn+"");
        bw.flush();
        bw.close();
    }
}