import java.io.*;

public class Main {
    public static final int MAX = 3 * 1024 + 2;
    static char[][] board = new char[MAX][MAX * 2];
    static void printStar(int n, int x, int y){
        board[x][y] = '*';
        board[x+1][y-1] = '*';
        board[x+1][y+1] = '*';
        for(int i=0; i<5; i++){
            board[x+2][y+i-2] = '*';
        }
        return;
    }
    static void func(int s, int x, int y) {
        if(s==3){
            printStar(s,x,y);
            return;
        }
        func(s/2,x,y);
        func(s/2,x+s/2,y-s/2);
        func(s/2,x+s/2,y+s/2);
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        n = Integer.parseInt(br.readLine());
        func(n, 0, n-1);
        for(int i=0; i<n; i++){
            for(int j=0; j<n*2-1; j++){
                if(board[i][j] == '*'){
                    bw.write('*');
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}