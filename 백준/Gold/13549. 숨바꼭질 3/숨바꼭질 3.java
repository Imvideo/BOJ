import java.io.*;
import java.util.*;

public class Main{
    static int k,n;
    static int[] board = new int[200005];
    static Queue<Integer> queue = new LinkedList<Integer>();
    static void teleport(int num){
        int tmp = num;
        if (tmp == 0) return;
        while(tmp < 100001 && board[k] == 0){
            if (board[tmp] == 0){
                board[tmp] = board[num];
                queue.add(tmp);
                if(tmp == k) return;
            }
            tmp *= 2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {1,-1};
        
        Arrays.fill(board,0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        board[n] = 1;
        queue.add(n);
        teleport(n);
        while(board[k] == 0){
            int v = queue.poll();
            for(int dir=0; dir<2; dir++){
                int nx = v + dx[dir];
                if(nx < 0 || nx >= 100001) continue;
                if(board[nx] >= 1) continue;
                board[nx] = board[v] + 1;
                queue.add(nx);
                teleport(nx);
            }
        }
        bw.write(board[k] - 1+"");
        bw.flush();
        bw.close();
    }
}