import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, min=9999999;
    static char board[][] = new char[51][51];
    static int chkWhite(int x, int y){
        int cnt = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2==0 && j%2==0){
                    if(board[x+i][y+j]!='W') cnt++;
                }
                if(i%2==1 && j%2==0){
                    if(board[x+i][y+j]!='B') cnt++;
                }
                if(i%2==0 && j%2==1){
                    if(board[x+i][y+j]!='B') cnt++;
                }
                if(i%2==1 && j%2==1){
                    if(board[x+i][y+j]!='W') cnt++;
                }
            }
        }
        return cnt;
    }

    static int chkBlack(int x, int y){
        int cnt = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2==0 && j%2==0){
                    if(board[x+i][y+j]!='B') cnt++;
                }
                if(i%2==1 && j%2==0){
                    if(board[x+i][y+j]!='W') cnt++;
                }
                if(i%2==0 && j%2==1){
                    if(board[x+i][y+j]!='W') cnt++;
                }
                if(i%2==1 && j%2==1){
                    if(board[x+i][y+j]!='B') cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j);
            }
        }
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                min = Math.min(min, Math.min(chkWhite(i, j), chkBlack(i, j)));
            }
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
    }
}