import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int n,m,k;
        public Node(int n,int m,int k){
            this.n = n;
            this.m = m;
            this.k = k;
        }
    }
    static void move(int n, int m, int k){
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Node> queue = new LinkedList<Node>();
        int[] dhx = {2,1,-1,-2,-2,-1,1,2};
        int[] dhy = {1,2,2,1,-1,-2,-2,-1};
        int[] dmx = {1,0,-1,0};
        int[] dmy = {0,1,0,-1};
        int[][][] vis = new int[32][202][202];
        int Kn = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for(int i=0; i<32; i++){
            for(int j=0; j<202; j++){
                Arrays.fill(vis[i][j], 0);
            }
        }

        //맵 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(new Node(0,0,0));
        vis[0][0][0] = 1;
        while (!queue.isEmpty()) {
            int vk, vx, vy;
            Node node = queue.poll();
            vk = node.k;
            vx = node.n;
            vy = node.m;
            // 말 이동
            if ( vk < Kn) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = vx + dhx[dir];
                    int ny = vy + dhy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (board[nx][ny] == 1)
                        continue;
                    if(vis[vk+1][nx][ny] > 0) continue;
                    vis[vk+1][nx][ny] = vis[vk][vx][vy] + 1;
                    queue.add(new Node(nx,ny,vk+1));
                }
            }
            // 원숭이 이동
            for (int dir = 0; dir < 4; dir++) {
                int nx = vx + dmx[dir];
                int ny = vy + dmy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (board[nx][ny] == 1)
                    continue;
                if(vis[vk][nx][ny] > 0) continue;
                vis[vk][nx][ny] = vis[vk][vx][vy] + 1;
                queue.add(new Node(nx,ny,vk));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<Kn + 1; i++){
            if(vis[i][n-1][m-1] > 0){
                ans = Math.min(ans, vis[i][n-1][m-1]);
            }
        }
        if(ans != Integer.MAX_VALUE) bw.write(ans-1+"");
        else bw.write(-1+"");
        bw.flush();
        bw.close();
    }
}