import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[] arr = new int[100002];
    static int[] vis = new int[100002];

    static void run(int x){
        int cur = x;
        while(true){
            vis[cur] = x;
            cur = arr[cur];
        
            if(vis[cur] == x){
                while(vis[cur]!=-1){
                    vis[cur] = -1;
                    cur = arr[cur];
                }
                return;
            }
            else if(vis[cur] != 0) return;
        }
    }

    public static void main(String[] args) throws IOException {
        int t, ans=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        for(int T=0; T<t; T++){
            int n = Integer.parseInt(br.readLine());
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                vis[i] = 0;
            }
            for(int i=1; i<=n; i++){
                if(vis[i] == 0) run(i);
            }
            for(int i=1; i<=n; i++){
                if(vis[i] != - 1) ans++;
            }
            bw.write( ans+"\n");
            
        }
        bw.flush();
        bw.close();
    }
}
