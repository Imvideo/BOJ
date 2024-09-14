//FAIL
import java.io.*;
import java.util.*;

public class Main{
    static int[][] board;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static void solve (int x, int y, int n) throws IOException{
        if(n==1) {
            bw.write(board[x][y]+"");
            return;
        }
        boolean zero = true;
        boolean one = true;

        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(board[i][j] == 1){
                    zero = false;
                }
                else{
                    one = false;
                }
            }
        }

        if(zero){
            bw.write(0+"");
        }
        else if(one){
            bw.write(1+"");
        }
        else{
            bw.write("(");
            solve(x,y,n/2);
            solve(x,y+n/2,n/2);
            solve(x+n/2,y,n/2);
            solve(x+n/2,y+n/2,n/2);
            bw.write(")");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            String[] lines = line.split("");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(lines[j]);            
            }
        }
        solve(0,0,n);
        bw.flush();
        bw.close();
    }
}