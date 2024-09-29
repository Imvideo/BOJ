import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[] arr = new int[10];
    static int[] num;
    static boolean[] check = new boolean[10002];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException{
        if(k==m){
            for(int i=0; i<m; i++){
                bw.write(num[arr[i]]+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(k!=0 && num[arr[k-1]] > num[i]) continue;
            arr[k] = i;
            func(k+1);
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int idx=0;
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int val = Integer.parseInt(st.nextToken());
            if(check[val]) continue;
            check[val] = true;
            num[idx++] = val;
        }
        n = idx;
        Arrays.sort(num,0,n);
        func(0);
        bw.flush();
        bw.close();
    }
}