import java.io.*;
import java.util.*;

public class Main{
    static int[] s = new int[10];
    static int[] w = new int[10];
    static int n, mx=0, cnt=0;
    static void func(int k){
        if(k == n){
            mx = Math.max(mx,cnt);
            return;
        }
        if(s[k]<=0 || cnt == n-1){
            func(k+1);
            return;
        }
        for(int i=0; i<n; i++){
            if(i==k || s[i]<=0) continue;
            s[k]-=w[i];
            s[i]-=w[k];
            if(s[k]<=0) cnt++;
            if(s[i]<=0) cnt++;
            func(k+1);
            if(s[k]<=0) cnt--;  //원상복구
            if(s[i]<=0) cnt--;
            s[k] += w[i];
            s[i] += w[k];
        }
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }
        func(0);
        bw.write(mx+"");
        bw.flush();
        bw.close();
    }
}