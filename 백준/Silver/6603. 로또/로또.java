import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int k;
    static int[] num;
    static int[] ans;
    static void func(int x, int idx) throws IOException {
        if(x == 6){
            for(int i=0; i<6; i++){
                bw.write(ans[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i = idx; i<k; i++){
            ans[x] = num[i];
            func(x+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException{
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            num = new int[k];
            ans = new int[6];
            for(int i=0; i<k; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            func(0,0);
            bw.write("\n");

        }

        bw.flush();
        bw.close();
    }
}