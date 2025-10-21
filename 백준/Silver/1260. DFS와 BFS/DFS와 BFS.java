import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n, m, v;
        int arr[][] = new int[1002][1002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y]++;
            arr[y][x]++;
        }
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[1002];
        s.push(v);
        while(!s.isEmpty()){
            int cur = s.pop();
            if(visited[cur]) continue;
            visited[cur] = true;
            bw.write(cur+" ");
            for(int i=1000; i>=1; i--){
                if(arr[cur][i] > 0) s.push(i);
            }
        }
        bw.write("\n");
        Queue<Integer> q = new LinkedList<>();
        boolean visited2[] = new boolean[1002];
        q.add(v);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited2[cur]) continue;
            visited2[cur] = true;
            bw.write(cur+" ");
            for(int i=1; i<=1000; i++){
                if(arr[cur][i] > 0) q.add(i);
            }
        }
        bw.flush();
        bw.close();
    }
}