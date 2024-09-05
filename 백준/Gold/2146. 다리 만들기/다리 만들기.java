import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int x,y,num;
        public Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int[][] dist = new int[n][n];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 구분
        int num = 2;  // 섬 번호는 2부터 시작 (1은 육지를 의미하므로)
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1 && dist[i][j] == -1){
                    // 새로운 섬을 만나면 BFS로 섬 구분
                    Queue<Node> queue = new LinkedList<>();
                    dist[i][j] = 0;
                    board[i][j] = num;
                    queue.add(new Node(i, j, 0));

                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = node.x + dx[dir];
                            int ny = node.y + dy[dir];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(board[nx][ny] == 1 && dist[nx][ny] == -1){
                                board[nx][ny] = num;
                                dist[nx][ny] = 0;
                                queue.add(new Node(nx, ny, 0));
                            }
                        }
                    }
                    num++;  // 다음 섬은 다른 번호로 구분
                }
            }
        }

        // 섬 간 최소 거리 구하기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] > 1){  // 섬이면 BFS 시작
                    Queue<Node> queue = new LinkedList<>();
                    int[][] dist2 = new int[n][n];  // 새로운 BFS용 거리 배열
                    for(int[] row : dist2) Arrays.fill(row, -1);
                    queue.add(new Node(i, j, 0));
                    dist2[i][j] = 0;

                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = node.x + dx[dir];
                            int ny = node.y + dy[dir];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(board[nx][ny] > 1 && board[nx][ny] != board[i][j]){
                                // 다른 섬을 만나면 최소 거리 계산
                                ans = Math.min(ans, dist2[node.x][node.y]);
                                break;
                            }
                            if(board[nx][ny] == 0 && dist2[nx][ny] == -1){
                                dist2[nx][ny] = dist2[node.x][node.y] + 1;
                                queue.add(new Node(nx, ny, dist2[nx][ny]));
                            }
                        }
                    }
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
