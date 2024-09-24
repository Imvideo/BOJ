import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[] arr = new int[10];
    static int[] num;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException{
        if(k==m){
            for(int i=0; i<k; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<n; i++){
            arr[k] = num[i];
            func(k+1);
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        func(0);
        bw.flush();
        bw.close();
    }
}