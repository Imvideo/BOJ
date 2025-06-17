import java.io.*;
import java.util.*;

public class Main{
    static class Tuple{
        int h,w,k;
        public Tuple(int h, int w, int k){
            this.h = h;
            this.w = w;
            this.k = k;
        }
    }

    static int k,w,h;
    static int[][] board = new int[202][202];
    static int[][][] vis = new int[32][202][202];
    static int[] dxH = {1,2,2,1,-1,-2,-2,-1};
    static int[] dyH = {2,1,-1,-2,-2,-1,1,2};
    static int[] dxM = {1,0,-1,0};
    static int[] dyM = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        for(int z=0; z<=k; z++){
            for(int i=0; i<h; i++){
                Arrays.fill(vis[z][i], -1);
            }
        }

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Tuple> dq = new LinkedList<Tuple>();
        dq.addFirst(new Tuple(0,0,0));
        vis[0][0][0] = 0;
        boolean found = false;
        if (w == 1 && h == 1) {
            found = true;
            bw.write(0+"\n");
        }
        while(!dq.isEmpty() && !found){
            Tuple cur = dq.poll();
            if(cur.k < k){
                for(int dir=0; dir<8; dir++){
                    int nx = cur.h + dxH[dir];
                    int ny = cur.w + dyH[dir];
                    int nk = cur.k + 1;
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(vis[nk][nx][ny] > -1 || board[nx][ny] == 1) continue;
                    vis[nk][nx][ny] = vis[cur.k][cur.h][cur.w] + 1;
                    if(nx == h-1 && ny == w-1){
                        found = true;
                        bw.write(vis[nk][nx][ny]+"\n");
                        break;
                    }
                    dq.addLast(new Tuple(nx, ny, nk));
                }
            }
            for(int dir=0; dir<4; dir++){
                int nx = cur.h + dxM[dir];
                int ny = cur.w + dyM[dir];
                int nk = cur.k;
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if(vis[nk][nx][ny] > -1 || board[nx][ny] == 1) continue;
                vis[nk][nx][ny] = vis[cur.k][cur.h][cur.w] + 1;
                if(nx == h-1 && ny == w-1){
                    found = true;
                    bw.write(vis[nk][nx][ny]+"\n");
                    break;
                }
                dq.addLast(new Tuple(nx, ny, nk));
            }
        }
        
        // for(int z=0; z<=k; z++){
        //     for(int i=0; i<h; i++){
        //         for(int j=0; j<w; j++){
        //             bw.write(vis[z][i][j] + " ");
        //         }
        //         bw.write("\n");
        //     }
        //     bw.write("\n");
        // }

        if(!found) bw.write(-1+"\n");
        bw.flush();
        bw.close();
        
    }
}