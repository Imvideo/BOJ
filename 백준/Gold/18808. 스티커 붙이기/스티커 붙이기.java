import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, k, r, c;
    static int[][] board = new int[42][42];
    static int[][] sticker = new int[12][12];

    static boolean canPatch(int x, int y){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(sticker[i][j] == 1 && board[x+i][y+j] == 1) return false;
            }
        }
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(sticker[i][j] == 1) board[x+i][y+j] = 1;
            }
        }
        return true;
    }

    static boolean patch(){
        for(int i=0; i<=n-r; i++){
            for(int j=0; j<=m-c;j++){
                if(canPatch(i,j)) return true;;
            }
        }
        return false;
    }

    static void rotate(){
        int[][] tmp = new int[12][12];
        for(int i=0;i<r;i++){
            for(int j=0; j<c; j++){
                tmp[j][r-i-1] = sticker[i][j];
            }
        }
        int temp = r; r = c; c = temp;
        for(int i=0;i<r;i++){
            for(int j=0; j<c; j++){
                sticker[i][j] = tmp[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int t=0; t<k; t++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            for(int i=0; i<r; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<4; i++){
                if(i!=0) rotate();
                if(patch()) break;
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 1) cnt++;
            }
        }
        bw.write(cnt+"\n");
        
        bw.flush();
        bw.close();
    }
}