import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int board[][] = new int[102][102];
    static int x1, y1, x2, y2, cnt=0;
    public static void main(String[] args) throws IOException {
        for(int t=0; t<4; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int i=y1; i<y2; i++){
                for(int j=x1; j<x2; j++){
                    board[i][j] = 1;
                }
            }
        }
        for(int i=0; i<100;i++){
            for(int j=0; j<100; j++){
                if(board[i][j] == 1) cnt++;
            }
        }
        bw.write(cnt+"");     
        bw.flush();
        bw.close();
    }
}