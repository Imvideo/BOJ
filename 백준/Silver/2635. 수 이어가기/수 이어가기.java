import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int num, mx=0;
        num = Integer.parseInt(br.readLine());
        
        for(int i=num; i>=0; i--){
            ArrayList<Integer> tmp = new ArrayList<>();
            int n = i;
            tmp.add(num);
            tmp.add(n);
            int idx = 2;
            while(true){
                int x = tmp.get(idx-2) - tmp.get(idx-1);
                if(x < 0) break;
                tmp.add(x);
                idx++;
            }
            if(mx < tmp.size()){
                mx = tmp.size();
                ans = tmp;
            }
            
        }
        bw.write(mx+"\n");
        for(int i=0; i<mx; i++){
            bw.write(ans.get(i)+" ");
        }
        bw.flush();
        bw.close();
    }
}