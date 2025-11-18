import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] board = new int[52][52];
    static boolean[] chosen;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();

    static void dfs(int idx, int cnt){
        if(cnt == m){
            ans = Math.min(ans, calDist());
            return;
        }
        if(idx == chicken.size()) return;

        chosen[idx] = true;
        dfs(idx+1, cnt+1);

        chosen[idx] = false;
        dfs(idx+1, cnt);
    }

    static int calDist(){
        int sum = 0;
        for(Point h : house){
            int mnDist = Integer.MAX_VALUE;
            for(int i=0; i< chicken.size(); i++){
                if(!chosen[i]) continue;
                Point cur = chicken.get(i);
                int dis = Math.abs(h.x - cur.x) + Math.abs(h.y - cur.y);
                mnDist = Math.min(mnDist, dis);
            }
            sum += mnDist;
        }
        return sum;
    }
    public static void main(String args[]) throws IOException{
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) house.add(new Point(i, j));
                else if(board[i][j] == 2) chicken.add(new Point(i, j));
            }
        }
        chosen = new boolean[chicken.size()];
        dfs(0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}