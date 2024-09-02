import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int x,y,z;
        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][][] dist = new int[n][m][2];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        //맵 입력
        for(int i=0; i<n; i++){
            String line = br.readLine();
            String[] lines = line.split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(lines[j]);
            }
        }

        //거리 맵 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dist[i][j],-1);

            }
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0,0,0));
        dist[0][0][0] = 1;
        dist[0][0][1] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == n-1 && node.y == m-1) {
                bw.write(dist[node.x][node.y][node.z]+"");
                bw.flush();
                bw.close();
                System.exit(0);
            }
            int num = dist[node.x][node.y][node.z] + 1;
            for(int dir=0; dir<4; dir++){
                int nx = node.x +dx[dir];
                int ny = node.y +dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 0 && dist[nx][ny][node.z] == -1){
                    dist[nx][ny][node.z] = num;
                    queue.add(new Node(nx,ny,node.z));
                }
                if(node.z == 0 && map[nx][ny] == 1 && dist[nx][ny][1] == -1){
                    dist[nx][ny][1] = num;
                    queue.add(new Node(nx,ny,1));
                }
                
            }
        }
        bw.write(-1+"");
        bw.flush();
        bw.close();

    }
}