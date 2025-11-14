import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static int n, ans, mx=-1000000001, mn=1000000001;
    static int num[] = new int[13];
    static int cal[] = new int[4];
    static int calOrder[] = new int[13];

    static void func(int ans, int k){
        if(k==n){
            mx = Math.max(ans,mx);
            mn = Math.min(ans,mn);
            return;
        }
        for(int i=0; i<4; i++){
            if(cal[i] <= 0) continue;
            cal[i]--;
            if(i==0) func(ans+num[k],k+1);
            else if(i==1) func(ans-num[k],k+1);
            else if(i==2) func(ans*num[k],k+1);
            else if(i==3) func(ans/num[k],k+1);
            cal[i]++;
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }
        func(num[0], 1);
        bw.write(mx+"\n"+mn);
        bw.flush();
        bw.close();
    }
}