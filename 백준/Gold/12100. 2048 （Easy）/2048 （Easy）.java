import java.io.*;
import java.util.*;

public class Main{
    static int[][] board1 = new int[21][21];
    static int[][] board2 = new int[21][21];
    static int n;

    static void rotate(){
        int[][] tmp = new int[21][21];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
            { tmp[i][j] = board2[i][j]; }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board2[i][j] = tmp[n-1-j][i];
            }
        }

    }

    static void tilt(int dir){
        for(int i=0; i<dir; i++) { rotate(); }
        for(int i=0; i<n; i++){
            int[] tilted = new int[21];
            for(int k=0; k<21; k++) { tilted[k] = 0; }
            int idx=0;
            for(int j=0; j<n; j++){
                if(board2[i][j] == 0) { continue; }
                if(tilted[idx] == 0) { tilted[idx] = board2[i][j]; }
                else if(tilted[idx] == board2[i][j]) { tilted[idx++] *= 2; }
                else { tilted[++idx] = board2[i][j]; }
            }
            for(int j=0; j<n; j++) { board2[i][j] = tilted[j]; }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mx = 0;
        for(int tmp=0; tmp<1024; tmp++){ //4^5 이므로
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    board2[i][j] = board1[i][j];
                }
            }
            int brute = tmp;
            for(int i=0; i<5; i++){
                int dir = brute%4;
                brute/=4;
                tilt(dir);
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mx = Math.max(mx,board2[i][j]);
                }
            }
        }
        bw.write(mx+"");
        bw.flush();
        bw.close();

    }
}