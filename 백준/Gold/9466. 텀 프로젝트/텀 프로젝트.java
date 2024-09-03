import java.io.*;
import java.util.*;

public class Main{
    static int[] arr = new int[100005];
    static int[] state = new int[100005];

    static void run(int x){
        int cur = x;
        while(true){
            state[cur] = x;
            cur = arr[cur];
            //이번 방문에서 지나간 학생에 도달한 경우
            if(state[cur] == x){
                while(state[cur] != -1){
                    state[cur] = -1;
                    cur = arr[cur];
                }
                return;
            }
            // 이전 방문에서 지나간 학생에 도달한 경우
            else if(state[cur] != 0) return; 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            
            for(int i=1;i<=n;i++) {
                state[i] = 0;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
            for(int i=1; i<=n; i++){
                if(state[i] == 0) run(i);
            }
            int cnt = 0;
            for(int i=1; i<=n; i++){
                if(state[i] != -1) cnt++;
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
    }
}