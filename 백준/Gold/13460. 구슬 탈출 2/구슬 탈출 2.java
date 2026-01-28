import java.io.*;
import java.util.*;

class Tuple{
    int rx, ry, bx, by;
    Tuple(int rx, int ry, int bx, int by){
        this.rx = rx; this.ry = ry; this.bx = bx; this.by = by;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, mn = 11, redX, redY, blueX, blueY;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] board = new char[12][12];
    static int[][][][] dist = new int[12][12][12][12];
    
    static int bfs(){
        int rx = redX, ry = redY, bx = blueX, by = blueY;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(rx, ry, bx, by));
        dist[rx][ry][bx][by] = 0;
        while(!q.isEmpty()){
            Tuple cur = q.poll();
            int cnt = dist[cur.rx][cur.ry][cur.bx][cur.by];
            if(cnt >= 10) return -1;
            for(int d=0; d<4; d++){
                int nrx = cur.rx, nry = cur.ry, nbx = cur.bx, nby = cur.by;

                while(board[nbx + dx[d]][nby + dy[d]] == '.') { // till blue
                    nbx += dx[d]; nby += dy[d];
                }
                if(board[nbx + dx[d]][nby + dy[d]] == 'O') continue;

                while(board[nrx + dx[d]][nry + dy[d]] == '.') { // till red
                    nrx += dx[d]; nry += dy[d];
                }
                if(board[nrx + dx[d]][nry + dy[d]] == 'O') return cnt+1;

                if(nrx == nbx && nry == nby){
                    if(d==0){
                        if(cur.rx < cur.bx) nbx++;
                        else nrx++;
                    } else if(d == 1){
                        if(cur.ry < cur.by) nry--;
                        else nby--;
                    } else if(d == 2){
                        if(cur.rx < cur.bx) nrx--;
                        else nbx--;
                    } else {
                        if(cur.ry < cur.by) nby++;
                        else nry++;
                    }
                }
                if(dist[nrx][nry][nbx][nby] != -1) continue;
                q.add(new Tuple(nrx, nry, nbx, nby));
                dist[nrx][nry][nbx][nby] = cnt + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                for(int k=0; k<11; k++){
                    for(int l=0; l<11; l++){
                        dist[i][j][k][l] = -1;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R') {
                    redX = i; redY = j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'B') {
                    blueX = i; blueY = j;
                    board[i][j] = '.';
                }
            }
        }

        bw.write(bfs()+"");
        bw.flush();
        bw.close();
    }
}
